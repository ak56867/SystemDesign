public class Main {
    public static void main(String[] args) {

        //passing next handler as object of constructor
        LogProcessor logObject = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));

        //here we are passing ERROR into our object, but it will always first start from INFO (as that is our final constructor during object initialization)
        logObject.log(LogProcessor.ERROR, "error occured!!");
        logObject.log(LogProcessor.DEBUG, "need to debug here");
        logObject.log(LogProcessor.INFO, "just for info");


        /*
        there are folks in the comment section questioning if COR is the right pattern for logger or it can be done differently,
        here is my two cents on this, reason why chain of responsibility is the right pattern here: let's take example of log4j,
        we can enable certain log level in the system like ERROR or INFO etc, this is how the error levels are defined ALL < DEBUG < INFO < WARN < ERROR < FATAL < OFF e.g. if log level is set to warn,
        then only warn, error, fatal will be printed, rest all logs with other log levels will be disabled like debug, info etc will not be printed

        Now you can see that chain of responsibility comes in handy here, lets say I have used warn as log level in log 4j and in code i have different logs like debug, info, error etc lets take error,
        it will go to all handlers and check what log level is enabled e.g. it will first go to debug handler, is it enabled, no, then go to next info and next warn, okay warn is enabled but the log level to be printed is error,
        then it will move to next handler i.e. error okay now it matches the log level to be printed and also at the system level warn is enabled and error handler is eligible for printing this log

        There is a order of execution here where the request may or may not be fulfilled based on what log level is enabled and the order which the request should be served is defined by the chain of responsibility pattern
        i.e. ALL < DEBUG < INFO < WARN < ERROR < FATAL < OFF
        */
    }
}