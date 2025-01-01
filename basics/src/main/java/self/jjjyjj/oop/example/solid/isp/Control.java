package self.jjjyjj.oop.example.solid.isp;

public interface Control {
    // entry level TV features
    void on();
    void off();

    // smart TV only features
    void startRecording();
}
