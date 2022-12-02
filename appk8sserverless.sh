mvn clean package -DskipTests

docker build -t ghcr.io/procceed-it/road-to-cloud-native:1.0.0 .
docker image push ghcr.io/procceed-it/road-to-cloud-native:1.0.0

kubectl create namespace weather-serverless
kubectl delete -f ./deploy/k8s-serverless/app-infra
kubectl apply -f ./deploy/k8s-serverless/app-infra

kubectl port-forward pod/"$(kubectl get pod -l app=istio-ingressgateway -n istio-system -o jsonpath='{.items[0].metadata.name}')" -n istio-system 8085:8080
