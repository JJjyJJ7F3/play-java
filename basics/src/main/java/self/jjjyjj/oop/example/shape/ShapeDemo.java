package self.jjjyjj.oop.example.shape;

import java.util.ArrayList;

public class ShapeDemo {
    public static void main(String[] args) {
        var shapes = new ArrayList<Shape>();
        shapes.add(new Circle());
        shapes.add(new Square());

        shapes.forEach(Shape::draw);
    }
}
