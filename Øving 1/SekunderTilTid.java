import java.util.Scanner;

class SekunderTilTid{
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Sekunder");
        int sekunder = in.nextInt();

        int timer = sekunder/3600;
        sekunder = sekunder%3600;
        int minutter = sekunder/60;
        sekunder = sekunder%60;
        System.out.println("Timer: " + timer + " \nMinutter: " + minutter + " \nSekunder: " + sekunder);
    }
}