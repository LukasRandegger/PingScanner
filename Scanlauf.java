import java.util.ArrayList;

/**
 * Scanlauf
 */
public class Scanlauf {

    public static ArrayList < String > AddNibble(String baseAdress, int numberOfNibblesToAdd) {

        ArrayList < String > ipAdresses = new ArrayList < String > ();

        //Verstehen alle den Code?
        for (int i = 0; i < 256; i++) {
            String newAddress = baseAdress + "." + i;
            if (numberOfNibblesToAdd == 1) {
                ipAdresses.add(newAddress);
                continue;
            }

            if (numberOfNibblesToAdd > 1) {

                ipAdresses.addAll(AddNibble(newAddress, numberOfNibblesToAdd - 1));
            }

        }
        numberOfNibblesToAdd--;

        return ipAdresses;
    }
}