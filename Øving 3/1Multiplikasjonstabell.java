import java.util.Scanner;

class Multiplikasjonstabell{
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Start tall: ");
        int start = in.nextInt();
        System.out.print("Slutt tall: ");
        int slutt = in.nextInt();

        //Skriver ut gangetabellene
        for (int i = start; i <= slutt; i++){ //For hver gangetabell
            System.out.println("\n" + i + "-gangen:");
            for (int j = 1; j <= 10; j++){ //For tall fra 1 til 10
                System.out.println(i + " x " + j + " = " + i*j);
            }
        }
    }
}
