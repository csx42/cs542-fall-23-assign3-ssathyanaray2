package courseSequencer.helper;

import courseSequencer.context.CourseSequencer;
import courseSequencer.state.CourseSequencerStateI;
import courseSequencer.util.Results;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * This class has all the data structures required to store and allocate courses. It acts has helper class for all the states.
 * @author Spoorthi
 * @version 1.0
 * @since 2023-11-12
 */


public class StateUtil {

    public static ArrayList<Character> semesterSubjects = new ArrayList<>(3);;
    public static ArrayList<Character> courses = new ArrayList<>(26);
    public static ArrayList<Character> waitList = new ArrayList<>();
    public static int[]  group = new int[5];

    public static void initialize(){
        for(int i=0; i<26; i++){
            courses.add('\0');
        }
    }

    /**
     * The method check if a student has graduated, if not sets the state object in context class to appropriate state.
     * @param courseSequencer context class object
     * @param results result class object - to store registered course
     */
    public static void changeGroup(CourseSequencer courseSequencer, Results results){
        CourseSequencerStateI oldState = courseSequencer.getState();
        CourseSequencerStateI newState = null;
        if(isGraduated()){
            courseSequencer.setState(courseSequencer.graduated);
        }
        else {
            char state = presentState();
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

    /**
     * It allocates the course if the course does not satisfy its pre-requisite condition it adds it to the waitlist.
     * @param course course to be allocated
     * @param start starting letter of the group
     * @param group group number
     * @param courseSequencer context class object
     * @param results results object
     */
    public static void processCourse(char course, char start, int group, CourseSequencer courseSequencer, Results results)
    {
        if(course=='\0'){
            waitList.add(course);
            return;
        }

        if(group!=4) {
            for (char i = start; i < course; i++) {
                int index = i;

                if (courses.get(index - 65) == '\0' || semesterSubjects.contains(i)) {
                    waitList.add(course);
                    return;
                }
            }
        }

        courses.set(course-65,course);
        results.addCourse(course);
        addSemesterSubjects(results,course);
        groupIncrement(group);
        changeGroup(courseSequencer,results);
    }

    /**
     * The method check whether student has been graduated.
     * @return boolean value true if the student has graduated else false.
     */
    public static boolean isGraduated(){

        for(int i=0; i<5; i++){
            if(group[i]<2) {
                return false;
            }
        }
        return true;
    }

    /**
     * Add the subject to a particular semester.
     * @param results results object
     * @param course course to be added.
     */
    public static void addSemesterSubjects(Results results, Character course){

        semesterSubjects.add(course);
        if(semesterSubjects.size()==3){
            results.incrementSemester();
            semesterSubjects = new ArrayList<>();
        }

    }

    /**
     * Increment semester if there are remaining semester after processing input.
     * @param results results object
     */
    public static void addRemainingSubjects(Results results){
        if(semesterSubjects.size()!=0){
            results.incrementSemester();
            semesterSubjects = new ArrayList<>();
        }
    }

    /**
     * The method decides which state the system should be based on number of courses in each state. The state with most number of courses will be the winner.
     * @return group name
     */
//    public static char presentState() {
//        int i=0;
//        int maximum= -1;
//        int noOfCourse=0;
//        char group = '\0';
//        for(;i<4; i++){
//            if(courses.get(i)!='\0'){
//                noOfCourse+=1;
//            }
//        }
//        if(maximum<noOfCourse){
//            maximum=noOfCourse;
//            group='A';
//        }
//
//        for(;i<8; i++){
//            if(courses.get(i)!='\0'){
//                noOfCourse+=1;
//            }
//        }
//        if(maximum<noOfCourse){
//            maximum=noOfCourse;
//            group='E';
//        }
//
//        for(;i<12; i++){
//            if(courses.get(i)!='\0'){
//                noOfCourse+=1;
//            }
//        }
//        if(maximum<noOfCourse){
//            maximum=noOfCourse;
//            group='I';
//        }

//        for(;i<16; i++){
//            if(courses.get(i)!='\0'){
//                noOfCourse+=1;
//            }
//        }
//        if(maximum<noOfCourse){
//            maximum=noOfCourse;
//            group='M';
//        }
//
//        for(;i<26; i++){
//            if(courses.get(i)!='\0'){
//                noOfCourse+=1;
//            }
//        }
//        if(maximum<noOfCourse){
//            maximum=noOfCourse;
//            group='Q';
//        }
//
//        return group;
//    }

    public static char presentState() {
        int i=25;
        int maximum= -1;
        int noOfCourse=0;
        char group = '\0';

        for(;i>15; i--){
            if(courses.get(i)!='\0'){
                noOfCourse+=1;
            }
        }
        if(maximum<noOfCourse){
            maximum=noOfCourse;
            group='Q';
        }

        for(;i>11; i--){
            if(courses.get(i)!='\0'){
                noOfCourse+=1;
            }
        }
        if(maximum<noOfCourse){
            maximum=noOfCourse;
            group='M';
        }

        for(;i>7; i--){
            if(courses.get(i)!='\0'){
                noOfCourse+=1;
            }
        }
        if(maximum<noOfCourse){
            maximum=noOfCourse;
            group='I';
        }

        for(;i>3; i--){
            if(courses.get(i)!='\0'){
                noOfCourse+=1;
            }
        }
        if(maximum<noOfCourse){
            maximum=noOfCourse;
            group='E';
        }

        for(;i>-1; i--){
            if(courses.get(i)!='\0'){
                noOfCourse+=1;
            }
        }
        if(maximum<noOfCourse){
            maximum=noOfCourse;
            group='A';
        }

        return group;
    }


    /**
     * increment a group count by 1.
     * @param index group index to be incremented.
     */
    public static void groupIncrement(int index) {
        group[index]+=1;
    }

//
//    /**
//     * get group count - number of subjects registered in a group
//     * @param index group index
//     * @return number of subjects registered in a group
//     */
//    public static int getGroupCount(int index){
//        return group[index];
//    }


    public static void registerCourse(char course, CourseSequencer courseSequencer, Results results){
        if(Pattern.matches("[A-D]", Character.toString(course))){
            processCourse(course,'A', 0, courseSequencer, results);
        }

        else if(Pattern.matches("[E-H]", Character.toString(course))){
            processCourse(course,'E',1,courseSequencer,results);
        }

        if(Pattern.matches("[I-L]", Character.toString(course))){
            processCourse(course,'I',2,courseSequencer,results);
        }

        if(Pattern.matches("[M-P]", Character.toString(course))){
            processCourse(course,'M',3,courseSequencer,results);
        }

        if(Pattern.matches("[Q-Z]", Character.toString(course))){
            processCourse(course,'Q',4,courseSequencer,results);
        }
    }
}
