package Work_1;


import Work_1.Competitor.*;
import Work_1.Obstacle.*;

public class Main {

    public static void main(String[] args) {


        Members[] teams = {
                new Human("Fred"),
                new Robot("Robot"),
                new Robot("Bionikle"),
                new Human("Sara Conor")
        };

        Obstacle[] obstacles = {
                new Swim("swim", 50),
                new Wall( "wall",10),
                new Run( "run", 250),
                new Swim( "swim", 50),
                new Run( "run",100),
        };

        Team team = new Team("Jank", teams);
        System.out.println(team.getTeamName());

        team.go(teams, obstacles);


    }
    }


