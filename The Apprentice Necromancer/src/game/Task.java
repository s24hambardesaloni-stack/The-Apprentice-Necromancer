package game;

public class Task {

    private String name;
    private int hpCost;
    private int npCost;
    private int xpReward;

    public Task(String name, int hpCost, int npCost, int xpReward) {
        this.name = name;
        this.hpCost = hpCost;
        this.npCost = npCost;
        this.xpReward = xpReward;
    }

    public String getName() { return name; }
    public int getHpCost() { return hpCost; }
    public int getNpCost() { return npCost; }
    public int getXpReward() { return xpReward; }
}
