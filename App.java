package main;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    
        Scanner sc = new Scanner(System.in);
    
        
        
        System.out.println("Tervetuloa Gifu-järjestelmään");
        System.out.println("Mille yliopistolle haluat ottaa järjestelmän käyttöön?");
        String universityName = sc.nextLine();
        Gifu gifu = new Gifu(universityName);



        boolean exit = false;
        while(!exit) {

            System.out.println("1) Luo uusi kurssi, 2) Luo uusi opiskelija, 3) Listaa kurssit, 4) Listaa opiskelijat, 5) Lisää opiskelija kurssille, 6) Anna kurssiarvosanat, 7) Listaa kurssilla olevat opiskelijat, 8) Listaa opiskelijan arvosanat, 9) Listaa kaikkien kurssien kaikkien opiskelijoiden arvosanat, 0) Lopeta ohjelma");


            if (sc.hasNext()) {
                int i = 0;
                String stringInput = sc.nextLine();
                i = Integer.parseInt(stringInput);


                switch (i) {
                    case 1:
                        System.out.println("Anna kurssin nimi:");
                        String courseName = sc.nextLine();
                        System.out.println("Anna kurssin ID:");
                        String idCourse = sc.nextLine();
                        System.out.println("Anna kurssin maksimi opiskelijamäärä:");
                        int maxNumberOfStudents = Integer.parseInt(sc.nextLine());

                        Course course = new Course(courseName, idCourse, maxNumberOfStudents);
                        gifu.addCourse(course);

                        break;


                    case 2:
                        System.out.println("Anna opiskelijan nimi:");
                        String studentName = sc.nextLine();
                        System.out.println("Anna opiskelijan opiskelijanumero:");
                        String idStudent = sc.nextLine();

                        Student student = new Student(studentName, idStudent);
                        gifu.addStudent(student);

                        break;
                    
                    case 3:
                        gifu.listCourses();
                        break;
                    
                    
                    case 4:
                        gifu.listStudents();
                        break;
                    

                    case 5: 
                    
                        gifu.listCourses();
                        System.out.println("Mille kurssille haluat lisätä opiskelijan? Syötä kurssin numero:");
                        int courseNumber = Integer.parseInt(sc.nextLine());
                        Course courseByIndex= gifu.getCourse(courseNumber);
                        gifu.listStudents();
                        System.out.println("Minkä opiskelijan haluat lisätä kurssille? Syötä opiskelijan numero:");
                        int studentNumber = Integer.parseInt(sc.nextLine());
                        Student studentByIndex = gifu.getStudent(studentNumber);

                        gifu.enrollStudent(studentByIndex, courseByIndex);
                        break;

                    case 6:
                        gifu.listCourses();
                        System.out.println("Minkä kurssin haluat arvostella? Syötä kurssin numero:");
                        int courseNumber2 = Integer.parseInt(sc.nextLine());
                        Course courseByIndex2 = gifu.getCourse(courseNumber2);
                        
                        for (Enrollment enrollment : gifu.getEnrollments(courseByIndex2)) {
                            System.out.println("Anna arvosana opiskelijalle " + enrollment.getStudent().getStudentId() + " " + enrollment.getStudent().getStudentName());
                            int grade = Integer.parseInt(sc.nextLine());
                            enrollment.gradeCourse(grade);
                        }

                        break;
                    
                    case 7:
                        gifu.listCourses();
                        System.out.println("Minkä kurssin opiskelijat haluat listata? Syötä kurssin numero:");
                        int courseNumber3 = Integer.parseInt(sc.nextLine());
                        Course courseByIndex3 = gifu.getCourse(courseNumber3);

                        for (Enrollment enrollment : gifu.getEnrollments(courseByIndex3)) {
                            Student student2 = enrollment.getStudent();
                            int grade2 = enrollment.getGrade();
                            System.out.println(student2.getStudentId() + " " + student2.getStudentName() + ", arvosana: " + grade2);


                        }
                        break;
                    
                    case 8:
                        gifu.listStudents();
                        System.out.println("Minkä opiskelijan arvosanat haluat listata? Syötä opiskelijan numero:");
                        int studentNumber2 = Integer.parseInt(sc.nextLine());
                        Student studentByIndex2 = gifu.getStudent(studentNumber2);

                        System.out.println("Opiskelijan " + studentByIndex2.getStudentId() + " " + studentByIndex2.getStudentName() + " arvosanat:");
                        for (Enrollment enrollment : gifu.getEnrollments(studentByIndex2)) {
                            Course course3 = enrollment.getCourse();
                            int grade3 = enrollment.getGrade();
                            System.out.println(course3.getCourseId() + " " + course3.getCourseName() + ", arvosana: " + grade3);
        

                        }
                        break;
                    
                    
                    case 9:
                        for (Course course5 : gifu.getCourses()) {
                            System.out.println(course5.getCourseId() + " " + course5.getCourseName());


                            for (Enrollment enrollment : gifu.getEnrollments(course5)) {
                                Student student4 = enrollment.getStudent();
                                int grade4 = enrollment.getGrade();
                                System.out.println(student4.getStudentId() + " " + student4.getStudentName() + ", arvosana: " + grade4);
                            }
                            
                        }
                        
                        break;
                    
                    case 0:
                        System.out.println("Kiitos ohjelman käytöstä.");
                        exit = true;
                        break;

                    default:
                        System.out.println("Syöte oli väärä");
                        break;
                        

                        
                        













                    









                        
































                }



            }
        
        }
        

    }
}
