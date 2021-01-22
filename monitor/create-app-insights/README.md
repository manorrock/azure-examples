
# Create an Application Insights resource

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/)

<!-- workflow.cron(0 1 * * 2) -->
<!-- workflow.include(../../group/create/README.md) -->

## Create an Application Insights resource

Add the Application Insights CLI extension:

```shell
  az extension add -n application-insights
```

Set the Application Insights application name environment variable:

<!-- workflow.skip() -->
```shell
  export APP_INSIGHTS=app-insights-$RANDOM
```

<!-- workflow.run()
if [[ -z $APP_INSIGHTS ]]; then
  export APP_INSIGHTS=app-insights-$RANDOM
fi
  -->

To create the Application Insights resource use the command line below:

```shell
  az monitor app-insights component create \
    --app $APP_INSIGHTS \
    --location $REGION \
    --resource-group $RESOURCE_GROUP
```

Set the Application Insights connection string environment variable by
executing the command line below:

```shell
  export APP_INSIGHTS_CONNECTION_STRING=$(az monitor app-insights component show \
    --query [?applicationId==\'${APP_INSIGHTS}\'].connectionString --output tsv)
```

<!-- workflow.directOnly()

export RESULT=$(az monitor app-insights component show --app $APP_INSIGHTS --resource-group $RESOURCE_GROUP --output tsv --query provisioningState)
az group delete --name $RESOURCE_GROUP --yes || true

if [[ "$RESULT" != Succeeded ]]; then
  echo "Application Insights $APP_INSIGHTS was not provisioned properly"
  exit 1
fi
  -->


## Cleanup

Do NOT forget to remove the resources once you are done running the example.

1m
