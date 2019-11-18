
# Create settings.xml for your Azure Container Registry (using admin access keys)

```html
Note for production environments we recommend you setup a service principal instead of using admin access keys
```

## Prerequisites

This example assume you have deployed an Azure Container Registry before. If you
have not done so please go to [Deploy a Azure Container Registry](../acr-create/README.md)

## Create the settings.xml

To create the settings.xml use the following Maven command line.

````shell
  mvn package -Dexample.registry=FILL_IN_THE_REGISTRY_NAME
````

### Properties supported by the example

The example supports the following properties that you can pass in as -Dname=value to the Maven command line to customize your deployment.

| name                   | description                              |
|------------------------|------------------------------------------|
| example.registry       | the name of the Azure Container Registry |
| example.resourceGroup  | the Azure Resource Group                 |

## Cleanup

Do NOT forget to remove the resources you might have created once you are done running the example.
