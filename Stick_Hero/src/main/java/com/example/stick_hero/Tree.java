public class Tree {
    private double x;
    private String color;

    public Tree(double x, String color) {
        this.x = x;
        this.color = color;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "x=" + x +
                ", color='" + color + '\'' +
                '}';
    }
}