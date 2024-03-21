//Create a model following class diagrams and objects
class Point{
    String dot = "\"dot\"";
    public void onePoint(){
        System.out.println("1 dot has 1 \"Point\".");
    }
    public String dots(){
        return dot;
    }

}
//class "Line" is the subclass of class "Point"
class Line extends Point{
    String line = "\"Line\"";
    public void oneLine(){
        System.out.println("2 \"Point\" create 1 \"Segment\", 1 \"Line\" has many \"Point\".");
    }
    public String lines(){
        return line;
    }
}
//class "Triangle" is the subclass of class "Point"
class Triangle extends Line{
    String triangle = "\"Triangle\"";
    public void oneTriangle(){
        System.out.println("3 \"Line\" can create 1 \"Triangle\", 1 \"Triangle\" has 3 sides.");
    }
    public String triangles(){
        return triangle;
    }
}
//class "Rectangle" is the subclass of class "Triangle"
class Rectangle extends Triangle{
    String rectangle = "\"Rectange\"";
    public void oneRectangle(){
        System.out.println("4 \"Line\" can create 1 \"Rectangle\", 1 \"Rectangle\" has 4 sides.");
    }
    public String rectangles(){
        return rectangle;
    }
}
public class Lab04_7 {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.onePoint();
        rectangle.oneLine();
        rectangle.oneTriangle();
        rectangle.oneRectangle();
    }
}
