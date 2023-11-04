package courseSequencer.state;

import courseSequencer.context.CourseSequencer;
import courseSequencer.util.Results;

import java.util.regex.Pattern;

public class CourseSequencerStateGraduated extends CourseSequencerStateI {
    CourseSequencer courseSequencer;
    Results results;
    int [] group;

    public CourseSequencerStateGraduated(CourseSequencer courseSequencerIn, Results resultsIn){
        courseSequencer = courseSequencerIn;
        results = resultsIn;
        group = new int[5];
    }
    @Override
    public void processCourseAD(char course) {
        System.out.println("Invalid operation");
    }

    @Override
    public void processCourseEH(char course) {
        System.out.println("Invalid operation");
    }

    @Override
    public void processCourseIL(char course) {
        System.out.println("Invalid operation");
    }

    @Override
    public void processCourseMP(char course) {
        System.out.println("Invalid operation");
    }

    @Override
    public void processCourseQZ(char course) {
        System.out.println("Invalid operation");
    }

    @Override
    public char presentState() {
        System.out.println("Invalid operation");
        return 'a';
    }

    public void assignState(){
        System.out.println("Invalid operation");
    }

    public void registerCourse(char course){
        results.printResults();
    }

    public boolean processCourse(char course, char start)
    {
        System.out.println("Invalid operation");
        return false;
    }
    public  boolean isGraduated() {
        System.out.println("Invalid operation");
        return true;
    }
}
