import java.util.ArrayList;
import java.util.List;

public class SchoolStudentBuilder extends StudentBuilder{
    @Override
    public StudentBuilder setSubjects() {
        List<String> subjects = new ArrayList<>();
        subjects.add("English");
        subjects.add("Hindi");
        subjects.add("Maths");
        this.subjects = subjects;
        return this;
    }
}
