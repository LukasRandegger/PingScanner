import java.awt.event.ActionEvent;
import java.net.InetAddress;
import java.util.ArrayList;

/**
 * IpScanner
 */
public class IpScanner extends SimplifiedListener{

    public void actionPerformed(ActionEvent e) {
        // hier befindet sich der gesamte Scan-Prozess
        // je nachdem, ob 8/16/24 ausgewählt ist, müssen 1, 2 oder 3 Nibbles von der Eingabe-Maske übernommen werden

        String adresse;
        ArrayList<String> ip_adresses = new ArrayList<String>();

        // alle IPs im entsprechenden Subnetz in die ArrayList ip_adresses schreiben
        switch (Hauptklasse.gui.subnetz_auswahl.getSelectedItem().toString()) {
            case "8":
                adresse = Hauptklasse.gui.nibble1.getText();
                ip_adresses = Scanlauf.addNibble(adresse, 3);
                break;
            
            case "16":
                adresse = Hauptklasse.gui.nibble1.getText() + "." + Hauptklasse.gui.nibble2.getText();
                ip_adresses = Scanlauf.addNibble(adresse, 2);
                break;

            case "24":
                adresse = Hauptklasse.gui.nibble1.getText() + "." + Hauptklasse.gui.nibble2.getText() + "." + Hauptklasse.gui.nibble3.getText();
                ip_adresses = Scanlauf.addNibble(adresse, 1);
                break;
        
            default:
                break;
        }

        ArrayList<Host> hosts = new ArrayList<Host>();
        try {
            hosts = loopAllIps(ip_adresses);
        } catch (Exception ex) {
            
        }

        Gui.zeigeHosts(hosts);
        
    }
    
    public static ArrayList<Host> loopAllIps(ArrayList<String> ips) throws Exception {
        ArrayList<Host> hosts = new ArrayList<Host>();

        // entferne Netzwerk-IP und Broadcast-Adresse        
        ips.remove(0);
        ips.remove(ips.size()-1);

        // füge alle erreichbaren IPs zu den Hosts hinzu
        for (String ip: ips) {
            InetAddress aktuelle_ip = InetAddress.getByName(ip);
            if (aktuelle_ip.isReachable(50)){
                String host_name;
                // Hostnamen anzeigen, falls die Checkbox ausgewählt ist
                if (Hauptklasse.gui.hostnamen.isSelected()) {
                    host_name = aktuelle_ip.getHostName();
                } else {
                    host_name = "";
                }
                hosts.add(new Host(ip, host_name));
            }
        }

        return hosts;
    }
}