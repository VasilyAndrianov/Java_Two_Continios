package Work_1.Competitor;


import Work_1.Obstacle.Obstacle;

import java.util.Random;

public class Team {
    String teamName;
    Members [] teamMembers;


    public Team(String teamName, Members[] teamMembers){
        this.teamName = teamName;
        this.teamMembers = teamMembers;
    }

    public String getTeamName(){
        return "Team name: " + teamName;
    }
    public Members[] getMembers(){
        return teamMembers;
    }

    Random ranDist = new Random();

    public void go(Members [] m, Obstacle [] o){
        for (Members member : m){
            for (Obstacle obstacle : o ){
                if (member.isGoDistance(obstacle, ranDist.nextInt(400))){
                    System.out.println(member.getName() + " приодолел " + obstacle.getName() );
                }else {
                    System.out.println(member.getName() + " не удалось приодолеть " + obstacle.getName());
                    break;
                }

            }
        }
    }


}
