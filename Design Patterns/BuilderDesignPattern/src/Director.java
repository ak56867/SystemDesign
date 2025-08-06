public class Director {
    StudentBuilder studentBuilder;

    public Director(StudentBuilder studentBuilder) {
        this.studentBuilder = studentBuilder;
    }

    public Student createStudent() {
        if(studentBuilder instanceof SchoolStudentBuilder) {
            return schoolStudent();
        } else {
            return graduateStudent();
        }
    }

    private Student schoolStudent() {
        return studentBuilder.setRollNumber(1).setAge(5).setFatherName("ABC").setMotherName("xyz").build();
    }

    private Student graduateStudent()  {
        return studentBuilder.setRollNumber(105).setContact(32543).setName("PQR").build();
    }
}
