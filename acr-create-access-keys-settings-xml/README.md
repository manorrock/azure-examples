
# Create settings.xml for your Azure Container Registry (using admin access keys)

```text
Note for production environments we recommend you setup
a service principal instead of using admin access keys
```

## Prerequisites

This example assumes you have previously completed the following examples.

1. [Create an Azure Resource Group](../resourcegroup-create/README.md)
1. [Deploy an Azure Container Registry](../acr-create/README.md)

## Create the settings.xml

To create the settings.xml use the following Maven command line.

````shell
  mvn package -Dexample.registry=ACR_NAME
````

Where ```ACR_NAME``` is the name of your Azure Container Registry.

### Properties supported by the example

The example supports the following properties that you can pass in as -Dname=value to the Maven command line to customize your deployment.

| name                   | description                              |
|------------------------|------------------------------------------|
| example.registry       | the name of the Azure Container Registry |
| example.resourceGroup  | the Azure Resource Group                 |

## Cleanup

Do NOT forget to remove the resources you have created once you are done running
the example.
