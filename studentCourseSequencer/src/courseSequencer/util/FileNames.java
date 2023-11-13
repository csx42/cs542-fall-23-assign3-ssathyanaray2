package courseSequencer.util;

public enum FileNames{
    DUMMY;
    public static String inputFile = "";
    public static String outputFile = "";
    public static String errorFile = "";

    public static void setFileNames(String inputFileIn, String outputFileIn, String errorFileIn) {
        inputFile = inputFileIn;
        outputFile = outputFileIn;
        errorFile = errorFileIn;
    }

    public static String getInputFile() {
        return inputFile;
    }

    public static String getOutputFile() {
        return outputFile;
    }

    public static String getErrorFile() {
        return errorFile;
    }

}
