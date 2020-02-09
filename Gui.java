import java.awt.*;
import javax.swing.*;

/**
 * Gui
 * Diese Klasse erzeugt die Benutzeroberfläche für den PingScanner.
 */
public class Gui extends JFrame {

    JFrame hauptfenster;
    JLabel label_instruktionen;
    JLabel label_ip;
    JTextField nibble1;
    JLabel dot1;
    JTextField nibble2;
    JLabel dot2;
    JTextField nibble3;
    JLabel dot3;
    JTextField nibble4;
    JLabel subnetz;
    JComboBox subnetz_auswahl;
    JCheckBox hostnamen;
    JLabel leeres_label = new JLabel("                    ");
    JButton suchlauf;

    

    public Gui(){
        super("Ping-Scanner");
        this.setLocation(100, 100);
        this.setSize(450, 300);
        this.setVisible(true);
        this.getContentPane().setLayout(new GridLayout(0, 1));

        // bei einem Klick auf das X (Fenster schliessen) wird die ganze Applikation beendet.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // START Instruktionen Panel
        this.label_instruktionen = new JLabel("<html>1. Geben Sie die IP ein<br/>2. Wählen Sie den Suchbereich (Subnetzmaske) aus.<br/>3. Mit der Option \"Hostnamen anzeigen\" werden die Hostnamen angezeigt.<br/>4. Mit einem Klick auf den Button starten Sie den Suchlauf.</html>");
        
        JPanel panel_instruktionen = new JPanel();
        panel_instruktionen.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(panel_instruktionen);
        panel_instruktionen.add(this.label_instruktionen);
        // ENDE Instruktionen Panel
        
        // START IP Panel
        JPanel panel_ip = new JPanel();
        panel_ip.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(panel_ip);

        this.label_ip = new JLabel("IP:");
        panel_ip.add(label_ip);

        this.nibble1 = new JTextField();
        panel_ip.add(nibble1);
        this.nibble1.setColumns(3);

        this.dot1 = new JLabel(".");
        panel_ip.add(dot1);

        this.nibble2 = new JTextField();
        panel_ip.add(nibble2);
        this.nibble2.setColumns(3);

        this.dot2 = new JLabel(".");
        panel_ip.add(dot2);

        this.nibble3 = new JTextField();
        panel_ip.add(nibble3);
        this.nibble3.setColumns(3);

        this.dot3 = new JLabel(".");
        panel_ip.add(dot3);

        this.nibble4 = new JTextField();
        panel_ip.add(nibble4);
        this.nibble4.setColumns(3);

        this.subnetz = new JLabel("Subnetzmaske:");
        panel_ip.add(this.subnetz);

        // Der JComboBox-Konstruktor akzeptiert nur einen String-Array als Argument
        // Die Zahl muss daher für die Weiterverwendung zu einem Integer umgewandelt werden
        String[] subnetze = {"8", "16", "24"};
        this.subnetz_auswahl = new JComboBox(subnetze);
        panel_ip.add(this.subnetz_auswahl);
        // ENDE IP Panel


        // START Host und Button Panel
        JPanel panel_host_button = new JPanel();
        panel_host_button.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(panel_host_button);

        this.hostnamen = new JCheckBox("Hostnamen anzeigen?");
        panel_host_button.add(this.hostnamen);

        panel_host_button.add(this.leeres_label);

        this.suchlauf = new JButton("Suchlauf starten");
        panel_host_button.add(this.suchlauf);
        // ENDE Host und Button Panel
        }
}
