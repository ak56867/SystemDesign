import java.util.List;

public abstract class StudentBuilder {
    int rollNumber;
    String name;
    int age;
    String fatherName;
    String motherName;
    int contact;
    List<String> subjects;

    public StudentBuilder setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
        return this;
    }

    public StudentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public StudentBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public StudentBuilder setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }

    public StudentBuilder setMotherName(String motherName) {
        this.motherName = motherName;
        return this;
    }

    public StudentBuilder setContact(int contact) {
        this.contact = contact;
        return this;
    }

    public abstract StudentBuilder setSubjects();

    //this method is necessary for builder pattern as this method finally returns the object of type Student (class for which builder is created)
    public Student build() {
        return new Student(this);
    }
}
