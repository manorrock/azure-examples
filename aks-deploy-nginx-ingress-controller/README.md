
# Deploy an NGINX Ingress Controller on your AKS cluster (using Helm 2)

## Prerequisites

This example assumes you have previously completed the following examples.

1. [Create an Azure Resource Group](../resourcegroup-create/README.md)
1. [Deploy an AKS cluster](../aks-create/README.md)
1. [Create Kube config file for your AKS cluster (using admin access)](../aks-create-kube-config/README.md)
1. [Install Tiller on your AKS cluster (using Helm 2)](../aks-install-tiller/README.md)

And it also assumes you have installed both `helm` and `kubectl`. If you need to install `helm`, please go to [Installing Helm 2](https://v2.helm.sh/docs/using_helm/#installing-helm). If you need to install `kubectl`, please go to [Install and Setup kubectl](https://kubernetes.io/docs/tasks/tools/install-kubectl/)

## Deploy the NGINX Ingress Controller

Use the following Maven command line to deploy an NGINX Ingress Controller on your AKS cluster

````shell
  mvn package
````

Note this example assumes that you have already set ```kubectl``` to use the right context.

To get the External IP of the NGINX Ingress Controller you can use the command line below

````shell
  kubectl --namespace ingress-basic get services -o wide nginx-ingress-controller
````

## Cleanup

Do NOT forget to remove the resources you might have created once you are done running the example.
