package courseSequencer.util;

public class MyLogger {

    /**
     * enum to store debug levels.
     */
    public static enum DebugLevel{
        ALL,
        DEBUG,
        ERROR
    }

    private static DebugLevel debugLevel;

    /**
     * sets debug value according the integer passed as argument
     * @param levelIn integer value of debug level
     */
    public static void setDebugLevel(int levelIn){
        switch (levelIn){
            case 1: debugLevel = DebugLevel.DEBUG; break;
            case 2: debugLevel = DebugLevel.ERROR; break;
            default: debugLevel = DebugLevel.ALL; break;
        }
    }

    public static void setDebugLevel(DebugLevel debugLevelIn){
        debugLevel = debugLevelIn;
    }

    /***
     * writes messages to stdout
     * @param message text message to be written
     * @param debugLevelIn debug value
     */
    public static void writeMessage(String message, DebugLevel debugLevelIn){
        if(debugLevel==DebugLevel.ALL){
            System.out.println(message);
        }
        else {
            if(debugLevel==debugLevelIn){
                System.out.print(message);
            }
        }
    }

    public String toString(){
        return "The debug level has been set to "+debugLevel;
    }
}
