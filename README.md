# k8-nagp

Github Repo Link:
===============
https://github.com/rpyadav87/k8-nagp.git

Docker hub URL:
==============
https://hub.docker.com/repository/docker/ravi1387/k8-nagp/general

docker pull ravi1387/k8-nagp

Minikube command:
================
1. minikube start
2. minikube dashboard

Command to run:
===============
1. kubectl apply -f .\mysql-configmap.yaml
2. kubectl apply -f .\mysql-secrets.yaml
3. kubectl apply -f .\k8-database.yaml   
4. kubectl apply -f .\k8-serviceapi.yaml
5. kubectl get services // this will not provide the EXTERNAL_IP but the external port is 
   available kubectl get pods.
   Note: we can skip step 5 as service is exposed as NodePort on port 30080 
6. minikube ip // to get the external ip to access from outside
7. Application Health check:
   GET curl http://minikube-external-ip:external-port/api/v1/health
   Example: curl 'http://172.24.160.22:30080/api/v1/health'

URL Service API tier:
===================

1. Get all users:  
   curl http://172.24.160.22:30080/api/v1/users
2. Add user:
   curl --location 'http://172.24.160.22:30080/api/v1/user' \
   --header 'Accept: application/json' \
   --header 'Content-Type: application/json' \
   --data-raw '{
   "firstName": "Rajesh",
   "lastName": "Sharma",
   "email": "rajesh@gmail.com"
   }'
3. Get user by id:
   curl --location 'http://172.24.160.22:30080/api/v1/user/1' \
   --header 'Accept: application/json'

Create database:
================
create database users;

Use Ingress:
=============
minikube addons enable ingress kubectl apply -f .\app-ingress.yaml

1. Make entry in windows host file to access host using windows C:\Windows\System32\drivers\etc -
   {{minikube ip we need to place here }} k8crudapp.info Note: k8crudapp.info - host defined inside
   ingress.yml file
2. Make entry in minikube host file - to map ip with host. If we use curl on putty then we dont need
   earlier step 1 minikube ssh -> sudo vi /etc/hosts  
   make entry - {{minikube ip}} k8crudapp.info // same as windows Other way to edit minikube host
   file via putty as:
   Provide Host name as minikube ip : 172.23.202.223 login as: docker /tcuser , now edit
3. Now access w/o port: http://k8crudapp.info/api/v1/health

Link:
=======
https://kubernetes.io/docs/tasks/access-application-cluster/ingress-minikube/
