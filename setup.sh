
# Enabling metallb addons and configuring
# echo "Enabling metallb addons and configuring:"
# docker rmi $(docker images -q)
minikube start --vm-driver=virtualbox
# minikube start
kubectl apply -f https://raw.githubusercontent.com/metallb/metallb/v0.9.6/manifests/namespace.yaml
kubectl apply -f https://raw.githubusercontent.com/metallb/metallb/v0.9.6/manifests/metallb.yaml
# On first install only
# kubectl create secret generic -n metallb-system memberlist --from-literal=secretkey="$(openssl rand -base64 128)"
minikube addons enable metallb
# export METALLBIP=`ipconfig getifaddr en0`-`ipconfig getifaddr en0`
# export METALLBIP=`ifconfig vboxnet0 inet | awk '{print $2}' | sed '2!D'`-`ifconfig vboxnet0 inet | awk '{print $2}' | sed '2!D'`
# sed -i "" "s/IPADD/$METALLBIP/" src/metallb/metallb.yaml
kubectl apply -f src/metallb/metallb.yaml

# Build images
eval $(minikube -p minikube docker-env)
# docker rmi $(docker images -aq)
#echo "Build java-app images:"
#docker build -t gedgrus/java-app:latest java-app

# Applying java-app yaml file
echo "Applying nginx yaml file:"
kubectl apply -f java-app/java-app.yaml
