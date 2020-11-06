
# Deploy a Quarkus application using managed JavaSE

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/)
1. [Create an Azure App Service Plan](../create-plan/)

## Build the example

<!-- workflow.include(../create-plan/README.md) -->

To build the JAR file use the following Maven command line.

```shell
  mvn package
```

## Run example locally

To run the example locally use the following Maven command line.

<!-- workflow.skip() -->
```shell
  mvn quarkus:dev
```

You can see the application in action at http://localhost:8080/hello

## Deploy the Quarkus application using managed JavaSE

To deploy the application use the following command lines:

````shell
  export APPSERVICE_JAVASE_QUARKUS=appservice-javase-quarkus-$RANDOM

  mvn azure-webapp:deploy \
    -DappName=$APPSERVICE_JAVASE_QUARKUS \
    -DappServicePlan=$APPSERVICE_PLAN \
    -DresourceGroup=$RESOURCE_GROUP
````

Once the command completes you will be able to see the example by using your web
browser and going to the ```xxxxx.azurewebsites.net``` address the command echoes.

### Properties supported by the example

The example supports the following properties that you can pass in as -Dname=value
to the Maven command line to customize your deployment.

| name                   | description                      |
|------------------------|----------------------------------|
| example.appName        | the application name             |
| example.appServicePlan | the App Service plan to use      |
| example.resourceGroup  | the Azure Resource Group name    |

## Cleanup

Do NOT forget to remove the App Service and its associated resources once you are
done running the example.
