
# Open MySQL server firewall to your IP address

## Prerequisites

This example assumes you have previously completed the following:

1. [Create an Azure Resource Group](../../group/create/)
1. [Create an Azure Database for MySQL](../create/)
1. [Install curl](https://curl.haxx.se/download.html)

## Open MySQL server firewall to your local IP address

To make it possible to communicate with your MySQL server from your local IP,
please execute the following command lines:

```shell
  export LOCAL_IP=`curl -s whatismyip.akamai.com`

  az mysql server firewall-rule create \
    --resource-group $RESOURCE_GROUP \
    --server $MYSQL_NAME \
    --name AllowMyLocalIP \
    --start-ip-address $LOCAL_IP \
    --end-ip-address $LOCAL_IP
```

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

## Next steps

1. [Azure Database for MySQL Documentation](https://docs.microsoft.com/en-us/azure/mysql/)
1. [Migrate to Azure Database for MySQL](https://datamigration.microsoft.com/scenario/mysql-to-azuremysql)
1. [Minimal downtime migration](https://docs.microsoft.com/en-us/azure/mysql/howto-migrate-online)
1. [Query data using Java](https://docs.microsoft.com/en-us/azure/mysql/connect-java)
1. [Manage Azure Database for MySQL servers](https://docs.microsoft.com/en-us/cli/azure/mysql)

1m
