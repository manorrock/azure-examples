
# Deploy a web application with Application Insights on a managed Tomcat

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/)
1. [Create an Application Insights resource](../../monitor/create-app-insights/) 
1. [Create an Azure App Service Plan](../create-plan/)

<!-- workflow.cron(0 18 * * 1) -->
<!-- workflow.include(../../monitor/create-app-insights/README.md) -->
<!-- workflow.include(../create-plan/README.md) -->

<!-- workflow.run() 

  cd appservice/tomcat-app-insights

  -->

## Build the web application

The first step is to build the WAR file using the command line below:

```shell
  mvn clean install
```

## Set the application environment variable

The next step is to set the application environment variable using the command
line below:

```shell
  export APPSERVICE_TOMCAT_APP_INSIGHTS=appservice-tomcat-app-insights-$RANDOM
```

## Deploy the web application on the managed Tomcat

To deploy the web application use the following command line:

```shell
  mvn azure-webapp:deploy \
    -DappName=$APPSERVICE_TOMCAT_APP_INSIGHTS \
    -DappServicePlan=$APPSERVICE_PLAN \
    -DresourceGroup=$RESOURCE_GROUP
```

<!-- workflow.run()

  sleep 60

  -->

## Redeploy the web application with Application Insights enabled

Now everything is ready for Application Insights to be enabled. We will 
redeploy the example with the Application Insights connection string added.

Execute the command line below to do so:

```shell
  mvn azure-webapp:deploy -P app-insights \
    -DappInsightsConnectionString=$APP_INSIGHTS_CONNECTION_STRING  \
    -DappName=$APPSERVICE_TOMCAT_APP_INSIGHTS \
    -DappServicePlan=$APPSERVICE_PLAN \
    -DresourceGroup=$RESOURCE_GROUP
```

*Note the Application Insights connection string environment variable was
created earlier when you created the Application Insights component.*

<!-- workflow.run()

  sleep 60
  cd ../..

  -->

## Updating the Application Insights JAR

If you want to update the Application Insights JAR you will need to remove
the JAVA_OPTS application setting. The command line below will do that. 

<!-- workflow.skip() -->
```shell
  az webapp config appsettings delete \
    --resource-group $RESOURCE_GROUP \
    --name $APPSERVICE_TOMCAT_APP_INSIGHTS \
    --setting-names JAVA_OPTS
```

Once that is done you can start from **Deploy the web application on the 
managed Tomcat** to perform the actual update.

<!-- workflow.directOnly

  az group delete --name $RESOURCE_GROUP --yes || true

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.
