Quick-Start:
1. ```docker run -p 8080:8080 ghcr.io/procceed-it/road-to-cloud-native:1.0.0```
2. open browser: ```http://localhost:8080/v1/weather?location=Nürnberg```

Local-Build:
1. build jar: ```mvn clean install```
2. build docker-image: ```docker build -t road-to-cloud-native:1.0.0 . ``` 
3. run container: ```docker run --name test -p 8080:8080 road-to-cloud-native:1.0.0```
4. open browser: ```http://localhost:8080/v1/weather?location=Nürnberg```

push-Build:
1. build jar: ```mvn clean install```
2. build docker-image: ```docker build -t road-to-cloud-native:1.0.0 . --platform linux/x86_64 ``` 
3. tag image: ```docker tag road-to-cloud-native:1.0.0 ghcr.io/procceed-it/road-to-cloud-native:1.0.0```
4. push image: ```docker push ghcr.io/procceed-it/road-to-cloud-native:1.0.0```
