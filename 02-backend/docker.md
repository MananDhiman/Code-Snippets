# Docker
## Commands
```sh
docker build -t docker-test .

docker image ls # list all images 

docker run -p 8080:8081 -it <docker-name>
```
```Dockerfile
# Dockerfile
FROM golang:1.12.0-alpine3.9 # pull dockerfile from repo
RUN mkdir /app               # create dir in pulled dockerfile
ADD . /app                   # added files in curr dir, to /app of docker
WORKDIR /app                 # set working dir as /app
RUN go build -o main .       # built go app and executabe named main
CMD ["/app/main"]            # run exe
```
