package courseSequencer.state;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class CourseSequencerStateI {

    public abstract void processCourseAD(char course);
    public abstract void processCourseEH(char course);
    public abstract void processCourseIL(char course);
    public abstract void processCourseMP(char course);
    public abstract void processCourseQZ(char course);
    public abstract char presentState();
    public abstract void assignState();
    public abstract boolean processCourse(char course, char start);
    public abstract boolean isGraduated();
    public abstract void registerCourse(char course);
}
