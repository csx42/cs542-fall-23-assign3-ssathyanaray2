package courseSequencer.util;

import courseSequencer.context.CourseSequencer;
import courseSequencer.state.CourseSequencerStateI;

import java.util.ArrayList;

public class StateUtil {

    public static void assignState(CourseSequencer courseSequencer, Results results){
        CourseSequencerStateI oldState = courseSequencer.getState();
        CourseSequencerStateI newState = null;
        if(isGraduated(courseSequencer)){
            courseSequencer.setState(courseSequencer.graduated);
        }
        else {
            char state = presentState(courseSequencer);
            if(state=='A'){
                courseSequencer.setState(courseSequencer.stateOne);
                newState = courseSequencer.stateOne;
            }
            else if(state=='E'){
                courseSequencer.setState(courseSequencer.stateTwo);
                newState = courseSequencer.stateTwo;
            }
            else if(state=='I'){
                courseSequencer.setState(courseSequencer.stateThree);
                newState = courseSequencer.stateThree;
            }
            else if(state=='M'){
                courseSequencer.setState(courseSequencer.stateFour);
                newState = courseSequencer.stateFour;
            }
            else{
                courseSequencer.setState(courseSequencer.stateFive);
                newState = courseSequencer.stateFive;
            }

            if(newState!=oldState){
                results.incrementStateChange();
            }
        }
    }

    public static void processCourse(char course, char start, int group, CourseSequencer courseSequencer, Results results)
    {
        for(char i=start; i<course; i++){
            int index = i;
            System.out.println(courseSequencer.getSemesterSubjects().contains(i));
            if(courseSequencer.getCourses().get(index-65) =='\0' && courseSequencer.getSemesterSubjects().contains(i)){
//                for(int j=0; j<3; j++){
//                    System.out.println(courseSequencer.getSemesterSubjects().get(j));
//                }
                courseSequencer.getWaitList().add(course);
                return;
            }
        }

        courseSequencer.getCourses().set(course-65,course);
        results.addCourse(course);
        addSemesterSubjects(courseSequencer,results,course);
        courseSequencer.groupIncrement(group);
        assignState(courseSequencer,results);
    }

    public static boolean isGraduated(CourseSequencer courseSequencer){

        for(int i=0; i<5; i++){
            if(courseSequencer.getGroupCount(i)<2) {
                return false;
            }
        }
        return true;
    }

    public static void addSemesterSubjects(CourseSequencer courseSequencer, Results results, Character course){

        courseSequencer.getSemesterSubjects().add(course);
        if(courseSequencer.getSemesterSubjects().size()==3){
            results.incrementSemester();
            courseSequencer.setSemesterSubjects(new ArrayList<>());
        }

    }

    public static char presentState(CourseSequencer sequencer) {
        int i=0;
        int maximum= -1;
        int noOfCourse=0;
        char group = '\0';
        for(;i<4; i++){
            if(sequencer.getCourses().get(i)!='\0'){
                noOfCourse+=1;
            }
        }
        if(maximum<noOfCourse){
            maximum=noOfCourse;
            group='A';
        }

        for(;i<8; i++){
            if(sequencer.getCourses().get(i)!='\0'){
                noOfCourse+=1;
            }
        }
        if(maximum<noOfCourse){
            maximum=noOfCourse;
            group='E';
        }

        for(;i<12; i++){
            if(sequencer.getCourses().get(i)!='\0'){
                noOfCourse+=1;
            }
        }
        if(maximum<noOfCourse){
            maximum=noOfCourse;
            group='I';
        }

        for(;i<16; i++){
            if(sequencer.getCourses().get(i)!='\0'){
                noOfCourse+=1;
            }
        }
        if(maximum<noOfCourse){
            maximum=noOfCourse;
            group='M';
        }

        for(;i<26; i++){
            if(sequencer.getCourses().get(i)!='\0'){
                noOfCourse+=1;
            }
        }
        if(maximum<noOfCourse){
            group='Q';
        }

        return group;
    }
}
