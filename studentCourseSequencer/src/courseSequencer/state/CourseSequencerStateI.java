package courseSequencer.state;

import java.util.regex.Pattern;

public interface CourseSequencerStateI {
    void registerCourse(char course);
    void changeGroup();
}
