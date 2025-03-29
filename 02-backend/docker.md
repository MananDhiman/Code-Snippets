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

```
docker build -t <image-name>
docker images – list local images
docker rmi <image name> – delete image
docker rm name
docker rm -f force -v remove volumes -l remove link mentioned
docker image prune – delete unused images
docker search <image name> – search hub image
docker pull <image name> – pull image
docker run –name <custom name> <image name> 
docker run -p host_port:container_port image_name
docker run -d image name
docker start|stop container_name
docker exec -it <container_name> sh – open shell inside container
docker exec -d run_in_bg -e set env vars -i will keep stdin open
docker inspect <container name>
docker ps – currently running containers 
docker ps -a running and stopped
docker ps -q show only id
```