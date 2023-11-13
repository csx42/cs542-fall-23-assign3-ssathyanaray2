package courseSequencer.state;

import courseSequencer.helper.StateUtil;

import java.util.regex.Pattern;

public interface CourseSequencerStateI {
    void registerCourse(char course, StateUtil stateUtil);
    void changeGroup(StateUtil stateUtil);
}
