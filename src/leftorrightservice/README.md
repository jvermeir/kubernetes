# Left or right service

This service will tell you to go LEFT nine times out of ten and otherwise it will say RIGHT

## build

build and deploy a container to Docker hub

    mvn clean package dockerfile:push
    
## run 

    docker run -p 8080:8080 jvermeir/leftorrightservice:v1
    
or 

    java -jar target/leftorrightservice-v1.jar
    
## test

    curl localhost:8080/left-or-right    
    