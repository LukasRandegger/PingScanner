import java.awt.event.ActionEvent;
import java.net.InetAddress;
import java.util.ArrayList;


/**
 * IpScanner
 */
public class IpScanner extends SimplifiedListener{

    public void actionPerformed(ActionEvent e) {
        // da drin passiert alles wo scannt

        // je nachdem, ob 8/16/24 ausgewählt ist, müssen 1, 2 oder 3 Nibbles von der Eingabe-Maske übernommen werden


        //TODO: check, ob die 4 nibbles ganze Zahlen sind, und ob sie zwischen 0 und 255 sind

        String adresse;
        ArrayList<String> ip_adresses = new ArrayList();

        // was geschieht hier
        switch (Hauptklasse.gui.subnetz_auswahl.getSelectedItem().toString()) {
            case "8":
                adresse = Hauptklasse.gui.nibble1.getText();
                ip_adresses = Scanlauf.AddNibble(adresse, 3);
                break;
            
            case "16":
                adresse = Hauptklasse.gui.nibble1.getText() + "." + Hauptklasse.gui.nibble2.getText();
                ip_adresses = Scanlauf.AddNibble(adresse, 2);

                break;

            case "24":
                adresse = Hauptklasse.gui.nibble1.getText() + "." + Hauptklasse.gui.nibble2.getText() + "." + Hauptklasse.gui.nibble3.getText();
                ip_adresses = Scanlauf.AddNibble(adresse, 1);

                break;
        
            default:
                break;
        }

        ArrayList<Host> hosts = new ArrayList();
        try {
            hosts = loopAllIps(ip_adresses);
        } catch (Exception ex) {
            //TODO: handle exception
        }

        Gui.zeigeHosts(hosts);
        
        
    }
    
    public static ArrayList<Host> loopAllIps(ArrayList<String> ips) throws Exception {
        ArrayList<Host> hosts = new ArrayList();

        // entferne Netzwerk-IP und Broadcast-Adresse        
        ips.remove(0);
        ips.remove(ips.size()-1);

        for (String ip: ips) {
            InetAddress aktuelle_ip = InetAddress.getByName(ip);
            if (true){ //aktuelle_ip.isReachable(10)){
                String host_name;
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