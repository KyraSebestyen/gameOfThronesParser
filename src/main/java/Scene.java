import java.util.List;

public class Scene {

    private final List<Person> persons;
    private final Description description;
    private final List<SpokenText> spokenText;

    public Scene(List<Person> persons, Description description, List<SpokenText> spokenText) {
        this.persons = persons;
        this.description = description;
        this.spokenText = spokenText;
    }

    public List<Person> getPersons() {
        return persons;
    }
}
