package courseSequencer.state;

import java.util.regex.Pattern;

public abstract class CourseSequencerStateI {

    public abstract void processCourseAD(char course);
    public abstract void processCourseEH(char course);
    public abstract void processCourseIL(char course);
    public abstract void processCourseMP(char course);
    public abstract void processCourseQZ(char course);

    public void registerCourse(char course){
        if(Pattern.matches("[A-D]", Character.toString(course))){
            processCourseAD(course);
        }

        else if(Pattern.matches("[E-H]", Character.toString(course))){
            processCourseEH(course);
        }

        if(Pattern.matches("[I-L]", Character.toString(course))){
            processCourseIL(course);
        }

        if(Pattern.matches("[M-P]", Character.toString(course))){
            processCourseMP(course);
        }

        if(Pattern.matches("[Q-Z]", Character.toString(course))){
            processCourseQZ(course);
        }
    }
}
