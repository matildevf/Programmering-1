import java.util.Scanner;

class AntallSekunder{
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Timer");
        double timer = in.nextDouble();

        System.out.println("Minutter");
        double minutter = in.nextDouble();

        System.out.println("Sekunder");
        double sekunder = in.nextDouble();

        double totalt = (timer*3600)+(minutter*60)+sekunder;
        System.out.printf("Totalt antall sekunder er " + totalt + "\n");
    }
}