
# Create an Azure Resource Group

## Prerequisites

This example assume you are logged into Azure CLI and have set your default
subscription, if you have NOT done so please go to our top-level
[README](../../)

## Create the Resource Group

To setup the environment variables needed to create the Resource Group execute
the command lines below:

<!-- workflow.skip() -->
```shell
  export RESOURCE_GROUP=azure-examples
  export REGION=westus2
```

<!-- workflow.run()
if [[ -z $RESOURCE_GROUP ]] then;
  export RESOURCE_GROUP=azure-examples-$RANDOM
fi
export REGION=westus2
  -->

To create the Resource Group use the following command line:

```shell
  az group create --name $RESOURCE_GROUP --location $REGION
```

<!-- workflow.directOnly()
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
