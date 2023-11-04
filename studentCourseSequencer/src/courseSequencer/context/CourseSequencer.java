package courseSequencer.context;

import courseSequencer.state.*;
import courseSequencer.util.Results;

import java.util.ArrayList;

public class CourseSequencer {
    public CourseSequencerStateI state;
    public CourseSequencerStateI stateOne;
    public CourseSequencerStateI stateTwo;
    public CourseSequencerStateI stateThree;
    public CourseSequencerStateI stateFour;
    public CourseSequencerStateI stateFive;
    public CourseSequencerStateI graduated;
    public Results results;
    public ArrayList<Character> waitList = new ArrayList<>();

    public CourseSequencer(){
        results = new Results();
        stateOne = new CourseSequencerStateOne(this,results);
        stateTwo = new CourseSequencerStateTwo(this,results);
        stateThree = new CourseSequencerStateThree(this,results);
        stateFour = new CourseSequencerStateFour(this,results);
        stateFive = new CourseSequencerStateFive(this,results);
        graduated = new CourseSequencerStateGraduated(this,results);
        state = stateOne;
    }

    public void processCoursesForStudents(){
        char[] array = {'A', 'B', 'C', 'D'};
        for(int i=0; i<4; i++){
            state.registerCourse(array[i]);
        }
        graduated.registerCourse('\0');
    }

    public void setState(CourseSequencerStateI stateIn){
        state = stateIn;
    }

    public ArrayList<Character> getWaitList() {
        return waitList;
    }

    public CourseSequencerStateI getState() {
        return state;
    }
}
