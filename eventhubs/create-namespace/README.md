
# Create an Azure Event Hubs namespace

![eventhubs/create-namespace/README.md](https://github.com/manorrock/azure-examples/workflows/eventhubs/create-namespace/README.md/badge.svg)

## Prerequisites

This example assumes you have previously completed the following example.

1. [Create an Azure Resource Group](../../group/create/)

## Create an Azure Event Hubs namespace

<!-- workflow.cron(0 1 * * 5) -->
<!-- workflow.include(../../group/create/README.md) -->

First, create the environment variable used for our Service Bus
using the command line below:

```shell
  export EVENT_HUBS_NAMESPACE=event-hubs-namespace-$RANDOM
```

Then, create the Azure Event Hubs namespace using the following command line:

```shell
  az eventhubs namespace create \
    --resource-group $RESOURCE_GROUP \
    --name $EVENT_HUBS_NAMESPACE
```

<!-- workflow.directOnly() 

export RESULT=$(az eventhubs namespace show --resource-group $RESOURCE_GROUP --name $EVENT_HUBS_NAMESPACE --query provisioningState --output tsv)
az group delete --name $RESOURCE_GROUP --yes || true
if [[ "$RESULT" != Succeeded ]]; then
  exit 1
fi

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

3m
