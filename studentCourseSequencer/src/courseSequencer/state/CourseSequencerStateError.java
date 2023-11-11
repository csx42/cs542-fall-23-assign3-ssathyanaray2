package courseSequencer.state;

import courseSequencer.helper.StateUtil;
import courseSequencer.util.Results;

public class CourseSequencerStateError extends CourseSequencerStateI {

    Results results;

    public CourseSequencerStateError(Results resultsIn){
        results = resultsIn;
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
    public void registerCourse(char course){
        if(StateUtil.semesterSubjects.size()!=0){
            results.incrementSemester();
        }
        results.printResults();
        System.out.println("\nStudent has not been graduated.");
        System.exit(0);
    }
}
