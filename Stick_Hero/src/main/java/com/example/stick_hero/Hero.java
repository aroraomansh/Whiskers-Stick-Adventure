public class Hero {
    private double xCoord;
    private double yCoord;
    private double width;
    private double height;
    private boolean flag;

    public Hero(double xCoord, double yCoord, double width, double height, boolean flag) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.width = width;
        this.height = height;
        this.flag = flag;
    }

    void wait(flag){
        //do later
    }

    void move(){
        //do later
    }

    void fall(){
        //do later
    }

    void extendStick(){
        //do later
    }

    void flip(){
        //do later
    }

    void collectCherry(){
        //do later
    }

    public double getxCoord() {
        return xCoord;
    }

    public void setxCoord(double xCoord) {
        this.xCoord = xCoord;
    }

    public double getyCoord() {
        return yCoord;
    }

    public void setyCoord(double yCoord) {
        this.yCoord = yCoord;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "xCoord=" + xCoord +
                ", yCoord=" + yCoord +
                ", width=" + width +
                ", height=" + height +
                ", flag=" + flag +
                '}';
    }
}