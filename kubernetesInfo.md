# Kubernetes experiments

## install

  https://minikube.sigs.k8s.io/docs/start/macos/

## tutorial minikube

  https://kubernetes.io/docs/tutorials/hello-minikube/

## stuff 

minikube starts a cluster

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