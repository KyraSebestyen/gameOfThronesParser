import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

public class Description implements SpeechAndStage {

    @JacksonXmlText
    private final String description;

    public Description(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}
