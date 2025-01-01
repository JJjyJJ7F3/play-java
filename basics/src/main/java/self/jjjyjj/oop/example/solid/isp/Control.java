package self.jjjyjj.oop.example.solid.isp;

public interface Control {
    // entry level TV features
    void on();
    void off();
    void channelUp();
    void channelDown();

    // smart TV only features
    void startRecording();
    void stopRecording();
    void launchYouTube();
    void launchNetflix();
}
