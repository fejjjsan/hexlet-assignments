package exercise;

// BEGIN
public class Segment {
    private final Point beginPoint;
    private final Point endPoint;
    private final Point midPoint;

    public Segment(Point p1, Point p2) {
        this.beginPoint = p1;
        this.endPoint = p2;
        this.midPoint = new Point((p1.getX() + p2.getX()) / 2, (p1.getY() + p2.getY()) / 2);
    }

    public Point getBeginPoint() {
        return beginPoint;
    }
    public Point getEndPoint() {
        return endPoint;
    }
    public Point getMidPoint() {
        return midPoint;
    }
}
// END
