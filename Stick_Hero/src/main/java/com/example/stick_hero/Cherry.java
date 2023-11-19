public class Cherry {

    private double xCoord;
    private double points;

    public Cherry(double xCoord, double points) {
        this.xCoord = xCoord;
        this.points = points;
    }

    public double getxCoord() {
        return xCoord;
    }

    public void setxCoord(double xCoord) {
        this.xCoord = xCoord;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Cherry{" +
                "xCoord=" + xCoord +
                ", points=" + points +
                '}';
    }
}