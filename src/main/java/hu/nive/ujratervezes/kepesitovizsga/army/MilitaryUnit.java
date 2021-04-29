package hu.nive.ujratervezes.kepesitovizsga.army;

public abstract class MilitaryUnit {
    /*
    Minden egységnek (MilitaryUnit absztrakt ősosztály) vannak életerő pontjai (int) és támadási sebzése (int).
    Az egységeknek lehet páncéljuk (vagy van, vagy nincs).

Minden katonai egység számára elérhetőek az alábbi metódusok:
    doDamage(): adja vissza az egység sebzését int értékként.

    sufferDamage(int damage): a paraméterül kapott értéket levonja az egység életerő pontjaiból,
    ha az egység páncélozott, akkor csak az érték felét vonjuk le.

Archer
    Az íjász életereje 50 pont, sebzése 20. Nem rendelkezik páncéllal.
Heavy Cavalry
A nehézlovas életereje 150 pont, sebzése 20. Páncélozott.
A lovasság a csatát rohammal indítja, így minden lovas első támadása háromszoros sebzést okoz, az utána következők egyszereset.
(Azaz az első doDamage meghívása háromszoros értéket ad vissza, a többi egyszeres értéket.
Tárold le egy attribútumban, hogy hanyadik támadás van, azaz hányszor került meghívásra a doDamage metódus, és ez alapján dönts!)
Swordsman
A kardforgató életereje 100 pont, sebzése 10. Vagy van páncélja vagy nincs.
Minden kardforgatónak van pajzsa, amivel kivédi az első őt ért csapást.
A pajzs az első kapott sebzés 100%-át felfogja, majd összetörik, tovább nem használható.

(Tárold le attribútumban, hogy a pajzsa ép-e vagy sem! Ez alapján dönts a sebzésről!
Az első sufferDamage hívás után módosítsd az attribútum értékét!)
     */
    int hitPoints;
    int damage;
    boolean hasShield;

    public MilitaryUnit(int hitPoints, int damage, boolean pancel) {
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.hasShield = pancel;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getDamage() {
        return damage;
    }

    public boolean HasShield() {
        return hasShield;
    }

    public void decremHitPoints(int hitPoints){
        this.hitPoints-= hitPoints;
    }

    public int doDamage(){
        return damage;
    }
    public void sufferDamage(int damage){

        int reduction= hasShield ? damage/2 : damage;
        hitPoints-= reduction;
    }
}
