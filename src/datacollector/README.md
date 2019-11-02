# Data collector service

This service accepts text lines and prints 'm to system out

## build

build and deploy a container to Docker hub

    mvn clean package dockerfile:push
    
## run 

    docker run -p 8080:8080 jvermeir/datacollector:v1
    
or 

    java -jar target/datacollector-v1.jar
    
## test

    curl -d "logline=Line1" -X POST localhost:8083/store    
    