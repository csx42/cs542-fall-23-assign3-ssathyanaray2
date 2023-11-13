package courseSequencer.state;

import courseSequencer.helper.StateUtil;
import courseSequencer.util.Results;


public class CourseSequencerStateGraduated implements CourseSequencerStateI {

    Results results;

    public CourseSequencerStateGraduated(Results resultsIn){
        results = resultsIn;
    }

    @Override
    public void registerCourse(char course){
        if(StateUtil.semesterSubjects.size()!=0){
            results.incrementSemester();
        }
        results.printResults("");
        System.exit(0);
    }

    public void changeGroup(){
        System.out.println("invalid operation");
    }

    @Override
    public String toString() {
        return "CourseSequencerStateGraduated{" +
                ", results=" + results +
                '}';
    }
}
