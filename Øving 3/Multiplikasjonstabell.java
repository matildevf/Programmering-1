import java.util.Scanner;

class Multiplikasjonstabell{
    public static void main (String[] args) {
        //Henter inn start tall
        Scanner in = new Scanner(System.in);
        System.out.println("Start tall: ");
        int tall1 = in.nextInt();
        //Henter inn antall gangetabeller som skal vises
        System.out.println("Slutt tall: ");
        int tall2 = in.nextInt();

        //Skriver ut gangetabellene
        for (int i = tall1; i <= tall2; i++){ //For hver gangetabell
            System.out.println(i + "-gangen:");
            for (int j = 1; j <= 10; j++){ //For tall fra 1 til 10
                int produkt = i*j;
                System.out.println(i + " x " + j + " = " + produkt);
            }
        }
    }
}