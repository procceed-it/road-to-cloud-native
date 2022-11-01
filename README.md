## Local-jar-Deployment
Voraussetzungen:
- mvn: ```https://maven.apache.org/install.html```
- java-runtime: ```https://www.oracle.com/java/technologies/downloads/```

Quick-Start:
1. ```mvn clean package && mvn exec:java```
2. open browser: ```http://localhost:8080/v1/weather?location=Nürnberg```

## Local-Docker-Deployment
Voraussetzungen (für Quick-Start):
- Docker: ```https://docs.docker.com/desktop/install/mac-install/```

Quick-Start:
1. ```docker run -p 8081:8080 ghcr.io/procceed-it/road-to-cloud-native:1.0.0```
2. open browser: ```http://localhost:8080/v1/weather?location=Nürnberg```

Local-Build + Run:
1. build jar: ```mvn clean install```
2. build docker-image: ```docker build -t road-to-cloud-native:1.0.0 . ``` 
3. run container: ```docker run --name test -p 8080:8080 road-to-cloud-native:1.0.0```
4. open browser: ```http://localhost:8081/v1/weather?location=Nürnberg```

## AWS-EC2-Deployment (TODO)
1. Local-Build + Push-Build to remote Image-Registry:
   1. build jar: ```mvn clean install```
   2. build docker-image: ```docker build -t road-to-cloud-native:1.0.0 . --platform linux/x86_64 ```
   3. tag image: ```docker tag road-to-cloud-native:1.0.0 ghcr.io/procceed-it/road-to-cloud-native:1.0.0```
   4. push image: ```docker push ghcr.io/procceed-it/road-to-cloud-native:1.0.0```
2. Start EC2-Instance with Docker
3. Deploy Dockerimage in EC2-Instance


## Local K8s-Minikube-Deployment
Voraussetzungen:
- lokale Minikube-Installation ```https://minikube.sigs.k8s.io/docs/start/```
- Eintrag in ```etc/hosts``` : ```127.0.0.1 weather.com``` (Mac/Linux)

Quick-Start:
1. ```sh init-k8s-standard.sh```
2. open browser: ```http://weather.com:8082/v1/weather```

Tools:
- Minikube Dashboard: ```minikube dashboard -p cluster10```


