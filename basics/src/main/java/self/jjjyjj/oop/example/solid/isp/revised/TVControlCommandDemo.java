package self.jjjyjj.oop.example.solid.isp.revised;

public class TVControlCommandDemo {
    public static void main(String[] args) {
        Commands tvCommands = new Commands();
        tvCommands.initialise(true);
        tvCommands.execute(3);
    }
}
