
# Deploy an Azure Container Registry

## Prerequisites

This example assumes you have previously completed the following example.

1. [Create an Azure Resource Group](../resourcegroup-create/README.md)

## Deploy the Azure Container Registry

To deploy the Azure Container Registry use the following Maven command line.

````shell
  mvn package
````

### Properties supported by the example

The example supports the following properties that you can pass in as -Dname=value to the Maven command line to customize your deployment.

| name                      | description                               |
|---------------------------|-------------------------------------------|
| example.adminEnabled      | enable the admin access keys (true/false) |
| example.resourceGroup     | the Resource Group to use                 |
| example.containerRegistry | the name of the Container Registry        |
| example.sku               | the SKU to use                            |

## Cleanup

Do NOT forget to remove the Resource Group once you are done running the example.
