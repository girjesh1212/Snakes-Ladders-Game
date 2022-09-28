import java.util.*;

public class Player {
    private String id;
    private String name;
    private int position;
    private int skip;

    Player(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.position = 0;
        this.skip = 0;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        if (position != -1) {
            this.position = position;
        }
        return;
    }

    public int getSkip() {
        return this.skip;
    }

    public void setSkip() {
        this.skip = 3;
    }

    public void decreaseSkip() {
        this.skip--;
    }

}
