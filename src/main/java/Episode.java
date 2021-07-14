import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;
import java.util.List;

public class Episode {

    @JacksonXmlProperty(localName = "Foo")
    @JacksonXmlElementWrapper(useWrapping = false)
    private final List<SpeechAndStage> body = new ArrayList<>();

    public void addText(SpeechAndStage toAdd){
        this.body.add(toAdd);
    }

    public List<SpeechAndStage> getBody() {
        return body;
    }
}
