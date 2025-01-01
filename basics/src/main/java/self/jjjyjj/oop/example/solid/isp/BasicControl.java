package self.jjjyjj.oop.example.solid.isp;

public class BasicControl implements Control {
    @Override
    public void on() {
        System.out.println("TV is on");
    }

    @Override
    public void off() {
        System.out.println("TV is off");
    }

    @Override
    public void startRecording() {
        System.out.println("operation not supported");
    }


}
