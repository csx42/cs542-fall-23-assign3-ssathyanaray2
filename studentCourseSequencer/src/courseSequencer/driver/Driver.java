package courseSequencer.driver;

import courseSequencer.helper.CourseAllocator;

public class Driver {
    public static void main(String[] args) {

        CourseAllocator courseAllocator = new CourseAllocator();
        courseAllocator.processCoursesForStudents(args);

    }
}