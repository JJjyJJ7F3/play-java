package self.jjjyjj.oop.example.solid.dip;

public class TextConversion {
    private final Input input;
    private final Output output;

    public TextConversion(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void showInputInUppercase(){
        String inputText = input.fetch();
        String upperCaseText = inputText.toUpperCase();
        output.display(upperCaseText);
    }
}
