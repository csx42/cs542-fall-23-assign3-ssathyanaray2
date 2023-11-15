# cs542-fall-23-assign3-ssathyanaray2

## Name: Spoorthi Sathya Narayana Murthy

-----------------------------------------------------------------------
-----------------------------------------------------------------------
I have not used any slack days for this assignment.
-----------------------------------------------------------------------
Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in studentCourseSequencer/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

Go inside the cs542-fall-23-assign3-ssathyanaray2 folder and then execute the below command.

### Command: ant -buildfile studentCourseSequencer/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

Go inside the cs542-fall-23-assign3-ssathyanaray2 folder and then execute the below command.

#### Command: ant -buildfile studentCourseSequencer/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

Go inside the cs542-fall-23-assign3-ssathyanaray2 folder and then execute the below command.

**Three arguments are required to run the project. **

#### Command: ant -buildfile studentCourseSequencer/src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=error.txt

Description: Runs the code and generates output. 

Note: Empty lines in the input file gives number format exception.

-----------------------------------------------------------------------
## Data Structures Used:
Results.java
1) registeredCourses - An arraylist to store list of courses allocated to a student.

StateUtil.java - It is a helper class which contains all the data structures and methods required by each state.
1) group - It is an array of 5 elements to store number of courses allocated in each group
2) semesterSubjects - An arraylist used to store courses allocated in current semester(semster in which a student is when a course is being allocated).
3) courses - An arraylist list to track which all courses the student has already taken. I am using this array list to check pre-requiste condition. It is initialized with 26 null characters.
4) waitlist - A queue to maintain courses which cannot be allocated before the allocation of its pre-requisites.
-----------------------------------------------------------------------
## Design:

Schema used to register courses in the waitlist:

I have assumed that student would want to take courses in the order mentioned in the input file. Hence I have written code in a such a way that waitlist is checked every time after each course allocation, if any courses in the waitlist is possible to allocated student will be registered to that course.

Eg:

input.txt - B A E I O U
output - Initially B is added to waitlist since it does not satisfy pre-requisite condition. The algorimthm loops over waitlist after each subject allocation. After allocation of course "I", waitlist is again traversed. This time since "A" has been already allocated, student is allowed to take "B". So course "B" is allocated and is removed from the waitlist.

-----------------------------------------------------------------------
## State Diagram:
![DP state diagram](https://github.com/csx42/cs542-fall-23-assign3-ssathyanaray2/assets/144637821/2990af21-aa88-4de4-b9b3-5763efb19710)

-----------------------------------------------------------------------
## References:

https://medium.com/@mlbors/what-is-a-finite-state-machine-6d8dec727e2c#:~:text=A%20Finite%20State%20Machine%2C%20or,artificial%20intelligence%2C%20games%20or%20linguistics.

https://sourcemaking.com/design_patterns/state

https://nulab.com/learn/software-development/a-simple-guide-to-drawing-your-first-state-diagram-with-examples/

https://www.youtube.com/watch?v=RljSBrZeJ3w

-----------------------------------------------------------------------
## Academic Honesty statement:
"I have done this assignment completely on my own. I have not copied it, nor have I given my solution to anyone else. I understand that if I am involved in plagiarism or cheating I will have to sign an official form that I have cheated and that this form will be stored in my official university record. I also understand that I will receive a grade of 0 for the involved assignment for my first offense and that I will receive a grade of F for the course for any additional offense.""

Date: 11/14/2023
