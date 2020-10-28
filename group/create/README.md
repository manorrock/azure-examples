
# Create an Azure Resource Group

## Prerequisites

This example assume you are logged into Azure CLI and have set your default
subscription, if you have NOT done so please go to our top-level
[README](../../)

## Create the Resource Group

To create the Resource Group use the following command line:

```
  export RESOURCE_GROUP=azure-examples
  export REGION=westus2
```

<!-- GitHub workflow
export RESOURCE_GROUP=azure-examples-$RANDOM
  -->

```
  az group create --name $RESOURCE_GROUP --location $REGION
```

<!-- GitHub workflow - direct-only
export RESULT=$(az group show --name $RESOURCE_GROUP --output tsv --query properties.provisioningState)
az group delete --name $RESOURCE_GROUP --yes || true
if [[ "$RESULT" != Succeeded ]]; then
  exit 1
fi
  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

## Next steps

1. [Manage resource groups and template deployments](https://docs.microsoft.com/en-us/cli/azure/group)

1m
