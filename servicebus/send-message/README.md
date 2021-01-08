
# Send an message to an Azure Service Bus Queue

## Prerequisites

This example assumes you have previously completed the following example.

1. [Create an Azure Resource Group](../../group/create/)
1. [Create an Azure Service Bus](../create/)
1. [Create an Azure Service Bus Queue](../create-queue/)

## Send an message to an Azure Service Bus Queue

<!-- workflow.cron(0 3 * * 1) -->
<!-- workflow.include(../create-queue/README.md) -->

First, create the environment variables used to connect to our message queue
using the command line below:


```shell
  export SERVICE_BUS_QUEUE_CONNECTION_STRING=$(az servicebus namespace authorization-rule keys list \
    --resource-group $RESOURCE_GROUP --namespace-name $SERVICE_BUS --name RootManageSharedAccessKey \
    --query primaryConnectionString --output tsv)
```

Then build the client:

```shell
  mvn clean package
```

<!-- workflow.run()
cd servicebus/send-message
-->

And then send the message:

```shell
  java -jar target/send-message.jar
```

<!-- workflow.run()
cd ../..
-->

<!-- workflow.directOnly() 
export RESULT=$(az servicebus queue show --resource-group $RESOURCE_GROUP --namespace $SERVICE_BUS --name $SERVICE_BUS_QUEUE --query countDetails.activeMessageCount --output tsv)
az group delete --name $RESOURCE_GROUP --yes || true
if [[ "$RESULT" != 1 ]]; then
  exit 1
fi
  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

1m
