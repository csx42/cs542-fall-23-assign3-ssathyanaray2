package courseSequencer.state;

import courseSequencer.context.CourseSequencer;
import courseSequencer.util.Results;
import courseSequencer.helper.StateUtil;

public class CourseSequencerStateOne implements CourseSequencerStateI {
    CourseSequencer courseSequencer;
    Results results;

    public CourseSequencerStateOne(CourseSequencer courseSequencerIn, Results resultsIn){
        courseSequencer = courseSequencerIn;
        results = resultsIn;
    }

    @Override
    public void registerCourse(char course, StateUtil stateUtil) {
        stateUtil.registerCourse(course, courseSequencer, results);
    }

    @Override
    public void changeGroup(StateUtil stateUtil){
        stateUtil.changeGroup(courseSequencer,results);
    }

    @Override
    public String toString() {
        return "CourseSequencerStateOne{" +
                "courseSequencer=" + courseSequencer +
                ", results=" + results +
                '}';
    }
}
