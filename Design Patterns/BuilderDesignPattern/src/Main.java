public class Main {
    public static void main(String[] args) {
        Director director = new Director(new SchoolStudentBuilder());
        Director director1 = new Director(new GraduateStudentBuilder());

        Student schoolStudent = director.createStudent();
        Student graduateStudent = director1.createStudent();

        System.out.println(schoolStudent.toString());
        System.out.println(graduateStudent.toString());
    }
}