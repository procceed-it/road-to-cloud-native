# download istio
# curl -L https://istio.io/downloadIstio | sh -
# cd istio-1.15.3
# export PATH=$PWD/bin:$PATH

# start minikube
minikube delete &&
minikube start --memory=6000 --cpus=2 --ports=31000:31000 # --extra-config=apiserver.service-node-port-range=30000-32767 --ports=30000-32767:30000-32767 &&
minikube addons enable ingress

# install istio
istioctl install --set profile=demo -y &&
kubectl label namespace default istio-injection=enabled &&
kubectl wait --for=condition=ready pod -l app=istio-ingressgateway -n istio-system &&

# install Knative Serving component
kubectl apply -f https://github.com/knative/serving/releases/download/knative-v1.8.0/serving-crds.yaml &&
kubectl apply -f https://github.com/knative/serving/releases/download/knative-v1.8.0/serving-core.yaml

# install Knative Istio controller
kubectl apply -f https://github.com/knative/net-istio/releases/download/knative-v1.8.0/net-istio.yaml

kubectl apply -f deploy/k8s-serverless/cluster-infra/

# port-forward to istio-ingress
kubectl port-forward pod/"$(kubectl get pod -l app=istio-ingressgateway -n istio-system -o jsonpath='{.items[0].metadata.name}')" -n istio-system 8085:8080