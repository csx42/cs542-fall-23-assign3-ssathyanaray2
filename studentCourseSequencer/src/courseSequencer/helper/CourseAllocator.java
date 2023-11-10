package courseSequencer.helper;

import courseSequencer.context.CourseSequencer;
import courseSequencer.util.FileInput;
import courseSequencer.util.FileInputInterface;
import courseSequencer.util.Results;

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

    public CourseAllocator(){
        results = new Results();
        courseSequencer = new CourseSequencer(results);
        StateUtil.initialize();
    }

    /**
     *The method takes input and calls register course using context class
     * @param args command line arguments
     */
    public void processCoursesForStudents(String[] args){

        argsCheck(args);
        deleteOutputFiles(args);
        FileInputInterface fileInput = new FileInput(args[0], " ");
        fileInput.getFileForRead();
        try {
            //taking input
            String[] input = fileInput.readFileContent();
            ArrayList<Character> subjectsRequested = new ArrayList<>();
            for (int i = 1; i < input.length; i++) {
                subjectsRequested.add(input[i].charAt(0));
            }
            results.setStudentID(input[0].replace(input[0].substring(input[0].length() - 1), ""));

            for (int i = 0; i < subjectsRequested.size(); i++) {
                courseSequencer.registerCourses(subjectsRequested.get(i));
            }
            while(StateUtil.waitList.size()!=0){
                courseSequencer.registerCourses(StateUtil.waitList.remove(0));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
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
        }
        catch(IOException e){
            System.err.println("Unknown File exception.");
            e.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * The method checks if the number of command line arguments are correct and not empty.
     * @param args command line arguments.
     */
    public void argsCheck(String[] args){
        if (args.length != 2 || args[0].equals("${arg0}") || args[0].isEmpty() || args[1].equals("${arg1}") || args[1].isEmpty()) {

            System.err.println("Error: Incorrect number of arguments. Program accepts 2 arguments.");
            System.exit(0);
        }
    }

    @Override
    public String toString() {
        return "CourseAllocator{" +
                "results=" + results +
                ", courseSequencer=" + courseSequencer +
                '}';
    }
}
