package hu.nive.ujratervezes.kepesitovizsga.army;

public class HeavyCavalry extends MilitaryUnit{

    private int attack= 0;

    public HeavyCavalry() {
        super(150, 20, true);
    }

    public int getTamadas() {
        return attack;
    }

    @Override
    public int doDamage() {
        attack++;

        return attack== 1 ? damage* 3: damage;

    }
}
