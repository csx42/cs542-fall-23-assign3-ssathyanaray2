package courseSequencer.driver;

import courseSequencer.helper.CourseAllocator;
import courseSequencer.util.MyLogger;

public class Driver {
    public static void main(String[] args) {

        MyLogger.setDebugLevel(MyLogger.DebugLevel.ALL);
        CourseAllocator courseAllocator = new CourseAllocator();
        courseAllocator.processCoursesForStudents(args);

    }
}