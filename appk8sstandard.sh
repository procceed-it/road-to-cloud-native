eval $(minikube docker-env)

mvn clean install

docker build -t weather-app:1.0.0 .

kubectl delete -f ./deploy/k8s-standard/app-infra
kubectl apply -f ./deploy/k8s-standard/app-infra

kubectl port-forward svc/ingress-nginx-controller 8082:80 -n ingress-nginx

eval $(minikube docker-env -u)