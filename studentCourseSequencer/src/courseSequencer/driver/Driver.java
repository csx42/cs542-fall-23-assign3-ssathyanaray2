package courseSequencer.driver;

import courseSequencer.context.CourseSequencer;

public class Driver {
    public static void main(String[] args) {
        CourseSequencer courseSequencer = new CourseSequencer();
        courseSequencer.processCoursesForStudents();
    }
}