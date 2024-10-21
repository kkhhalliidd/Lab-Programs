import java.util.Scanner;

class InputScanner {
protected Scanner scanner = new Scanner(System.in);

public void close() {
scanner.close();
}
}

abstract class Shape extends InputScanner {
protected int dimension1;
protected int dimension2;

public abstract void printArea();
}

class Rectangle extends Shape {
public Rectangle() {
System.out.print("Enter the length of the rectangle: ");
dimension1 = scanner.nextInt();
System.out.print("Enter the breadth of the rectangle: ");
dimension2 = scanner.nextInt();
}

public void printArea() {
int area = dimension1 * dimension2;
System.out.println("Area of Rectangle: " + area);
}
}

class Triangle extends Shape {
public Triangle() {
System.out.print("Enter the base of the triangle: ");
dimension1 = scanner.nextInt();
System.out.print("Enter the height of the triangle: ");
dimension2 = scanner.nextInt();
}

public void printArea() {
double area = 0.5 * dimension1 * dimension2;
System.out.println("Area of Triangle: " + area);
}
}

class Circle extends Shape {
public Circle() {
System.out.print("Enter the radius of the circle: ");
dimension1 = scanner.nextInt();
}

public void printArea() {
double area = Math.PI * dimension1 * dimension1;
System.out.println("Area of Circle: " + area);
}
}

public class Area {
public static void main(String[] args) {
Shape rectangle = new Rectangle();
rectangle.printArea();

Shape triangle = new Triangle();
triangle.printArea();

Shape circle = new Circle();
circle.printArea();

rectangle.close();
}
}


