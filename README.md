## Python deployment 

``` docker build -t python-config-demo:v1 -f .```

``` kubectl apply -f python-deployment.yaml ```

``` kubectl port-forward deployment/python-demo 5000:5000 ```

``` curl localhost:5000 ```

``` kubectl edit configmap demo-config```

## Java

```docker build -t java-config-demo:v1 -f  . ```

``` kubectl apply -f java-deployment.yaml ```

```kubectl port-forward deployment/java-demo 8080:8080```

``` curl localhost:8080 ```

```kubectl edit configmap demo-config```

## Node Js


```docker build -t node-config-demo:v1 -f  . ```

``` kubectl apply -f node-deployment.yaml ```

```kubectl port-forward deployment/node-demo 8080:8080```

``` curl localhost:8080 ```

```kubectl edit configmap demo-config```
