package Work_1.Competitor;


import Work_1.Obstacle.Obstacle;

public class Robot implements Members {
    private String name;

    public Robot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    //    public Robot(String name, int maxDistanceRun, int maxDistanceJump, int maxDistanceSwim) {
//        super(name, maxDistanceRun, maxDistanceJump, maxDistanceSwim);
//    }

    @Override
    public boolean isGoDistance(Obstacle obstacle, int distance) {
        return obstacle.pass(distance);
    }
}
