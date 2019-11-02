# myservice

This service offers two endpoints that can be used for test purposes. 

## build

build and deploy a container to Docker hub

    mvn clean package dockerfile:push
    
## run 

    docker run -p 8080:8080 jvermeir/myservice:v1
    
or 

    java -jar target/myservice-v1.jar
    
## test

    curl localhost:8080/counter
    curl localhost:8080/whatTimeIsItAnyway    
    