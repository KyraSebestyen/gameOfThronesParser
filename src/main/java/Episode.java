import java.util.List;

public class Episode {
    private final String name;
    private final List<Scene> scenes;

    public Episode(String name, List<Scene> scenes) {
        this.name = name;
        this.scenes = scenes;
    }

    public String getName() {
        return name;
    }
}
