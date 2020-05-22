
# Deploy an Azure Kubernetes Service cluster

## Prerequisites

This example assumes you have previously completed the following example.

1. [Create an Azure Resource Group](../resourcegroup-create/README.md)

## Deploy an Azure Kubernetes Service cluster

To deploy the Azure Kubernetes Service cluster use the following command line:

```shell
 az aks create --name AKS_NAME --resource-group examples-rg --verbose 
```

Where `AKS_NAME` should be replaced by a unique name you will be using for this
Azure Kubernetes Service cluster. If the `AKS_NAME` you picked is in use the
creation of the Azure Kubernetes Service cluster will fail and you will have to
try again with another name.

After the Azure Kubernetes Service cluster is successfully created capture the
`AKS_NAME` you picked as it is needed when interacting with your Azure Kubernetes
Service cluster.

## Cleanup

Do NOT forget to remove the Azure Kubernetes Service cluster once you are done
running the example.
