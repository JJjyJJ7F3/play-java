package self.jjjyjj.oop.example.solid.dip;

import java.util.Scanner;

public class TextUtil {
    public void showInputInUppercase(){
        // Fetch keyboard input
        Scanner scanner = new Scanner(System.in);
        String inputText = scanner.nextLine();

        // Convert
        String upperCaseText = inputText.toUpperCase();

        // Display
        System.out.println(upperCaseText);
    }

    public static void main(String[] args) {
        new TextUtil().showInputInUppercase();
    }
}
