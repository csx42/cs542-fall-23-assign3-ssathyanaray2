package courseSequencer.state;

import courseSequencer.context.CourseSequencer;
import courseSequencer.util.Results;

import java.util.regex.Pattern;

public class CourseSequencerStateOne extends CourseSequencerStateI {
    CourseSequencer courseSequencer;
    Results results;
    int [] group;

    public CourseSequencerStateOne(CourseSequencer courseSequencerIn, Results resultsIn){
        courseSequencer = courseSequencerIn;
        results = resultsIn;
        group = new int[5];
    }
    @Override
    public void processCourseAD(char course) {

        boolean registered = processCourse(course,'A');
        if(registered){
            results.addCourse(course);
            group[0]+=1;
        }
        assignState();
    }

    @Override
    public void processCourseEH(char course) {

        boolean registered = processCourse(course,'E');
        if(registered){
            results.addCourse(course);
            group[1]+=1;
        }
        assignState();
    }

    @Override
    public void processCourseIL(char course) {

        boolean registered = processCourse(course,'I');
        if(registered){
            results.addCourse(course);
            group[2]+=1;
        }
        assignState();
    }

    @Override
    public void processCourseMP(char course) {

        boolean registered = processCourse(course,'M');
        if(registered){
            results.addCourse(course);
            group[3]+=1;
        }
        assignState();
    }

    @Override
    public void processCourseQZ(char course) {

        boolean registered = processCourse(course,'Q');
        if(registered){
            results.addCourse(course);
            group[4]+=1;
        }
        assignState();
    }

    @Override
    public char presentState() {
        int i=0;
        int maximum= -1;
        int noOfCourse=0;
        char group = '\0';
        for(;i<4; i++){
            if(results.getCourses().get(i)!='\0'){
                noOfCourse+=1;
            }
        }
        if(maximum<noOfCourse){
            maximum=noOfCourse;
            group='A';
        }

        for(;i<8; i++){
            if(results.getCourses().get(i)!='\0'){
                noOfCourse+=1;
            }
        }
        if(maximum<noOfCourse){
            maximum=noOfCourse;
            group='E';
        }

        for(;i<12; i++){
            if(results.getCourses().get(i)!='\0'){
                noOfCourse+=1;
            }
        }
        if(maximum<noOfCourse){
            maximum=noOfCourse;
            group='I';
        }

        for(;i<16; i++){
            if(results.getCourses().get(i)!='\0'){
                noOfCourse+=1;
            }
        }
        if(maximum<noOfCourse){
            maximum=noOfCourse;
            group='M';
        }

        for(;i<26; i++){
            if(results.getCourses().get(i)!='\0'){
                noOfCourse+=1;
            }
        }
        if(maximum<noOfCourse){
            maximum=noOfCourse;
            group='Q';
        }

        return group;
    }

    public void assignState(){
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

    public boolean processCourse(char course, char start)
    {
        for(char i=start; i<course; i++){
            if(results.getCourses().get(i-65)=='\0'){
                courseSequencer.getWaitList().add(course);
                return false;
            }
        }
        return true;
    }
    public  boolean isGraduated(){

        for(int i=0; i<5; i++){
            if(group[i]!=2) {
                return false;
            }
        }
        return true;
    }
}
