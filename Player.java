package Helpers;

public class Player implements Comparable<Player>{
    int points;
    String name;
    public Player(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Player o) {
        return o.points - this.points;
    }
}
