package main

import (
	"encoding/json"
	"fmt"
	"io"
	"log"
	"net/http"

	"github.com/gocql/gocql"
)

type appConfig struct {
	dbKeyspace string
	dbCluster  []string
}

type appContext struct {
	db *gocql.Session
}

type message struct {
	ID      gocql.UUID
	Source  string
	Text    string `json:"text"`
	Channel string `json:"channel"`
}

type messageList struct {
	Messages []message `json:"messages"`
}

const defaultChannel = "#all"

func makeMessage(reader io.Reader, source string) (message, error) {
	msg := message{Channel: defaultChannel}
	dec := json.NewDecoder(reader)
	if err := dec.Decode(&msg); err != nil {
		return message{}, err
	}
	msg.Source = fmt.Sprintf("@%s", source)
	msg.ID = gocql.TimeUUID()
	return msg, nil
}

func createSession(keyspace string, hosts []string) *gocql.Session {
	c := gocql.NewCluster(hosts...)
	c.Keyspace = keyspace
	c.Consistency = gocql.Quorum

	session, err := c.CreateSession()
	if err != nil {
		log.Fatal(err)
	}
	return session
}

func main() {
	config := &appConfig{
		dbKeyspace: "mixedquantum",
		dbCluster:  []string{"127.0.0.1"},
	}

	context := &appContext{
		db: createSession(config.dbKeyspace, config.dbCluster),
	}

	http.HandleFunc("/send", context.messageHandler)
	http.HandleFunc("/list", context.viewMessages)
	http.ListenAndServe(":8900", nil)
}

func (context *appContext) viewMessages(writer http.ResponseWriter, request *http.Request) {
	if request.Method != "GET" {
		writer.Header().Set("Allow", "GET")
		writer.WriteHeader(http.StatusMethodNotAllowed)
		return
	}

	writer.Header().Add("Content-Type", "application/json")
	messages := messageList{context.getMessages(defaultChannel)}
	enc := json.NewEncoder(writer)
	if err := enc.Encode(&messages); err != nil {
		log.Fatal(err)
	}
	return
}

func (context *appContext) messageHandler(writer http.ResponseWriter, request *http.Request) {
	if request.Method != "POST" {
		writer.Header().Set("Allow", "POST")
		writer.WriteHeader(http.StatusMethodNotAllowed)
		return
	}

	if request.Body != nil {
		msg, err := makeMessage(request.Body, request.RemoteAddr)
		if err != nil {
			log.Fatal(err)
		}
		writer.WriteHeader(http.StatusCreated)
		context.writeMessage(msg)
	}
}

func (context *appContext) writeMessage(msg message) {
	if err := context.db.Query(
		`insert into messages (id, message, source, channel) values (?, ?, ?, ?)`,
		msg.ID, msg.Text, msg.Source, msg.Channel).Exec(); err != nil {
		log.Fatal(err)
	}
}

func (context *appContext) getMessages(channelToSearch string) []message {
	var messages []message
	var (
		id      gocql.UUID
		text    string
		channel string
		source  string
	)

	iter := context.db.Query(
		`select id, message, source, channel from messages where channel = ?`,
		channelToSearch).Iter()
	for iter.Scan(&id, &text, &source, &channel) {
		messages = append(messages, message{id, source, text, channel})
	}
	return messages
}
