package game;

public class Player {

    private int hp, np, maxHp, maxNp, xp;
    private String name;

    public Player(String name) {
        this.name = name;
        maxHp = 100;
        maxNp = 100;
        hp = maxHp;
        np = maxNp;
        xp = 0;
    }

    public void addXP(int amt) { xp += amt; }

    public void subtractHP(int amt) {
        hp -= amt;
        if (hp < 0) hp = 0;
    }

    public void subtractNP(int amt) {
        np -= amt;
        if (np < 0) np = 0;
    }

    public int getHP() { return hp; }
    public int getNP() { return np; }
    public int getXP() { return xp; }

    public String getName() { return name; }

    public void printStats() {
        System.out.println("\n--- PLAYER STATS ---");
        System.out.println("Name : " + name);
        System.out.println("HP   : " + hp + "/" + maxHp);
        System.out.println("NP   : " + np + "/" + maxNp);
        System.out.println("XP   : " + xp);
    }
}
