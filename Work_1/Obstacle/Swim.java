package Work_1.Obstacle;

public class Swim extends Course {
    public Swim(String name, int distance) {
        super(name, distance);
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public boolean doIt(int dist) {
        return dist >= distance;
    }
}
