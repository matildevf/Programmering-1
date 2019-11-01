import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * Klassen Eiendom
 * @author Matilde Volle Fiborg
 */

class Eiendom{
    private int kommunenr;
    private String kommunenavn;
    private int gnr;
    private int bnr;
    private String bruksnavn;
    private double areal;
    private String eier;

    /**
     * Konstruktør som oppretter et objekt av klassen/typen Eiendom
     * @param kommunenr Beskriv parametrene, begrensninger?
     * @param kommunenavn
     * @param gnr
     * @param bnr
     * @param bruksnavn
     * @param areal
     * @param eier
     */

    public Eiendom(int kommunenr, String kommunenavn, int gnr, int bnr, String bruksnavn, double areal, String eier) { //Flytt den unike bakerst
        this.kommunenr = kommunenr;
        this.kommunenavn = kommunenavn;
        this.gnr = gnr;
        this.bnr = bnr;
        this.bruksnavn = bruksnavn;
        this.areal = areal;
        this.eier = eier;
    }

    /**
     * Konstruktør som oppretter et objekt av klassen/typen Eiendom uten bruksnavn
     * @param kommunenr
     * @param kommunenavn
     * @param gnr
     * @param bnr
     * @param areal
     * @param eier
     */

    public Eiendom(int kommunenr, String kommunenavn, int gnr, int bnr, double areal, String eier) {
        this.kommunenr = kommunenr;
        this.kommunenavn = kommunenavn;
        this.gnr = gnr;
        this.bnr = bnr;
        this.areal = areal;
        this.eier = eier;
    }

    // Lag get metoder for alle objektvariablene

    public int getGnr() {
        return gnr;
    }

    public double getAreal() {
        return areal;
    }

    // Javadoc
    public String ID(){ //getID
        return kommunenr + "-" + gnr + "/" + bnr;
    }

    /**
     * Skriver ut informasjonen om eiendommen
     * @return String
     */

    public String toString() {
        String liste = "Kommunenummer: " + kommunenr + "\nKommunenavn: " + kommunenavn + "\nGårdsnummer: " + gnr + "\nBruksnummer: " + bnr;
        if(bruksnavn!=null){
            liste += "\nBruksnavn: " + bruksnavn;
        }
        return liste + "\nAreal: " + areal + "\nEier: " + eier;
    }
}

class Register{
    // Javadoc med begrunnelse for valg av arrayList
    ArrayList<Eiendom> eiendommer = new ArrayList<Eiendom>();

    /**
     * Registrerer eiendommen
     * @param e eiendommen som skal registreres
     * @return boolean
     */

    public boolean regEiendom(Eiendom e){
        // Lag equals metode i eiendom
        if (eiendommer.contains(e)){
            return false;
        }
        else {
            return eiendommer.add(e);
        }
    }

    /**
     * Sletter en eiendom
     * @param enr indeksen til eiendommen som skal slettes
     * @return boolean
     */
    // Forklar hvordan riktig eiendom blir slettet
    public boolean slettEiendom(int enr){
        return eiendommer.remove(eiendommer.get(enr));
    }

    /**
     * Returnerer antall eiendommer
     * @return int
     */

    public int antEiendommer(){
        return eiendommer.size();
    }

    /**
     * Sjekker om det finnes eiendommer med ID-en
     * @param ID ID-en som skall sjekkes
     * @return String
     */
    // Ikke be bruker ski\rive inn ID
    public String finnEiendommerMedID(String ID){
        String liste = "";
        for (Eiendom e : eiendommer) {
            if (Objects.equals(e.ID(),ID)){
                liste += e.toString();
            }
        }
        return liste;
    }

    /**
     * Beregner gjennomsnittsarealet til eiendommene
     * @return int
     */
    // Forklar valg av returtype og navn
    public double gjennomsnittsareal(){
        double a = 0;
        for (Eiendom e : eiendommer){
            a += e.getAreal();
        }
        a /= eiendommer.size();
        return a;
    }

