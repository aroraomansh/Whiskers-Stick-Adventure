public class Platform {

    private double xcoord;
    private double width;
    private double redAreaStart;
    private double redAreaEnd;

    public Platform(double xcoord, double width, double redAreaStart, double redAreaEnd) {
        this.xcoord = xcoord;
        this.width = width;
        this.redAreaStart = redAreaStart;
        this.redAreaEnd = redAreaEnd;
    }

    public double getXcoord() {
        return xcoord;
    }

    public void setXcoord(double xcoord) {
        this.xcoord = xcoord;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getRedAreaStart() {
        return redAreaStart;
    }

    public void setRedAreaStart(double redAreaStart) {
        this.redAreaStart = redAreaStart;
    }

    public double getRedAreaEnd() {
        return redAreaEnd;
    }

    public void setRedAreaEnd(double redAreaEnd) {
        this.redAreaEnd = redAreaEnd;
    }

    @Override
    public String toString() {
        return "Platform{" +
                "xcoord=" + xcoord +
                ", width=" + width +
                ", redAreaStart=" + redAreaStart +
                ", redAreaEnd=" + redAreaEnd +
                '}';
    }
}