import java.util.Scanner;

class TommerTilCm{
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Tommer: ");
        double tommer = in.nextDouble();
        double cm = tommer*2.54;
        System.out.printf(tommer + " tommer er ca. %1.2f cm.", cm);
    }
}
