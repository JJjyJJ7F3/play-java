package self.jjjyjj.tdd.ch05;

public class Username {
    private final String name;

    public Username(String name) {
        this.name = name;
    }

    public String asLowerCase() {
        return name.toLowerCase();
    }
}
