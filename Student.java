package net.jevindement.collegeletgo;

public class Student {

    private int studentEmail;
    private String studentFirst;
    private String studentLast;
    private String studentID;
    public int numPosts;

    public Student() {}
    public Student(int email, String ID, String studentFirst, String studentLast) {
        this.studentEmail = email;
        this.studentFirst = studentFirst;
        this.studentLast = studentLast;
        this.studentID = ID;
        this.numPosts = 0;
    }

    public void setEmail(int email) {
        this.studentEmail = email;
    }

    public int getEmail() {

        return this.studentEmail;
    }

    public String getID() {
        return studentID;
    }

    public void setStudentName(String studentfirst, String studentlast) {

        this.studentFirst = studentfirst;
        this.studentLast = studentlast;
    }

    public String getStudentName() {
        String name = this.studentFirst + this.studentLast;
        return name;
    }

    public String getStudentFirst() {
        return this.studentFirst;
    }

    public String getStudentLast() {
        return this.studentLast;
    }

    public void post() {
        this.numPosts++;
    }
}
