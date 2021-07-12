import java.util.List;

public class Description {

    private final List<Person> persons;
    private final String description;

    public Description(List<Person> persons, String description) {
        this.persons = persons;
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if((persons == null) || (persons.isEmpty())){
            sb.append("Description without persons");
        } else {
            sb.append("Description with: ");
            persons.forEach(person -> sb.append(person).append(", "));
        }
        return sb.toString();
    }
}
