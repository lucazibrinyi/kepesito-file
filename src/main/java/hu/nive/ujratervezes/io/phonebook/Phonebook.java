package hu.nive.ujratervezes.io.phonebook;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Phonebook {
    private static final String DATA_SEPARATOR = " ";
    final static String outputFilePath
            = "phonebookOutput/write.txt";

    public void exportPhonebook(Map<String, String> contacts, String output) {
        if (contacts == null || output == null) {
            throw new IllegalArgumentException();
        }

        File file = new File(outputFilePath);

        BufferedWriter bf = null;

        try {
            bf = new BufferedWriter(new FileWriter(file));
            for (Map.Entry<String, String> entry :
                    contacts.entrySet()) {
                bf.write(entry.getKey() + ":"
                        + entry.getValue());
                bf.newLine();
            }

            bf.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                bf.close();
            } catch (Exception e) {
            }
        }
    }
}
/*
Hozd létre a Phonebook osztályt, és abban az exportPhonebook(Map<String, String> contacts, String output) metódust.

A paraméterben kapott Mapben a kulcsok nevek, az értékek pedig telefonszámok. Írd ki az összes kulcs-érték párt az outputként megadott címre, minden kulcs-érték párt egy új sorba, az alábbi szintaxisban:

név: telefonszám

A kiírás sorrendje a fájlba nem fontos, de a Map összes elemét pontosan egyszer írd ki a fájlba!

Ha a metódus akármelyik paraméternek null-t kapna, akkor dobj IllegalArgumentException-t!
 */