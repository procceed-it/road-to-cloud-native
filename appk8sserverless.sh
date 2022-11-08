mvn clean package -DskipTests

docker build -t joergfa/weather-app:1.0.0 .
docker image push joergfa/weather-app:1.0.0

kubectl create namespace weather-serverless
kubectl delete -f ./deploy/k8s-serverless/app-infra &&
kubectl apply -f ./deploy/k8s-serverless/app-infra
