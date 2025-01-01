package self.jjjyjj.oop.example.solid.isp;

public class TVControlDemo {
    public static void main(String[] args) {
        BasicControl basicControl = new BasicControl();
        basicControl.on();
        basicControl.startRecording();
        basicControl.off();

        System.out.println();

        SmartTVControl smartTVControl = new SmartTVControl();
        smartTVControl.on();
        smartTVControl.startRecording();
        smartTVControl.off();

    }
}
