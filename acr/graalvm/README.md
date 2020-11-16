
# Create a GraalVM application packaged as a Docker image and push it to Azure Container Registry

## Prerequisites

This example assumes you have previously completed the following:

1. [Create an Azure Resource Group](../../group/create/)
1. [Create an Azure Container Registry](../create/)

## Build the example

To build the JAR file use the following Maven command line:

```shell
  mvn package
```

## Build the builder image

In order to build the Linux native image we need a GraalVM version that is 
executed on Linux. The command below will generate a Docker image with what we
need.

```shell
  docker build -t builder -f Dockerfile.builder .
```

## Execute the builder image to build the Linux binary

The next step is to use the builder image to generate the Linux binary. Execute
the command line below. Note if you are on Windows please replace $PWD with the
path of the current directory.

```shell
  docker run --rm -it -v $PWD/../..:/mnt builder mvn -P graalvm -pl \
    acr/graalvm clean install  
```

## Build and push the Docker image to your Azure Container Registry

To build and push the Docker image to your ACR use the command lines below:

```shell
  export ACR_GRAALVM_IMAGE=acr-graalvm:latest

  az acr build --registry $ACR_NAME --image $ACR_GRAALVM_IMAGE .
```

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

10m
