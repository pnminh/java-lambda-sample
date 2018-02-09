package com.dice.aws.lambda;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.joda.time.DateTime;

public class LambdaRequestHandler
  implements RequestHandler<String, String> {
    public String handleRequest(String input, Context context) {
        context.getLogger().log("Input: " + input);
        DateTime dateTime = new DateTime();
        return "Hello World 6th version: " + input +". Current dateTime is: "+ dateTime.toString();
    }
}