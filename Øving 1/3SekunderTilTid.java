import java.util.Scanner;

class SekunderTilTid{
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Sekunder: ");
        int sek = in.nextInt();

        int t = sek/3600;
        sek %= 3600;
        int min = sek/60;
        sek %= 60;
        System.out.println(t + " timer, " + min + " minutter og " + sek + " sekunder");
    }
}
