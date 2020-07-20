
# Create an Azure Database for MySQL

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../group/create/)

## Create the Azure Database for MySQL

To create the Azure Database for MySQL use the following command line:

````shell
  export MYSQL_NAME=mysql-$RANDOM
  export MYSQL_USERNAME=mysql
  export MYSQL_PASSWORD=p#ssw0rd-$RANDOM

  az mysql server create \
    --admin-user $MYSQL_USERNAME \
    --admin-password $MYSQL_PASSWORD \
    --name $MYSQL_NAME \
    --resource-group $RESOURCE_GROUP \
    --sku B_Gen5_1 \
    --ssl-enforcement Disabled
````

## Cleanup

Do NOT forget to remove the resources once you are done running the example.
