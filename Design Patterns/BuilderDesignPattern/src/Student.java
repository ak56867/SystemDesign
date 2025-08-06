import java.util.List;

public class Student {
    int rollNumber;
    String name;
    int age;
    String fatherName;
    String motherName;
    int contact;
    List<String> subjects;

    public Student(StudentBuilder studentBuilder){ //using builder object to set values to fields
        this.age = studentBuilder.age;
        this.contact = studentBuilder.contact;
        this.fatherName = studentBuilder.fatherName;
        this.motherName = studentBuilder.motherName;
        this.name = studentBuilder.name;
        this.rollNumber = studentBuilder.rollNumber;
        this.subjects = studentBuilder.subjects;
    }

    public String toString() {
        return ""+ " roll number: " + this.rollNumber +
                " age: " + this.age +
                " name: " + this.name +
                " father name: " + this.fatherName +
                " mother name: " + this.motherName +
                " subjects: " + subjects.get(0) + "," + subjects.get(1) + "," + subjects.get(2);

    }
}
