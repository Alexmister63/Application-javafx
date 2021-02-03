package manager.movement.direction;

public class VectorDirection implements Direction {
    private double x;
    private double y;

    public VectorDirection(double x,double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){return x;}
    public double getY(){return y;}
}
