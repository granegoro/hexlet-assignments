package exercise.daytime;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

public class Night implements Daytime {
    private String name = "night";

    public String getName() {
        return name;
    }

    // BEGIN

    @PostConstruct
    public void init() {
        var message = "\\nBean Night is initialized!\\n";
        System.out.println(message);
    }

    // END
}
