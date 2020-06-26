
# Deploy a Java Azure Function

## Prerequisites

This example assumes you have previously completed the following.

1. [Create an Azure Resource Group](../../group/create/)
1. [Azure Functions Core Tools](https://docs.microsoft.com/en-us/azure/azure-functions/functions-run-local#install-the-azure-functions-core-tools)

## Set the app name

```shell
  export FUNCTION_APP_JAVA=function-app-java-$RANDOM
```

## Build the example

To build the JAR file use the following Maven command line.

```shell
  mvn -DappName=$FUNCTION_APP_JAVA -DresourceGroup=$RESOURCE_GROUP package
```

## Run example locally

To run the example locally use the following Maven command line.

```shell
  mvn -DappName=$FUNCTION_APP_JAVA  -DresourceGroup=$RESOURCE_GROUP \
    clean package azure-functions:run
```

You can verify the function works by using your favorite browser and going
to  http://localhost:7071/api/helloworld

## Deploy the Azure Function to Azure

```shell
  mvn -DappName=$FUNCTION_APP_JAVA  -DresourceGroup=$RESOURCE_GROUP \
    clean package azure-functions:deploy
```

Once the deploy is done you will find the deployment URL in the output. The URL 
should be similar to the one below:

```shell
https://XYZ.azurewebsites.net
```

Now add `/api/helloworld` to the end of it and use that constructed URL in your 
favorite browser to test the function.

## Cleanup

Do NOT forget to remove the resources once you are done running the example.
