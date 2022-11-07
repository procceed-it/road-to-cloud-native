minikube delete -p cluster10

minikube start -p cluster10 --memory 3000m --ports=31000:31000
minikube addons enable ingress -p cluster10

eval $(minikube docker-env -p cluster10)

# weather-app
mvn clean install
docker build -t weather-app:1.0.0 .
# minikube image load weather-app:1.0.0 -p cluster10 --overwrite
kubectl apply -f ./deploy/k8s-standard/

kubectl port-forward svc/ingress-nginx-controller 8082:80 -n ingress-nginx

eval $(minikube docker-env -u)
