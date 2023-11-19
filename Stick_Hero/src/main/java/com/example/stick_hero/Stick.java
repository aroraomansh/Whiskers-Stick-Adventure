public class Stick {

    private double endCoord;
    private double length;
    private double rotationDegree = 90;

    void rotating(rotationDegree){
        //next time
    }

    void bonusPoint(){
        //next time
    }

    public Stick(double endCoord, double length, double rotationDegree) {
        this.endCoord = endCoord;
        this.length = length;
        this.rotationDegree = rotationDegree;
    }

    public double getEndCoord() {
        return endCoord;
    }

    public void setEndCoord(double endCoord) {
        this.endCoord = endCoord;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getRotationDegree() {
        return rotationDegree;
    }

    public void setRotationDegree(double rotationDegree) {
        this.rotationDegree = rotationDegree;
    }

    @Override
    public String toString() {
        return "Stick{" +
                "endCoord=" + endCoord +
                ", length=" + length +
                ", rotationDegree=" + rotationDegree +
                '}';
    }
}