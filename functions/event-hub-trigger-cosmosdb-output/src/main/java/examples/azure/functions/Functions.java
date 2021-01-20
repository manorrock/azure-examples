/*
 * Copyright (c) 2002-2021 Manorrock.com. All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without 
 * modification, are permitted provided that the following conditions are met:
 *
 *   1. Redistributions of source code must retain the above copyright notice, 
 *      this list of conditions and the following disclaimer.
 *   2. Redistributions in binary form must reproduce the above copyright
 *      notice, this list of conditions and the following disclaimer in the
 *      documentation and/or other materials provided with the distribution.
 *   3. Neither the name of the copyright holder nor the names of its 
 *      contributors may be used to endorse or promote products derived from
 *      this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" 
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE 
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE 
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR 
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF 
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS 
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN 
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package examples.azure.functions;

import com.microsoft.azure.functions.ExecutionContext;
import static com.microsoft.azure.functions.HttpMethod.GET;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.OutputBinding;
import static com.microsoft.azure.functions.annotation.AuthorizationLevel.ANONYMOUS;
import static com.microsoft.azure.functions.annotation.Cardinality.ONE;
import com.microsoft.azure.functions.annotation.CosmosDBOutput;
import com.microsoft.azure.functions.annotation.EventHubOutput;
import com.microsoft.azure.functions.annotation.EventHubTrigger;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import java.util.Optional;

/**
 * A example Azure Function that reacts to an Event Hub trigger and stores the 
 * result in Cosmos DB.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class Functions {

    /**
     * Send a message to the Event Hub.
     *
     * @param request the HTTP request.
     * @return the item.
     */
    @FunctionName("send")
    @EventHubOutput(
            name = "event",
            eventHubName = "",
            connection = "Event_Hub_Connection_String")
    public String send(
            @HttpTrigger(
                    name = "request",
                    methods = {GET},
                    authLevel = ANONYMOUS
            ) HttpRequestMessage<Optional<String>> request) {
        return String.valueOf(System.currentTimeMillis());
    }

    /**
     * Process the item coming from Event Hub and store it in Cosmos DB.
     *
     * @param inputItem the item coming in through from the Event Hub.
     * @param outputItem the item to store in Cosmos DB.
     * @param context the execution context.
     */
    @FunctionName("process")
    public void process(
            @EventHubTrigger(
                    name = "message",
                    eventHubName = "",
                    cardinality = ONE,
                    connection = "Event_Hub_Connection_String") String inputItem,
            @CosmosDBOutput(name = "cosmodDBOutput",
                    databaseName = "cosmosDBOutput",
                    collectionName = "items",
                    connectionStringSetting = "Cosmos_DB_Connection_String",
                    createIfNotExists = true) OutputBinding<String> outputItem,
            final ExecutionContext context) {

        StringBuilder builder = new StringBuilder();
        builder.append("{\"id\":\"")
                .append(inputItem)
                .append("\",\"description\":\"This was stored using an Azure function\"}");
        outputItem.setValue(builder.toString());
    }
}
