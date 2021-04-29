package hu.nive.ujratervezes.kepesitovizsga.army;

public class Swordsman extends MilitaryUnit {

    private boolean isShieldIntact= true;

    public Swordsman(boolean pancel) {
        super(100, 10, pancel);
    }

    @Override
    public void sufferDamage(int damage) {
        if(isShieldIntact){
            isShieldIntact= false;

        }else{
            super.sufferDamage(damage);
        }

    }
}
