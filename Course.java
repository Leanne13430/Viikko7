package main;

public class Course {
    private String name;
    private String id;
    private int maxNumberOfStudents;

    public Course(String name, String id, int maxNumberOfStudents) {
        this.name = name;
        this.id = id;
        this.maxNumberOfStudents = maxNumberOfStudents;

    }

    public String getCourseName() {
        return name;
    }

    
    public String getCourseId() {
        return id;
    }

    public int getMaxNumberOfStudents() {
        return maxNumberOfStudents;
    }



    
}
