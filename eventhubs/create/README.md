
# Create an Azure Event Hub

![eventhubs/create/README.md](https://github.com/manorrock/azure-examples/workflows/eventhubs/create/README.md/badge.svg)

## Prerequisites

This example assumes you have previously completed the following example.

1. [Create an Azure Resource Group](../../group/create/)
1. [Create an Azure Event Hubs namespace](../create-namespace/)

## Create an Azure Event Hubs

<!-- workflow.cron(0 2 * * 5) -->
<!-- workflow.include(../../create-namespace/README.md) -->

First, create the environment variable used for our Service Bus
using the command line below:

```shell
  export EVENT_HUBS_NAME=event-hubs-$RANDOM
```

Then, create the Azure Event Hubs namespace using the following command line:

```shell
  az eventhubs eventhub create \
    --resource-group $RESOURCE_GROUP \
    --name $EVENT_HUBS_NAME \
    --namespace-name $EVENT_HUBS_NAMESPACE \
    --message-retention 1
```

<!-- workflow.directOnly() 

export RESULT=$(az eventhubs eventhub show --resource-group $RESOURCE_GROUP --namespace-name $EVENT_HUBS_NAMESPACE --name $EVENT_HUBS_NAME --query status --output tsv)
az group delete --name $RESOURCE_GROUP --yes || true
if [[ "$RESULT" != Active ]]; then
  exit 1
fi

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

1m
