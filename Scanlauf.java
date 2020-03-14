import java.util.ArrayList;

/**
 * Scanlauf
 */
public class Scanlauf {

    public static ArrayList<String> addNibble(String base_adress, int number_of_nibbles_to_add) {

        ArrayList<String> ip_adresses = new ArrayList<String> ();

        // rekursiv und iterativ alle IPs im Subnetz bestimmen
        for (int i = 0; i < 256; i++) {
            String new_address = base_adress + "." + i;
            if (number_of_nibbles_to_add == 1) {
                ip_adresses.add(new_address);
                continue;
            }
            if (number_of_nibbles_to_add > 1) {
                ip_adresses.addAll(addNibble(new_address, number_of_nibbles_to_add - 1));
            }
        }
        number_of_nibbles_to_add--;

        return ip_adresses;
    }
}