import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class SpokenText implements SpeechAndStage {

    private final Person speaker;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Person addressee;
    @JacksonXmlProperty(localName = "p")
    private final String text;

    public SpokenText(Person speaker, Person addressee, String text) {
        this.speaker = speaker;
        this.addressee = addressee;
        this.text = text;
    }

    public Person getSpeaker() {
        return speaker;
    }

    public Person getAddressee() {
        return addressee;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(addressee != null) {
            sb.append(speaker.toString()).append(" said to ").append(addressee).append(": ").append(text);
        } else {
            sb.append(speaker.toString()).append( " said: ").append(text);
        }
        return sb.toString();
    }
}
