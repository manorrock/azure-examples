
# Create a Spring Boot application and deploy it to Azure Spring Cloud

## Prerequisites

This example assumes you have previously completed the following examples.

1. [Create an Azure Resource Group](../../group/create/)
1. [Deploy an Azure Spring Cloud](../create/)

## Build the example

To build the JAR file use the following Maven command line.

```shell
  mvn package
```

## Run example locally

To run the example locally use the following Maven command line.

```shell
  mvn spring-boot:run
```

Note you will see exception occurring in the logs because you are not running the
application within the Azure Spring Cloud. Do not worry this expected and can be
ignored.

You can verify the application works by using your favorite browser and going
to http://localhost:8080/

## Deploy the application to Azure Spring Cloud

```shell
  az spring-cloud app create \
    --name helloworld \
    --service ${SPRING_CLOUD_NAME} \
    --resource-group ${RESOURCE_GROUP} \
    --is-public true

  az spring-cloud app deploy \
    --name helloworld \
    --service ${SPRING_CLOUD_NAME} \
    --resource-group ${RESOURCE_GROUP} \
    --jar-path ./target/springcloud-helloworld.jar

  az spring-cloud app show \
    --name helloworld \
    --service ${SPRING_CLOUD_NAME} \
    --resource-group ${RESOURCE_GROUP}
```

Once the deploy is done use the "url" found in the output to point your favorite
browser to your Spring Boot application which is now running on your Azure Spring
Cloud. The URL should be similar to the one below:

```shell
https://XYZ.azuremicroservices.io
```

## Cleanup

Do NOT forget to remove the resources once you are done running the example.
