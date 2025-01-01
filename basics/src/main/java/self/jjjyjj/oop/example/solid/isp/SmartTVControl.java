package self.jjjyjj.oop.example.solid.isp;

public class SmartTVControl implements Control {
    @Override
    public void on() {

    }

    @Override
    public void off() {

    }

    @Override
    public void channelUp() {

    }

    @Override
    public void channelDown() {

    }

    @Override
    public void startRecording() {
        System.out.println("operation supported");
    }

    @Override
    public void stopRecording() {
        System.out.println("operation supported");
    }

    @Override
    public void launchYouTube() {
        System.out.println("operation supported");
    }

    @Override
    public void launchNetflix() {
        System.out.println("operation supported");
    }
}
