package exercise;

// BEGIN
class App {
    public static void main(String[] args) {
        Point point = new Point(5, 7);
        Circle circle = new Circle(point, 4);
        printSquare(circle);
    }

    public static void printSquare(Circle c) {
        try {
            System.out.println(Math.round(c.getSquare()));
        } catch (NegativeRadiusException e) {
            System.out.println(e);
        } finally {
            System.out.println("Вычисление окончено");
        }
    }
}
// END
