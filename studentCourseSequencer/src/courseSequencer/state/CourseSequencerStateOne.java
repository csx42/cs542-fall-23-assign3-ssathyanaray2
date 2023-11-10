package courseSequencer.state;

import courseSequencer.context.CourseSequencer;
import courseSequencer.util.Results;
import courseSequencer.helper.StateUtil;

public class CourseSequencerStateOne extends CourseSequencerStateI {
    CourseSequencer courseSequencer;
    Results results;

    public CourseSequencerStateOne(CourseSequencer courseSequencerIn, Results resultsIn){
        courseSequencer = courseSequencerIn;
        results = resultsIn;
    }
    @Override
    public void processCourseAD(char course) {
        StateUtil.processCourse(course,'A', 0, courseSequencer,results);
    }

    @Override
    public void processCourseEH(char course) {
        StateUtil.processCourse(course,'E',1,courseSequencer,results);
    }

    @Override
    public void processCourseIL(char course) {
        StateUtil.processCourse(course,'I',2,courseSequencer,results);
    }

    @Override
    public void processCourseMP(char course) {
        StateUtil.processCourse(course,'M',3,courseSequencer,results);
    }

    @Override
    public void processCourseQZ(char course) {
        StateUtil.processCourse(course,'Q',4,courseSequencer,results);
    }

    @Override
    public String toString() {
        return "CourseSequencerStateOne{" +
                "courseSequencer=" + courseSequencer +
                ", results=" + results +
                '}';
    }
}
