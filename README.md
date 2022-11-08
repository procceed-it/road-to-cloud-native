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


## Local K8s-Minikube-Deployments
Voraussetzungen:
- lokale Minikube-Installation ```https://minikube.sigs.k8s.io/docs/start/```
- Istio-Download/PATH setzen ```https://istio.io/latest/docs/setup/getting-started/``` -> "Download Istio"
    - Hinweis: der PATH sollte shell-übergreifend gesetzt werden und nicht nur für die aktuelle shell
- Einträge in ```etc/hosts``` (Mac/Linux)
  - ```127.0.0.1 weather.com``` 
  - ```127.0.0.1 weather-app.weather-serverless.weather-knative.com```
- Minikube-Cluster mit Istio/Knative starten:
  - ```sh init-k8s-knative.sh```

### K8s-Stufe 1: Standard-Deployment - konventionelle Spring-Boot Applikation
Deployment der Weather-App in Minikube-Cluster
1. ```sh appk8sstandard.sh```
2. kurz warten
3. open browser: ```http://weather.com:8082/v1/weather?location=N%C3%BCrnberg```

### K8s-Stufe 2: Serverless-Deployment - konventionelle Spring-Boot Applikation
Deployment der Weather-App in Minikube-Cluster
1. ```sh appk8sserverless.sh```
2. kurz warten
3. open browser: ```http://weather-app.weather-serverless.weather-knative.com:8085/v1/weather?location=N%C3%BCrnberg```

### K8s-Stufe 3: Serverless-Deployment - Spring-Boot-Native Applikation
- TODO - vielleicht

### K8s-Stufe 4: Serverless-Deployment - Spring-Boot-Native Applikation als Function
- TODO - vielleicht

Tools für die Analyse:
- Minikube Dashboard: ```minikube dashboard```


