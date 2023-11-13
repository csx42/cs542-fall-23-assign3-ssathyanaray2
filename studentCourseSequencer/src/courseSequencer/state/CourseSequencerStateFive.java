package courseSequencer.state;

import courseSequencer.context.CourseSequencer;
import courseSequencer.util.Results;
import courseSequencer.helper.StateUtil;

public class CourseSequencerStateFive implements CourseSequencerStateI {
    CourseSequencer courseSequencer;
    Results results;

    public CourseSequencerStateFive(CourseSequencer courseSequencerIn, Results resultsIn){
        courseSequencer = courseSequencerIn;
        results = resultsIn;
    }

    @Override
    public void registerCourse(char course, StateUtil stateUtil) {
        stateUtil.registerCourse(course, courseSequencer, results);
    }

    public void changeGroup(StateUtil stateUtil){
        stateUtil.changeGroup(courseSequencer,results);
    }
    @Override
    public String toString() {
        return "CourseSequencerStateFive{" +
                "courseSequencer=" + courseSequencer +
                ", results=" + results +
                '}';
    }
}
