package courseSequencer.util;

public class FileOutput implements FileDisplayInterface, StdoutDisplayInterface {
	private String filePath;
    FileProcessorInterface fileProcessor;

    public FileOutput(){

    }
    public FileOutput(String filePath) {
        this.filePath = filePath;
        fileProcessor = new FileProcessor(filePath);
    }

    public void getFileForWrite(){
        fileProcessor.getFileForWrite();
    }

    public void printOutputToFile(String output){
        fileProcessor.writeToFile(output);
    }

    public void closeFileWriter() {
        fileProcessor.closeWriteFile();
    }

    public void printOutputToStdout(String output){
        MyLogger.writeMessage(output, MyLogger.DebugLevel.ALL);
    }

    public void printErrorToStdout(String errorMessage){
        MyLogger.writeMessage(errorMessage, MyLogger.DebugLevel.ERROR);
    }

    public String toString(){
        return "File path is " + filePath;
    }
}
