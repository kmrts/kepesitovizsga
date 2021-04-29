package hu.nive.ujratervezes.kepesitovizsga.army;

import java.util.ArrayList;
import java.util.List;

public class Army {
    /*
    A hadseregnek az alábbi metódusai vannak:

    addUnit(MilitaryUnit militaryUnit), amivel egy katonai egységet tudunk hozzáadni a sereghez,

    damageAll(int damage), ami a sereg minden egységének életerejéből levonja a paraméterül kapott értéket,
    valamint eltávolítja a seregből azokat az egységeket,
    melyeknek így 25 pont alá csökkent az életerejük (azaz harcképtelenek vagy halottak),

    getArmyDamage(), ami visszaadja, hogy az aktuális támadással mennyi sebzést okoz a sereg összesen,

    getArmySize(), ami visszaadja, hogy hány egységből áll a sereg.

     */
    private List<MilitaryUnit> units= new ArrayList<>();

    public void addUnit(MilitaryUnit militaryUnit){
        units.add(militaryUnit);
    }

    public int getArmySize(){
        return units.size();

    }
    public int getArmyDamage(){
        int count= 0;
        for(MilitaryUnit mu: units){
            count+= mu.doDamage();
        }
        return count;
    }

    public void damageAll(int damage){
        List<MilitaryUnit> remove= new ArrayList<>();

        for(MilitaryUnit mu: units){
            mu.decremHitPoints(damage);
            if(mu.getHitPoints()< 25){
                remove.add(mu);
            }
        }
        units.removeAll(remove);

    }
}
