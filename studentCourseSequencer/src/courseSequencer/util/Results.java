package courseSequencer.util;

import java.util.ArrayList;

public class Results {
    private ArrayList<Character> courses;
    private int semester;
    private int stateChange;

    public Results(){
        courses = new ArrayList<>(26);
        for(int i=0; i<26; i++){
            courses.add('\0');
        }
        semester = 0;
        stateChange = 0;
    }

    public void incrementSemester(){
        semester+=1;
    }

    public ArrayList<Character> getCourses() {
        return courses;
    }

    public int getSemester() {
        return semester;
    }

    public int getStateChange() {
        return stateChange;
    }

    public void incrementStateChange(){
        stateChange+=1;
    }

    public void addCourse(char course){
        courses.add(course);
    }

    @Override
    public String toString() { //change it to required format.
        return "Results{" +
                "courses=" + courses +
                ", semester=" + semester +
                ", stateChange=" + stateChange +
                '}';
    }

    public void printResults(){
        for(int i=0; i<courses.size(); i++){
            System.out.print(courses.get(i)+" ");
            System.out.print(stateChange);
        }
    }
}
