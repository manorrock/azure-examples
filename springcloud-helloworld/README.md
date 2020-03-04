
# Create a Spring Boot application and deploy it to Azure Spring Cloud

## Prerequisites

This example assumes you have previously completed the following examples.

1. [Create an Azure Resource Group](../resourcegroup-create/README.md)
1. [Deploy an Azure Spring Cloud](../springcloud-create/README.md)

## Build the example

To build the JAR file use the following Maven command line.

````shell
  mvn package
````

## Run example locally

To run the example locally use the following Maven command line.

````shell
  mvn spring-boot:run
````

Note you will see exception occurring in the logs because you are not running the
application within the Azure Spring Cloud (this is expected).

You can verify the application works by using your favorite browser and going
to http://localhost:8080/

## Deploy the application to Azure Spring Cloud

```shell
  mvn antrun:run@deploy -Dexample.springCloudName=SPRINGCLOUD
```

Where ```SPRINGCLOUD``` is the name of your Azure Spring Cloud.

Once the deploy is done use the "url" found in the output to point your favorite
browser to your Spring Boot application which is now running on your Azure Spring
Cloud. The URL should be similar to the one below:

```shell
https://XYZ.azuremicroservices.io
```

### Properties supported by the example

The example supports the following properties that you can pass in as -Dname=value
to the Maven command line to customize your deployment.

| name                   | description                        |
|------------------------|------------------------------------|
| example.appName        | the application name               |
| example.resourceGroup  | the Azure Resource Group name      |
| example.springCloudName| the name of the Azure Spring Cloud |

## Cleanup

Do NOT forget to remove the Spring Boot application and its associated resources
once you are done running the example.
