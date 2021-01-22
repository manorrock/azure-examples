
# Deploy a web application with Application Insights on a managed Tomcat

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/)
1. [Create an Application Insights resource](../../monitor/create-app-insights/) 
1. [Create an Azure App Service Plan](../create-plan/)

## Deploy a web application with Application Insights on a managed Tomcat

<!-- workflow.cron(0 18 * * 1) -->
<!-- workflow.include(../../monitor/create-app-insights/README.md) -->
<!-- workflow.include(../create-plan/README.md) -->

<!-- workflow.run() 

  cd appservice/tomcat-app-insights

  -->

```shell
  mvn clean install
```

## Deploy the web application on the managed Tomcat

To deploy the example use the following command lines:

```shell
  export APPSERVICE_TOMCAT_APP_INSIGHTS=appservice-tomcat-app-insights-$RANDOM

  mvn azure-webapp:deploy \
    -DappName=$APPSERVICE_TOMCAT_APP_INSIGHTS \
    -DappServicePlan=$APPSERVICE_PLAN \
    -DresourceGroup=$RESOURCE_GROUP
```

<!-- workflow.run()

  sleep 60
  cd ../..

  -->

Now everything should be ready for Application Insights to be enabled. So we
are going to redeploy the example now with the connection string added. The 
Application Insights connection string environment was created when you created
the Application Insights resource.

Execute the command line below to do so:

```shell
  mvn azure-webapp:deploy -P app-insights \
    -DappInsightsConnectionString=$APP_INSIGHTS_CONNECTION_STRING  \
    -DappName=$APPSERVICE_TOMCAT_APP_INSIGHTS \
    -DappServicePlan=$APPSERVICE_PLAN \
    -DresourceGroup=$RESOURCE_GROUP
```

<!-- workflow.run()

  sleep 60
  cd ../..

  -->

## Updating the Application Insights JAR

Note if you want to update the Application Insights JAR you will need to remove
the JAVA_OPTS application settings. The command line below will do that. 

<!-- workflow.skip() -->
```shell
  az webapp config appsettings delete \
    --resource-group $RESOURCE_GROUP \
    --name $APPSERVICE_TOMCAT_APP_INSIGHTS \
    --setting-names JAVA_OPTS
```

Once that is done you can start from the top to perform the actual update.

<!-- workflow.directOnly

  az group delete --name $RESOURCE_GROUP --yes || true

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.
