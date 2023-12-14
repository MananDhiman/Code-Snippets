# HTTP
HTTP is stateless, each request independent. Local storage, cookies, session used.

HTTPS
SSL (Secure socket layer), TLS (transport security layer). Install certificate on web host

**Status code - 100 to 500**
* 100 - informational
* 200 - success
* 300 - redirect (further action to be taken)
* 400 - client err
* 500 - server err

**Common Codes**
* 200 - ok
* 201 - ok created
* 301 - moved to new url
* 304 - not modified (cached)
* 400 - bad req
* 401 - unauthorized
* 404 - not found
* 500 - internal server err

**Common Ports**
- 20 - FTP
- 22 - SSH
- 80 - default HTTP
- 443 - HTTPS
- 3306 - MySQL
- 5432 - PostgreSQL
- 27017 - MongoDB

**Methods**
* get -> request resource from server
* post -> send resource signup
* put /patch -> put is replace all, patch is update ‘component’
* delete -> delete

For each method we have header and body. Body will be the html page or the json data from server

For request body we have form fields. There are request headers, response and general headers

Common general Header: 
* Request URL, req method, status code, referrer policy

Response
* server (apache, ngnix), cookie - small data, content type - html, css, img, json, content length - octet, date

Request header cookies
* accept-xxx encoding charac, content type - json, content length, authorization, user agent - software user is using, referrer

## Params
* ? is query parameter
* / is path parameter

`https://ab.com/a-path/?query=abc&query2=xyz`

# cURL (client URL)
transfer data to and from server using command line. http, ftp, imap, pop3, smap
```
curl -i <url>. 
// Gets the body, with all the header info

curl --head
curl -o file.txt <url>
curl -O <url> downloads file
```
```
Request
POST: curl --data "title=Hello&body=Hello World" <url>
PUT: curl -X PUT "title=Hello&body=Hello World" <url>
DEL: curl -X DELETE <url>
Authentication (Secure Route):
curl -u <username>:<password> <url>
FTP:
curl -u <FTP-account>:><password> -T <file-name> <ftp-url>
```