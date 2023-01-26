minikube start
export MKIP=$(minikube ip)
#sed -i "" "s/IPADDR/$MKIP/" metallb/metallb.yaml
kubectl apply -f https://raw.githubusercontent.com/metallb/metallb/v0.9.6/manifests/namespace.yaml
kubectl apply -f https://raw.githubusercontent.com/metallb/metallb/v0.13.7/config/manifests/metallb-native.yaml
minikube addons enable metallb
kubectl apply -f metallb/metallb.yaml
#sed -i "" "s/$MKIP/IPADDR/" metallb/metallb.yaml
kubectl apply -f java-app/java-app.yaml


#minikube ip
