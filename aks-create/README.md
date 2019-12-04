
# Deploy an Azure Kubernetes Service cluster

## Prerequisites

This example assumes you have previously completed the following example.

1. [Create an Azure Resource Group](../resourcegroup-create/README.md)

## Deploy the Azure Kubernetes Service cluster

To deploy the Azure Kubernetes Service cluster use the following Maven command line.

````shell
  mvn package
````

### Properties supported by the example

The example supports the following properties that you can pass in as -Dname=value to the Maven command line to customize your deployment.

| name                      | description                               |
|---------------------------|-------------------------------------------|
| example.resourceGroup     | the Resource Group to use                 |
| example.clusterName       | the name of the cluster                   |

## Cleanup

Do NOT forget to remove the Resource Groups once you are done running the example.
