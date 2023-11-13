package courseSequencer.state;

import courseSequencer.context.CourseSequencer;
import courseSequencer.util.Results;
import courseSequencer.helper.StateUtil;

public class CourseSequencerStateThree implements CourseSequencerStateI {
    CourseSequencer courseSequencer;
    Results results;

    public CourseSequencerStateThree(CourseSequencer courseSequencerIn, Results resultsIn){
        courseSequencer = courseSequencerIn;
        results = resultsIn;
    }
    @Override
    public void registerCourse(char course) {
        StateUtil.registerCourse(course, courseSequencer, results);
    }

    public void changeGroup(){
        StateUtil.changeGroup(courseSequencer,results);
    }
    @Override
    public String toString() {
        return "CourseSequencerStateThree{" +
                "courseSequencer=" + courseSequencer +
                ", results=" + results +
                '}';
    }
}
