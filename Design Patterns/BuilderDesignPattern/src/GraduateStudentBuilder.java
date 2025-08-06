import java.util.ArrayList;
import java.util.List;

public class GraduateStudentBuilder extends StudentBuilder{
    @Override
    public StudentBuilder setSubjects() {
        List<String> subjects = new ArrayList<>();
        subjects.add("Java");
        subjects.add("Engineering drawing");
        subjects.add("Maths");
        this.subjects = subjects;
        return this;
    }
}
