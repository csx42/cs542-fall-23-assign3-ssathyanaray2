package courseSequencer.state;

import courseSequencer.helper.StateUtil;
import courseSequencer.util.MyLogger;
import courseSequencer.util.Results;


public class CourseSequencerStateGraduated implements CourseSequencerStateI {

    Results results;

    public CourseSequencerStateGraduated(Results resultsIn){
        results = resultsIn;
    }

    @Override
    public void registerCourse(char course, StateUtil stateUtil){
        if(stateUtil.semesterSubjects.size()!=0){
            results.incrementSemester();
        }
        results.printResults("");
        System.exit(0);
    }

    public void changeGroup(StateUtil stateUtil){
        MyLogger.writeMessage("Invalid Operation", MyLogger.DebugLevel.ERROR);
    }

    @Override
    public String toString() {
        return "CourseSequencerStateGraduated{" +
                ", results=" + results +
                '}';
    }
}
