import java.util.Scanner;

class TommerTilCm{
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Tommer");
        double tommer = in.nextDouble();
        double centimeter = tommer*2.54;
        System.out.printf(tommer + "tommer er ca. %1.2f centimeter.", centimeter);
    }
}