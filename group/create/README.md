
# Create an Azure Resource Group

## Prerequisites

This example assume you are logged into Azure CLI and have set your default
subscription, if you have NOT done so please go to our top-level
[README](../../)

## Create the Resource Group

To create the Resource Group use the following command line:

```
  export RESOURCE_GROUP=azure-examples

  az group create --name $RESOURCE_GROUP --location 'West US 2'
```

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

## Next steps

1. [Manage resource groups and template deployments](https://docs.microsoft.com/en-us/cli/azure/group)

1m
