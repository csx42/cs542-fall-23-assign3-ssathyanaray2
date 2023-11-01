package courseSequencer.state;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class CourseSequencerStateI {

    protected static Map<Character,Boolean> courses = new HashMap<>(26);
    protected static int groupOne =0;
    protected static int groupTwo =0;
    protected static int groupThree =0;
    protected static int groupFour =0;
    protected static int groupFive =0;

    public static ArrayList<Character> waitList = new ArrayList<>();

    public boolean processCourse(char course, char start){
        for(char i=start; i<course; i++){
            if(!courses.get(i)){
                waitList.add(course);
                return false;
            }
        }
        return true;
    }

    public boolean isGraduated(){
        if(groupOne==2 && groupTwo==2 && groupThree==2 && groupFour==2 && groupFive==2){
            return true;
        }
        return false;
    }


}
