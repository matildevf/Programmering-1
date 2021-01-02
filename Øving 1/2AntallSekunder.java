import java.util.Scanner;

class AntallSekunder{
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Timer: ");
        int t = in.nextInt();
        System.out.print("Minutter: ");
        int min = in.nextInt();
        System.out.print("Sekunder: ");
        int sek = in.nextInt();

        int total = (t*3600) + (min*60) + sek;
        System.out.println("Totalt antall sekunder er " + total);
    }
}
