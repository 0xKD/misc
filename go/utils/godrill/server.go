package main

import (
	"./mandrill"
	"encoding/json"
	"fmt"
	"github.com/gorilla/schema"
	"net/http"
)

func main() {
	const port = 8080
	http.HandleFunc("/mail", viewHandler)
	fmt.Printf("[+] Listening on :%d\n", port)
	http.ListenAndServe(fmt.Sprintf(":%d", port), nil)
}

func viewHandler(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "text/plain")
	if r.Method == "POST" {
		var m MandrillEvents
		var mails []mandrill.Mail
		err := r.ParseForm()
		if err != nil {
			fmt.Print("[!] Post data not a form\n")
			return
		}
		decoder := schema.NewDecoder()
		err = decoder.Decode(&m, r.PostForm)
		if err != nil {
			fmt.Printf("[!] Error decoding: %s\n", err)
			return
		}
		err = json.Unmarshal([]byte(m.Events), &mails)
		if err != nil {
			fmt.Printf("[!] Error: %s\n", err)
		}
		fmt.Printf("[+] Received mail from: (%s)\n", mails[0].Msg.Headers.From)
	}
	fmt.Fprintf(w, "ok")
}

type MandrillEvents struct {
	Events string `schema:"mandrill_events"`
}