    /**
     * Finner eiendommene med gårdsnummeret
     * @param gnr gårdsnummeret som skal sjekkes
     * @return String
     */
    // Skriv ut informasjon utenfor metoden. Returner heller liste med objekter
    //Beskrivelse for valg av returtype og navn
    public String finnEiendommerMedGnr(int gnr){
        String liste = "";
        for (Eiendom e : eiendommer){
            if (Objects.equals(e.getGnr(),gnr)) {
                liste += e.toString();
            }
        }
        return liste;
    }

    /**
     * Nummerert liste med alle eiendommene
     * @return String
     */

    public String toString() {
        String liste = "";
        for (int i = 0; i<eiendommer.size(); i++){
            liste += (i+1) + "\n" + eiendommer.get(i).toString() + "\n";
        }
        return liste;
    }
}

public class Tomteregister {
    public static void main(String[] args) {
        Register Reg = new Register();
        // Lag heller objektene i metoden
        Reg.regEiendom(new Eiendom(1445, "Gloppen", 77, 631, 1017.6, "Jens Olsen"));
        Reg.regEiendom(new Eiendom(1445, "Gloppen",  77, 131, "Syningom", 661.3, "Nicolay Madsen"));
        Reg.regEiendom(new Eiendom(1445, "Gloppen",  75, 19, "Fugletun", 650.6, "Evilyn Jensen"));
        Reg.regEiendom(new Eiendom(1445, "Gloppen",  74, 188,  1457.2, "Karl Ove Bråten"));
        Reg.regEiendom(new Eiendom(1445, "Gloppen",  69, 47, "Høiberg", 1339.4, "Elsa Indregård"));


        Scanner inn = new Scanner(System.in);
        int valg = 0;
        while (valg != 8){
            System.out.println("Velg handling: \n1. Registrer eiendom \n2. Slett eiendom \n3. Print antall eiendommer registrert \n4. Finn eiendomer med ID (kommunenr-gnr/bnr)" +
                    "\n5. Print gjennomsnittsareal \n6. Finn eiendommer med gårdsnummer \n7. Print alle eiendommene \n8. Avslutt");
            valg = inn.nextInt();
            switch (valg){
                case 1:
                    System.out.println("Har eiendommen bruksnavn? \n1. Ja \n2. Nei");
                    if (inn.nextInt()==1){
                        System.out.println("Skriv inn kommunenummer, kommunenavn, gårdsnummer, bruksnummer, bruksnavn, areal og eier:");
                        System.out.println(Reg.regEiendom(new Eiendom(inn.nextInt(), inn.next()+inn.nextLine(), inn.nextInt(), inn.nextInt(),
                                inn.next()+inn.nextLine(), inn.nextDouble(), inn.next()+inn.nextLine())));
                    }else {
                        System.out.println("Skriv inn kommunenummer, kommunenavn, gårdsnummer, bruksnummer, areal og eier:");
                        System.out.println(Reg.regEiendom(new Eiendom(inn.nextInt(), inn.next() + inn.nextLine(), inn.nextInt(), inn.nextInt(), inn.nextDouble(), inn.next() + inn.nextLine())));
                    }
                    break;
                case 2:
                    System.out.println(Reg.toString());
                    System.out.println("Skriv inn nummeret til eiendommen du vil slette: ");
                    System.out.println(Reg.slettEiendom(inn.nextInt()-1));
                    break;
                case 3:
                    System.out.println(Reg.antEiendommer());
                    break;
                case 4:
                    System.out.println("Skriv inn ID-en (kommunenr-gnr/bnr):");
                    System.out.println(Reg.finnEiendommerMedID(inn.next()));
                    break;
                case 5:
                    System.out.println(Reg.gjennomsnittsareal());
                    break;
                case 6:
                    System.out.println("Skriv inn gårdsnummer: ");
                    System.out.println(Reg.finnEiendommerMedGnr(inn.nextInt()));
                    break;
                case 7:
                    System.out.println(Reg.toString());
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Skriv inn en gyldig verdi.");
            }
        }
    }
}
