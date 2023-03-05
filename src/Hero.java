import java.util.Random;
public class Hero {
    String name;
    int hitPoints;
    Random random = new Random();

    public Hero(String name) {
        this.name = name;
        hitPoints = 100;
    }

    public String getName() {
        return name;
    }
    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int points) {
        this.hitPoints = points;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                '}';
    }

    public void attack(Hero opponent) {
        double num = 0.00 + (random.nextDouble() * (0.99 - 0.00));
        if(num < 0.5) {
            opponent.setHitPoints(opponent.getHitPoints()-10);
        }
        else {
            hitPoints -= 10;
        }
    }

    public void senzuBean() {
        hitPoints = 100;
    }

    private void fightUntilTheDeathHelper(Hero opponent) {
        while(hitPoints > 0 && opponent.getHitPoints() > 0) {
            attack(opponent);
        }
    }

    public String fightUntilTheDeath(Hero opponent) {
        senzuBean();
        opponent.senzuBean();
        fightUntilTheDeathHelper(opponent);
        return name + ": " + hitPoints + opponent.getName() + ": " + opponent.getHitPoints();
    }

    private int [] nFightsToTheDeathHelper(Hero opponent, int n) {
        int [] points = new int[2];
        for(int i = n; i > 0; i--) {
            fightUntilTheDeathHelper(opponent);
            if (hitPoints == 0) {
                points[1]++;
            }
            else if (opponent.getHitPoints() == 0) {
                points[0]++;
            }
            senzuBean();
            opponent.senzuBean();
        }
        return points;
    }

    public String nFightsToTheDeath(Hero opponent, int n) {
        int [] points = nFightsToTheDeathHelper(opponent, n);
        if(points[0] > points[1]) {
            return(name + ": " + points[0] + " wins\n" + opponent.getName() + ": " + points[1] + " wins\n" + name + " wins!");
        }
        else if (points[0] < points[1]) {
            return(name + ": " + points[0] + " wins\n" + opponent.getName() + ": " + points[1] + " wins\n" + opponent.getName() + " wins!");
        }
        else {
            return(name + ": " + points[0] + " wins\n" + opponent.getName() + ": " + points[1] + " wins\n" + "OMG! It was actually a draw!");

        }
    }

}
