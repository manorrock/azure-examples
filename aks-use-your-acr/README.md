
# Update your AKS cluster to use your Azure Container Registry

## Prerequisites

This example assumes you have previously completed the following examples.

1. [Create an Azure Resource Group](../resourcegroup-create/README.md)
1. [Deploy an Azure Kubernetes Cluster](../aks-create/README.md)

## Update your AKS cluster to use your Azure Container Registry

To update your AKS cluster to make it so it can access your Azure Container
Registry you need to use the following command line.


````shell
  mvn package -Dexample.clusterName=CLUSTERNAME -Dexample.registry=REGISTRY
````

Where ```CLUSTERNAME``` is the name of your Azure Kubernetes Service cluster, and
`REGISTRY` is the name of your Azure Container Registry.

### Properties supported by the example

The example supports the following properties that you can pass in as -Dname=value to the Maven command line to customize your deployment.

| name                      | description                               |
|---------------------------|-------------------------------------------|
| example.clusterName       | the name of the AKS cluster               |
| example.resourceGroup     | the Resource Group to use                 |
| example.registry          | the name of the Container Registry        |

## Cleanup

Do NOT forget to remove the Resource Group once you are done running the example.