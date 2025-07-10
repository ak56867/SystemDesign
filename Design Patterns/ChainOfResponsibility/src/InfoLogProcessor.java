public class InfoLogProcessor extends LogProcessor{

    //this is used to inform the parent class about the nextProcessor of this class
    InfoLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    //if LogLevel matches then it will do its job otherwise will call the log function of next handler via parent class
    public void log(int logLevel, String message) {
        if(logLevel == INFO) {
            System.out.println("INFO: " + message);
        } else {
          super.log(logLevel, message);
        }
    }
}
