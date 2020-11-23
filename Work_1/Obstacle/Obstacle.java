package Work_1.Obstacle;

public abstract class Obstacle implements BehevObstacle {
    protected int distance;
    protected String name;

    public Obstacle(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public Obstacle(int distance) {
        this.distance = distance;
    }

    protected abstract boolean doIt(int dist);

    @Override
    public boolean pass(int dist) {
        return doIt(dist);
    }


}
