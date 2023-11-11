package courseSequencer.context;

import courseSequencer.state.*;
import courseSequencer.util.Results;

/**
 * This class acts as context class in a state pattern. The state object appears to be changing based on the courses allocated.
 * @author Spoorthi
 * @version 1.0
 * @since 2023-11-12
 */


public class CourseSequencer {
    public CourseSequencerStateI state;
    public CourseSequencerStateI stateOne;
    public CourseSequencerStateI stateTwo;
    public CourseSequencerStateI stateThree;
    public CourseSequencerStateI stateFour;
    public CourseSequencerStateI stateFive;
    public CourseSequencerStateI graduated;
    public CourseSequencerStateI error;

    /**
     * initialize all the states and assign state to stateOne which is the initial state.
     * @param results initialize with result object.
     */
    public CourseSequencer(Results results){

        stateOne = new CourseSequencerStateOne(this,results);
        stateTwo = new CourseSequencerStateTwo(this,results);
        stateThree = new CourseSequencerStateThree(this,results);
        stateFour = new CourseSequencerStateFour(this,results);
        stateFive = new CourseSequencerStateFive(this,results);
        graduated = new CourseSequencerStateGraduated(results);
        error = new CourseSequencerStateError(results);
        state = stateOne; //initial state is stateOne.

    }

    /**
     * The method register courses - calls state.registerCourse method.
     * @param course
     */
    public void registerCourses(Character course){
        state.registerCourse(course);
    }

    /**
     * set state
     * @param stateIn state
     */
    public void setState(CourseSequencerStateI stateIn){
        state = stateIn;
    }

    /**
     * @return state
     */
    public CourseSequencerStateI getState() {
        return state;
    }

    @Override
    public String toString() {
        return "CourseSequencer{" +
                "state=" + state +
                '}';
    }
}
