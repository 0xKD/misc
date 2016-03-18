var express = require('express');
var bodyParser = require('body-parser');
var randomstring = require('randomstring');
var ig = require('instagram-node').instagram();

var app = express();

app.use(bodyParser.json());

var config = {
  host: '127.0.0.1',
  port: '8020',
  token: process.env.INSTA_TOKEN,
  redirect_uri: process.env.INSTA_REDIRECT_URI
};

console.log(config);

ig.use({
  client_id: process.env.INSTA_CLIENT_ID,
  client_secret: process.env.INSTA_CLIENT_SECRET,
});

// auth redirect
app.get('/insta/auth', function(req, resp) {
  resp.redirect(ig.get_authorization_url(config.redirect_uri));
});

// auth handle
app.get('/insta/authcallback', function(req, resp) {
  ig.authorize_user(req.query.code, config.redirect_uri, function(err, result) {
    if (err) {
      console.log(err);
      resp.status(400).send('Error authenticating');
    } else {
      console.log('got access token:' + result.access_token);
      resp.status(200).send('Auth successful');
    }
  });
});

// Instagram realtime update subscription callback
app.get('/insta/subcallback', function(req, resp) {
  if (req.query['hub.mode'] === 'subscribe' &&
      req.query['hub.verify_token'] === config.token) {
    resp.status(200).send(req.query['hub.challenge']);
  } else {
    resp.status(403).send('nope');
  }
});

app.post('/insta/subcallback', function(req, resp) {
  resp.status(200).send('ok');
  console.log(req.body);
});

app.get('/auth/test/', function(req, resp) {
  resp.status(200).send('<a href="instagram://oauth/authorize/?client_id=CLIENT-ID&redirect_uri=REDIRECT-URI&response_type=code">insta</a>');
});

app.listen(config.port);
