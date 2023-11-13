package courseSequencer.helper;

import courseSequencer.context.CourseSequencer;
import courseSequencer.util.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * The class reads the input from a file and calls registerCourses in the context class.
 * @author Spoorthi
 * @version 1.0
 * @since 2023-11-12
 */

public class CourseAllocator {

    Results results;
    CourseSequencer courseSequencer;

    StateUtil stateUtil;

    public CourseAllocator(){
        results = new Results();
        courseSequencer = new CourseSequencer(results);
        stateUtil = new StateUtil();
    }

    /**
     *The method takes input and calls register course using context class
     * @param args command line arguments
     */
    public void processCoursesForStudents(String[] args){

        argsCheck(args);
        deleteOutputFiles(args);
        FileNames.setFileNames(args[0],args[1],args[2]);

        FileInputInterface fileInput = new FileInput(FileNames.getInputFile(), " ");
        fileInput.getFileForRead();

        try {
            //taking input
            String[] input = fileInput.readFileContent();
            ArrayList<Character> subjectsRequested = new ArrayList<>();
            for (int i = 1; i < input.length; i++) {
                subjectsRequested.add(input[i].charAt(0));
            }
            results.setStudentID(input[0].replace(input[0].substring(input[0].length() - 1), ""));

            for (Character character : subjectsRequested) {
                courseSequencer.registerCourses(character, stateUtil);

                for (int j = 0; j < stateUtil.waitList.size(); j++) {
                    courseSequencer.registerCourses(stateUtil.waitList.remove(0),stateUtil);
                }
            }

            stateUtil.addRemainingSubjects(results);

            stateUtil.waitList.add('\0');

            for(int j=0; j<stateUtil.waitList.size(); j++){
                courseSequencer.registerCourses(stateUtil.waitList.remove(0),stateUtil);
            }

            courseSequencer.error.registerCourse('\0',stateUtil);

        }
        catch (NullPointerException | StringIndexOutOfBoundsException e){
            printToTheFile("Input file is empty.",FileNames.getErrorFile());
            MyLogger.writeMessage("Input file is empty.", MyLogger.DebugLevel.ERROR);
            e.printStackTrace();
        } finally {
            fileInput.closeFile();
        }
    }

    /**
     * checks for output file if there, just deletes it.
     * @param args command line arguments.
     */
    public void deleteOutputFiles(String[] args){
        try{
            Path myPath = Paths.get(args[1]);
            Files.deleteIfExists(myPath);
            myPath = Paths.get(args[2]);
            Files.deleteIfExists(myPath);
        }
        catch(IOException e){
            MyLogger.writeMessage("Unknown file.", MyLogger.DebugLevel.ERROR);
            e.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * The method checks if the number of command line arguments are correct and not empty.
     * @param args command line arguments.
     */
    public void argsCheck(String[] args){
        if (args.length != 3 || args[0].equals("${arg0}") || args[0].isEmpty() || args[1].equals("${arg1}") || args[1].isEmpty() || args[2].equals("${arg2}") || args[2].isEmpty()) {
            MyLogger.writeMessage("Error: Incorrect number of arguments. Program accepts 3 arguments.", MyLogger.DebugLevel.ERROR);
            System.exit(0);
        }
    }

    /**
     * The method prints a string to a file
     * @param message input to print to a file
     * @param file file name
     */
    public void printToTheFile(String message, String file){
        FileDisplayInterface print = new FileOutput(file);
        print.getFileForWrite();
        print.printOutputToFile(message);
        print.closeFileWriter();
    }

    @Override
    public String toString() {
        return "CourseAllocator{" +
                "results=" + results +
                ", courseSequencer=" + courseSequencer +
                '}';
    }
}
