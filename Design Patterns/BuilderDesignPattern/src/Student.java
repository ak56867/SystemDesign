import java.util.List;

public class Student {
    int rollNumber;
    String name;
    int age;
    String fatherName;
    String MotherName;
    int contact;
    List<String> subjects;

    public Student(StudentBuilder studentBuilder){ //using builder object to set values to fields
        this.age = studentBuilder.age;
        this.contact = studentBuilder.contact;
        this.fatherName = studentBuilder.fatherName;
        this.MotherName = studentBuilder.MotherName;
        this.name = studentBuilder.name;
        this.rollNumber = studentBuilder.rollNumber;
    }
}
