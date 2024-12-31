package self.jjjyjj.oop.example.solid.dip;

import java.util.Scanner;

public class KeyboardInput implements Input {
    @Override
    public String fetch() {
        return new Scanner(System.in).nextLine();
    }
}
