package Work_1.Obstacle;

public class Wall extends Course {
    public Wall(String name, int distance) {
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
