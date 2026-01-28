
kubectl apply -f configmap.yaml
kubectl apply -f deployment.yaml
kubectl -n config-hot-reload port-forward svc/py-hot-reload-svc 8080:80
curl localhost:8080/config

# Configmap changes 
kubectl -n config-hot-reload create configmap py-config \
  --from-literal=config.yaml='message: "Updated without restart!"\nflag: false\nversion: 2' \
  -o yaml --dry-run=client | kubectl apply -f -

# Wait ~1 minute for projected volume refresh; the watcher will reload moments after
curl localhost:8080/config
# Expect: version: 2 and updated message/flag