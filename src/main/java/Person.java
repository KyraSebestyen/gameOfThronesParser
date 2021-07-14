import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

public class Person {
    @JacksonXmlText
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
