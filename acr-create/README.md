
# Deploy an Azure Container Registry

## Prerequisites

This example assumes you have previously completed the following example.

1. [Create an Azure Resource Group](../resourcegroup-create/README.md)

## Deploy a basic Azure Container Registry

To deploy the basic Azure Container Registry use the following command line:

```shell
 az acr create --name ACR_NAME --resource-group examples-rg --sku Basic  --admin-enabled true --verbose 
```

Where `ACR_NAME` should be replaced by a unique name you will be using for this
Azure Container Registry. If the `ACR_NAME` you picked is in use the creation of 
the Azure Container Registry will fail and you will have to try again with
another name.

After the Azure Container Registry is successfully created capture the `ACR_NAME`
you picked as it is needed when interacting with your Azure Container Registry.

## Cleanup

Do NOT forget to remove the Azure Container Registry once you are done running the
example.
