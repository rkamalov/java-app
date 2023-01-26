
export KUBECONFIG=$(pwd)/kubernetes-cluster-5554_kubeconfig.yaml
# kubectl proxy
kubectl config get-contexts
echo "Applying java-app yaml file:"
kubectl apply -f java-app/java-app.yaml
kubectl get svc

# curl 185.241.192.1:9092/actuator/health
