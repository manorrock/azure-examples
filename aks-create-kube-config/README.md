
# Create a Kubeconfig file for your Azure Kubernetes Service (using admin access)

```text
Note for production environments we recommend you configure RBAC to
limit access to your Kubernetes cluster based on roles.
```

## Prerequisites

This example assumes you have previously completed the following examples.

1. [Create an Azure Resource Group](../resourcegroup-create/README.md)
1. [Deploy an Azure Kubernetes Cluster](../aks-create/README.md)

## Create a Kubeconfig file

To create the Kubeconfig file use the following command line:

```shell
 az aks get-credentials --resource-group examples-rg --name AKS_NAME --admin --file config
````

Where `AKS_NAME` should be replaced by the name of your Azure Kubernetes Service
cluster.

Once the command completes the Kubeconfig file is stored in a file named `config`

## Cleanup

Do NOT forget to remove the Azure Kubernetes Service cluster once you are done
with the example.
