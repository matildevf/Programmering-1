import java.util.Scanner;

public class Tomteregister {
    public static void main(String[] args) {
        Register Registeret = new Register();
        //Test-data
        Registeret.regEiendom(new Eiendom(1445, "Gloppen", 77, 631, 1017.6, "Jens Olsen"));
        Registeret.regEiendom(new Eiendom(1445, "Gloppen",  77, 131, 661.3, "Nicolay Madsen", "Syningom"));
        Registeret.regEiendom(new Eiendom(1445, "Gloppen",  75, 19, 650.6, "Evilyn Jensen", "Fugletun"));
        Registeret.regEiendom(new Eiendom(1445, "Gloppen",  74, 188,  1457.2, "Karl Ove Bråten"));
        Registeret.regEiendom(new Eiendom(1445, "Gloppen",  69, 47, 1339.4, "Elsa Indregård", "Høiberg"));

        boolean fullfort; //Boolean som sier om handlingene ble utført eller ikke
        Scanner inn = new Scanner(System.in);
        int valg = 0;
        while (valg != 8){
            System.out.println("Velg handling: \n1. Registrer eiendom \n2. Slett eiendom \n3. Print antall eiendommer registrert " +
                    "\n4. Finn eiendomer med ID (kommunenr-gnr/bnr)" + "\n5. Print gjennomsnittsareal \n6. Finn eiendommer med gårdsnummer " +
                    "\n7. Print alle eiendommene \n8. Avslutt");
            valg = inn.nextInt();
            switch (valg){
                case 1: // Registrer eiendom
                    System.out.println("Skriv inn kommunenummer:");
                    int kommunenr = inn.nextInt();
                    System.out.println("Skriv inn kommunenavn:");
                    String kommunenavn = inn.next()+inn.nextLine();
                    System.out.println("Skriv inn gårdsnummer:");
                    int gnr = inn.nextInt();
                    System.out.println("Skriv inn bruksnummer:");
                    int bnr = inn.nextInt();
                    System.out.println("Skriv inn areal:");
                    double areal = inn.nextDouble();
                    System.out.println("Skriv inn eier:");
                    String eier = inn.next()+inn.nextLine();
                    System.out.println("Har eiendommen bruksnavn? \n1. Ja \n2. Nei");
                    if (inn.nextInt()==1){
                        System.out.println("Skriv inn bruksnavn:");
                        String bruksnavn = inn.next()+inn.nextLine();
                        fullfort = Registeret.regEiendom(new Eiendom(kommunenr, kommunenavn, gnr, bnr, areal, eier, bruksnavn));
                    }else {
                        fullfort = Registeret.regEiendom(new Eiendom(kommunenr, kommunenavn, gnr, bnr, areal, eier));
                    }
                    if (fullfort){
                        System.out.println("Eiendommen ble registrert");
                    }
                    else System.out.println("Eiendommen ble ikke registrert");
                    break;
                case 2: //Slett eiendom
                    System.out.println(Registeret.toString());
                    System.out.println("Skriv inn nummeret til eiendommen du vil slette: ");
                    fullfort = Registeret.slettEiendom(inn.nextInt()-1);
                    if (fullfort){
                        System.out.println("Eiendommen ble slettet");
                    }
                    else System.out.println("Eiendommen ble ikke slettet");
                    break;
                case 3: //Antall registrerte
                    System.out.println("Antall eiendommer registrert er " + Registeret.antEiendommer());
                    break;
                case 4: //Finn med ID
                    System.out.println("Skriv inn kommunenummer:");
                    int kommunenr1 = inn.nextInt();
                    System.out.println("Skriv inn gårdsnummer:");
                    int gnr1 = inn.nextInt();
                    System.out.println("Skriv inn bruksnummer:");
                    int bnr1 = inn.nextInt();
                    for (Eiendom e : Registeret.finnEiendommerMedID(kommunenr1, gnr1, bnr1)) {
                        System.out.println(e.toString() + "\n");
                    }
                    break;
                case 5: //Gjennomsnitts areal
                    System.out.println("Gjennomsnitts arealet er " + Registeret.gjennomsnittsAreal() + "m^2 \n");
                    break;
                case 6: //Finn med gårdsnummer
                    System.out.println("Skriv inn gårdsnummer: ");
                    for (Eiendom e : Registeret.finnEiendommerMedGnr(inn.nextInt())) {
                        System.out.println(e.toString() + "\n");
                    }
                    break;
                case 7: //Skriv ut eiendommene
                    System.out.println(Registeret.toString());
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Skriv inn en gyldig verdi.");
            }
        }
    }
}
