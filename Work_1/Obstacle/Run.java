package Work_1.Obstacle;

public class Run extends Course {
    public Run(String name,int distance) {
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
