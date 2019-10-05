# Kubernetes experiments

## install

  https://minikube.sigs.k8s.io/docs/start/macos/

## tutorials

  https://kubernetes.io/docs/tutorials/hello-minikube/
  https://codeburst.io/getting-started-with-kubernetes-deploy-a-docker-container-with-kubernetes-in-5-minutes-eb4be0e96370

## stuff 

minikube starts a cluster

    minikube start

services (?) running in a cluster:

    kubectl get po -A

A Kubernetes *Pod* is a group of one or more Containers, tied together for the purposes of administration and networking.
A Kubernetes *Deployment* checks on the health of your Pod and restarts the Pod’s Container if it terminates. Deployments are the recommended way to manage the creation and scaling of Pods.    

after this

    kubectl create deployment hello-node --image=gcr.io/hello-minikube-zero-install/hello-node

you get a deployment and a pod 

    kubectl get deployments
    kubectl get pods

To make the hello-node Container accessible from outside the Kubernetes virtual network, you have to expose the Pod as a Kubernetes *Service*.

    kubectl expose deployment hello-node --type=LoadBalancer --port=8080

    kubectl get services

Open service in a browser: 

    minikube service hello-node
    
Show Kubernetes dashboard    
    
    minikube dashboard
    
## Build myservice

To connect to the Docker registry inside the Minikube VM:

    eval $(minikube docker-env) # this should use the docker build environment from Kubernetes. 

But how do we use containers that are built locally? For now we'll push to Docker hub.

    cd src/myservice
    mvn clean install
    docker build .  -t jvermeir/myservice
    docker push jvermeir/myservice
    docker run -p 8082:8082 myservice
    curl localhost:8082/counter
    
or use Maven 

    mvn clean package
    mvn dockerfile:push
    
see  [https://blog.madadipouya.com/2019/07/14/how-to-use-spotify-docker-maven-plugin/][how-to-use-spotify-docker-maven-plugin] 
Don't forget to add a ~/.m2/settings.xml file as described in the blog.  
    
    kubectl create -f src/main/resources/myservice-deployment.yaml 
    kubectl expose deployment myservice-deployment --type=LoadBalancer --port=8082
    minikube service myservice-deployment  # add /counter in the url bar
        # get the url from the browser and use for curls
    kubectl scale --replicas=3 -f src/main/resources/myservice-deployment.yaml
    
## Docker stuff 
    
    https://cloud.docker.com/u/jvermeir/repository/docker/jvermeir/myservice
    https://registry.hub.docker.com/v2/repositories/docker/jvermeir/shop-shop/tags    
    curl -u $USERNAME:$PASSWORD -X "DELETE" https://cloud.docker.com/v2/repositories/jvermeir/shop-shop/tags/v1/
