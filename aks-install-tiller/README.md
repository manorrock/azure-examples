
# Install Tiller on your Azure Kubernetes Service cluster (using Helm 2)

```text
Note for production environments we recommend you configure RBAC to
limit access to what a Helm client and Tiller can access
```

## Prerequisites

This example assumes you have previously completed the following examples.

1. [Create an Azure Resource Group](../resourcegroup-create/README.md)
1. [Deploy an Azure Kubernetes Cluster](../aks-create/README.md)
1. [Create Kube config file for your Azure Kubernetes Service (using admin access)](../aks-create-kube-config/README.md)

## Install Tiller

----

Installing Helm 2 is not covered here. If you need to install Helm 2, please go 
to [Installing Helm 2](https://v2.helm.sh/docs/using_helm/#installing-helm).

----

Use the following Maven command line to install Tiller on your Azure Kubernetes Service cluster

````shell
  mvn package
````

Note this example assumes that you have already set ```kubectl``` to use the right context.

## Cleanup

Do NOT forget to remove the resources you might have created once you are done running the example.
