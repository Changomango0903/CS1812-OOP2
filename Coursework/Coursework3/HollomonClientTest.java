public class HollomonClientTest{
    public static void main(String[] args) {
        HollomonClient hc0 = new HollomonClient("netsrv.cim.rhul.ac.uk", 1812);
        System.out.println(hc0.login("bottest", "1234"));
        

    }
}