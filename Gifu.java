package main;

import java.util.ArrayList;

public class Gifu {
    private String university;
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Enrollment> enrollments = new ArrayList<>();




    public Gifu(String university) {
        this.university = university;
    }
    
    public void addCourse(Course course) {
        courses.add(course);
    
    }



    public Course getCourse(int id) {
        return courses.get(id);
    }



    public ArrayList<Course> getCourses() {
        return courses;
        
    }


    public void listCourses() {
        for (int i = 0; i < courses.size(); i++) {
            System.out.println(i + ") " + courses.get(i).getCourseId() + " " + courses.get(i).getCourseName());

        }
        

    }

    
    public void addStudent(Student student) {
        students.add(student);
        
    }

    public Student getStudent(int id) {
        return students.get(id);
    }


    public void listStudents() {
        for (int i = 0; i < students.size(); i++) {
            System.out.println(i + ") " + students.get(i).getStudentId() + " " + students.get(i).getStudentName());
        }

    }

    
    public void enrollStudent(Student student, Course course) {
        enrollments.add(new Enrollment(student, course));

        
    }

    public ArrayList<Enrollment> getEnrollments(Course course) {
        ArrayList<Enrollment> courseEnrollments = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getCourse() == course) {
                courseEnrollments.add(enrollment);
            }
        }
        
        return courseEnrollments;
    }


    public ArrayList<Enrollment> getEnrollments(Student student) {
        ArrayList<Enrollment> studentEnrollments = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudent() == student) {
                studentEnrollments.add(enrollment);
            }
        }

        return studentEnrollments;
    }


    
}
