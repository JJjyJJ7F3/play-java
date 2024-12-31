package self.jjjyjj.oop.example.solid.dip;

public class ConsoleOutput implements Output {
    @Override
    public void display(String message) {
        System.out.println(message);
    }
}
