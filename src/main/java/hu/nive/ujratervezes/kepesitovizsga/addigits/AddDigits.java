package hu.nive.ujratervezes.kepesitovizsga.addigits;

public class AddDigits {
    /*
    Hozd létre az AddDigits osztályt, és annak az addDigits(String input) metódusát.

A metódus feladata, hogy a paraméterben kapott Stringben található összes számjegyet adja össze,
és ennek az összegét adja vissza.
Ha a bemeneti String üres, vagy null, adjon vissza -1 értéket.
     */
    public int addDigits(String input){
        int count= 0;

        if(input== null || input.isEmpty()){
            return -1;
        }

        for(char ch: input.toCharArray()){
            if(Character.isDigit(ch)){
                count+= Integer.parseInt(String.valueOf(ch));
            }
        }
        return count;
    }
}
