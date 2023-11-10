package courseSequencer.state;

import courseSequencer.context.CourseSequencer;
import courseSequencer.helper.StateUtil;
import courseSequencer.util.Results;

public class CourseSequencerStateGraduated extends CourseSequencerStateI {
    CourseSequencer courseSequencer;
    Results results;
    public CourseSequencerStateGraduated(CourseSequencer courseSequencerIn, Results resultsIn){
        courseSequencer = courseSequencerIn;
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
        System.exit(0);
    }

    @Override
    public String toString() {
        return "CourseSequencerStateGraduated{" +
                "courseSequencer=" + courseSequencer +
                ", results=" + results +
                '}';
    }
}
