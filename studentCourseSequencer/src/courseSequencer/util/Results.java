package courseSequencer.util;

import java.util.ArrayList;

public class Results {

    String studentID;
    private int semester;
    private int stateChange;
    private ArrayList<Character> registeredCourses;

    public Results(){
        registeredCourses = new ArrayList<>();
        semester = 0;
        stateChange = 0;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void incrementSemester(){
        semester+=1;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getStateChange() {
        return stateChange;
    }

    public void incrementStateChange(){
        stateChange+=1;
    }

    public void addCourse(char course){
        registeredCourses.add(course);
    }

    @Override
    public String toString() { //change it to required format.
        return "Results{" +
                ", semester=" + semester +
                ", stateChange=" + stateChange +
                '}';
    }

    public void printToTheFile(String message, String file){
        FileDisplayInterface print = new FileOutput(file);
        print.getFileForWrite();
        print.printOutputToFile(message);
        print.closeFileWriter();
    }

    public void printResults(String message){

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(studentID+": ");
        for(int i=0; i<registeredCourses.size(); i++){
            stringBuilder.append(registeredCourses.get(i)+" ");
        }
        stringBuilder.append("-- "+semester+" "+stateChange);
        stringBuilder.append(message);

        MyLogger.writeMessage(stringBuilder.toString(), MyLogger.DebugLevel.ALL);

        printToTheFile(stringBuilder.toString(), FileNames.getOutputFile());
    }

}
