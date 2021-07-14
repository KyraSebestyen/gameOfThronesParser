import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InformationReader {
    private String fileName;

    public InformationReader(String fileName) {
        this.fileName = fileName;
    }

    public Episode read() throws IOException, URISyntaxException {
        URL resource = this.getClass().getResource(fileName);
        Path path = Paths.get(resource.toURI());
        File file = new File(String.valueOf(path));
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        Episode episode = new Episode();
        while ((line = bufferedReader.readLine()) != null) {
            if (line.equals("\r\n")) {
                continue;
            }
            if (matchSpokenText(line) != null) {
                SpokenText spokenText = matchSpokenText(line);
                episode.addText(spokenText);
                System.out.println(spokenText);
            } else if (matchDescription(line) != null) {
                Description description = matchDescription(line);
                episode.addText(description);
                System.out.println(description);
            }
        }
        return episode;
    }

    public SpokenText matchSpokenText(String line) {
        String patternOneName = "^([A-Z]+):(.*)$";
        Matcher matcherOneName = Pattern.compile(patternOneName).matcher(line);
        String patternOneNameTwoParts = "^([A-Z]+ [A-Z]+):(.*)$";
        Matcher matcherOneNameTwoParts = Pattern.compile(patternOneNameTwoParts).matcher(line);
        String patternTwoNames = "^[A-Z]+(\\/[A-Z]+):.*$"; //how often?? Ignore for now
        String patternOneNameWithAddressee = "^([A-Z]+) \\(.*to ([A-Z]+)\\):(.*)$";
        Matcher matcherOneNameWithAddressee = Pattern.compile(patternOneNameWithAddressee).matcher(line);
        String patternOneNameTwoPartsWithAddressee = "^([A-Z]+ [A-Z]+) \\(.*to ([A-Z]+)\\):(.*)$";
        Matcher matcherOneNameTwoPartsWithAddressee = Pattern.compile(patternOneNameTwoPartsWithAddressee).matcher(line);
        String patternTwoNamesWithAddressee = "^[A-Z]+(\\/[A-Z]+)( \\(.*[A-Z]+\\)):.*$"; //how often?? Ignore for now
        if (matcherOneName.matches()) {
            String speaker = matcherOneName.group(1);
            Person person = new Person(speaker);
            String spoken = matcherOneName.group(2);
            return new SpokenText(person, null, spoken);
        } else if (matcherOneNameTwoParts.matches()) {
            String speaker = matcherOneNameTwoParts.group(1);
            Person person = new Person(speaker);
            String spoken = matcherOneNameTwoParts.group(2);
            return new SpokenText(person, null, spoken);
        } else if (matcherOneNameWithAddressee.matches()) {
            String speaker = matcherOneNameWithAddressee.group(1);
            String addressee = matcherOneNameWithAddressee.group(2);
            Person personSpeaker = new Person(speaker);
            Person personAddressee = new Person(addressee);
            String spoken = matcherOneNameWithAddressee.group(3);
            return new SpokenText(personSpeaker, personAddressee, spoken);
        }
        return null;
    }

    public Description matchDescription(String line) {
        String patternDescription = "\\[(.*)]";
        Matcher descriptionMatcher = Pattern.compile(patternDescription).matcher(line);
        if (descriptionMatcher.matches()) {
            return new Description(descriptionMatcher.group(1));
        }
        return null;
    }
}
