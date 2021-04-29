package hu.nive.ujratervezes.kepesitovizsga.phonebook;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Phonebook {
    /*
    Egy alkalmazást írunk, ahol a megrendelő szeretné az alkalmazásban tárolt ügyfeleit és azok telefonszámát exportálni fájlba.
Hozd létre a Phonebook osztályt, és abban az exportPhonebook(Map<String, String> contacts, String output) metódust!
A paraméterben kapott mapben a kulcsok nevek, az értékek pedig telefonszámok.
Írd ki az összes kulcs-érték párt az outputként megadott címre, minden kulcs-érték párt egy új sorba, az alábbi szintaxisban:

név: telefonszám
A kiírás sorrendje a fájlba nem fontos, de a map összes elemét pontosan egyszer írd ki a fájlba!

Láthatod, hogy a tesztesetek a phonebookOutput könyvtárba dolgoznak. Ezt hozd létre, hogy az osztályod tudjon bele írni!

Nem szükséges figyelni arra, hogy ne tárold a teljes fájltartalmat memóriában.
Azaz használhatsz akár Files egy metódusát fájlba írásra, akár Writer példányt is.
Ha a metódus akármelyik paraméternek null értéket kapna, akkor dobj IllegalArgumentException-t!
     */
    private List<Person> personList= new ArrayList<>();

    public void exportPhonebook(Map<String, String> contacts, String output){
        if(contacts== null|| output== null){
            throw new IllegalArgumentException("Param is null");
        }
        for(Map.Entry<String, String> entry: contacts.entrySet()){
            Person act= new Person(entry.getKey(), entry.getValue());
            personList.add(act);
        }

        writeToFile(output);

    }

    private void writeToFile(String output) {
        try (BufferedWriter bwr = Files.newBufferedWriter(Path.of(output))) {

            for(int i=0; i<personList.size(); i++){
                Person act= personList.get(i);
                bwr.write(act.getName()+ ": "+ act.getNumber());
                bwr.newLine();
//                if(i!= personList.size()-1){
//                    bwr.write(", ");
//                }
            }
//            bwr.write("\n");

        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }

}
