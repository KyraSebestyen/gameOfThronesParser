public class SpokenText {

    private final Person speaker;
    private final Person addressee;
    private final String text;

    public SpokenText(Person speaker, Person addressee, String text) {
        this.speaker = speaker;
        this.addressee = addressee;
        this.text = text;
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
