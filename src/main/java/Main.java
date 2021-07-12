import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        InformationReader informationReader = new InformationReader("/season1episode1.txt");
        informationReader.read();
    }
}
