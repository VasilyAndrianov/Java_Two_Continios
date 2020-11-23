package Work_1.Obstacle;


public class Course extends Obstacle {


    public Course(String name, int distance) {
        super(name, distance);
    }


    @Override
    public boolean doIt(int dist) {
        return dist >= distance;
    }


}

