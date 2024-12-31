package self.jjjyjj.oop.example.solid.dip;

public class DatabaseInput implements Input {
    @Override
    public String fetch() {
        return "data from database";
    }
}
