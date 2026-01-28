# update configmap 
kubectl -n config-hot-reload create configmap java-config \
  --from-literal=application.yaml='demo:
  message: "Updated from CLI!"
  flag: false
  version: 5' \
  -o yaml --dry-run=client | kubectl apply -f -
  

  kubectl -n config-hot-reload create configmap java-config \
  --from-file=application.yaml=application.yaml \
  -o yaml --dry-run=client | kubectl apply -f -