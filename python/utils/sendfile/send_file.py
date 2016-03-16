#!/usr/bin/python

import base64
import magic
import mandrill
import os
import sys

mandrill_client = mandrill.Mandrill(os.environ['MANDRILL_API_KEY'])
mime = magic.Magic(mime=True)

if __name__ == '__main__':
    if len(sys.argv) < 2:
        sys.stderr.write('[!] Not enough arguments\n')
        sys.exit()
    files = sys.argv[1]
    email = sys.argv[2]
    message = {
        'attachments': [],
        'html': '',
        'text': '',
        'subject': "Here's the file you wanted!",
        'from_email': os.environ['SENDFILE_FROM_EMAIL'],
        'from_name': os.environ['SENDFILE_FROM_NAME'],
        'to': [{'email': email}],
        'auto_text': True,
        'auto_html': True,
    }
    for file_ in files.split(','):
        with open(file_, 'r') as f:
            encoded = base64.b64encode(f.read())
            message['attachments'].append({
                'content': encoded,
                'name': os.path.basename(file_),
                'type': mime.from_file(file_),
            })
    try:
        result = mandrill_client.messages.send(message=message)
        sys.stderr.write('{}\n'.format(result))
    except mandrill.Error, e:
        sys.stderr.write('[!] Mandrill error ocurred: {} - {}\n'.format(e.__class__, e))
