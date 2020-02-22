/**
 * Hauptklasse
 */

//import java.net.InetAddress;
public class Hauptklasse {
    public static Gui gui;

    public static void main(String[] args) throws Exception {
        gui = new Gui();

        // long zeit;
        // InetAddress test_ip = InetAddress.getByName("213.144.129.118");
        // zeit = System.currentTimeMillis();
        // boolean isreachable = test_ip.isReachable(100);
        // long danach = System.currentTimeMillis() - zeit;
        // System.out.println("isreachable " + danach);

        // zeit = System.currentTimeMillis();
        // String host_name = test_ip.getHostName();
        // danach = System.currentTimeMillis() - zeit;
        // System.out.println("get host name " + danach);

        // System.out.println(String.format("IP: %s, Hostname: %s, ist erreichbar %b", test_ip.getHostAddress(), host_name, isreachable));

        
    }
}