
# Deploy a Java Azure Function

## Prerequisites

This example assumes you have previously completed the following examples.

1. [Create an Azure Resource Group](../resourcegroup-create/README.md)

## Build the example

To build the JAR file use the following Maven command line.

````shell
  mvn package
````

## Run example locally

To run the example locally use the following Maven command line.

````shell
  mvn clean package azure-functions:run
````

You can verify the function works by using your favorite browser and going
to  http://localhost:7071/api/helloworld

## Deploy the Azure Function to Azure

```shell
  mvn clean package azure-functions:deploy
```

Once the deploy is done you will find the deployment URL in the output. The URL 
should be similar to the one below:

```shell
https://XYZ.azurewebsites.net
```

Now add `/api/helloworld` to the end of it and use that constructed URL in your 
favorite browser to test the function.

### Properties supported by the example

The example supports the following properties that you can pass in as -Dname=value
to the Maven command line to customize your deployment.

| name                   | description                        |
|------------------------|------------------------------------|
| example.appName        | the function application name      |
| example.resourceGroup  | the Azure Resource Group name      |

## Cleanup

Do NOT forget to remove the Azure Function and its associated resources
once you are done running the example.
