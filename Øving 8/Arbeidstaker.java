import java.time.Year;
import java.util.Scanner;

class Person{
    private String fornavn;
    private String etternavn;
    private int fodselsar;

    public Person(String fornavn, String etternavn, int fodselsar){
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.fodselsar = fodselsar;
    }

    public String getFornavn() {
        return fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public int getFodselsar() {
        return fodselsar;
    }
}

class ArbTaker{
    Person personalia;
    int arbtakernr;
    int ansettelsesar;
    int manedslonn;
    double skatteprosent;

    public ArbTaker(Person personalia, int arbtakernr, int ansettelsesar, int manedslonn, double skatteprosent) {
        this.personalia = personalia;
        this.arbtakernr = arbtakernr;
        this.ansettelsesar = ansettelsesar;
        this.manedslonn = manedslonn;
        this.skatteprosent = skatteprosent;
    }

    public Person getPersonalia() {
        return personalia;
    }

    public int getArbtakernr() {
        return arbtakernr;
    }

    public int getAnsettelsesar() {
        return ansettelsesar;
    }

    public int getManedslonn() {
        return manedslonn;
    }

    public double getSkatteprosent() {
        return skatteprosent;
    }

    public void setManedslonn(int manedslonn) {
        this.manedslonn = manedslonn;
    }

    public void setSkatteprosent(double skatteprosent) {
        this.skatteprosent = skatteprosent;
    }

    public double skattManed(){
        return skatteprosent*manedslonn/100;
    }

    public double bruttolonn(){
        return manedslonn*12;
    }

    public double skattAr(){
        return (skattManed()*10 + (skatteprosent/2)*manedslonn/100 + manedslonn);
    }

    public String navn(){
        return personalia.getEtternavn() + ", " + personalia.getFornavn();
    }

    public int alder(){
        return (Year.now().getValue()-personalia.getFodselsar());
    }

    public int arAnsatt(){
        return (Year.now().getValue()-ansettelsesar);
    }

    public boolean ansattMerEnn(int ar){
        return (Year.now().getValue()-ansettelsesar)>ar;
    }

    public String toString() {
        return "Navn: " + navn() + "\nAlder: " + alder() + "\nAntall år ansatt i bedriften: " + arAnsatt() +
                "\nSkatt per måned: " + skattManed() + " kr \nBruttolønn per år: " + bruttolonn() +
                " kr \nSkattetrekk per år: " + skattAr() + " kr";
    }
}

public class Arbeidstaker {
    public static void main(String[] args){
        Person PerP = new Person("Per", "Larsen", 2000);
        ArbTaker PerA = new ArbTaker(PerP, 1234, 2012, 20000, 10);
        System.out.println(PerA.toString());
        while (true){
            Scanner endreInn = new Scanner(System.in);
            System.out.println("\nEndre: \n1. Månedslønn \n2. Skatteprosent \n3. Sjekk antall år \n4. Vis \n5. Avslutt");
            int endre = endreInn.nextInt();
            if (endre == 1){
                Scanner mlInn = new Scanner(System.in);
                System.out.println("Ny månedslønn: ");
                int ml = mlInn.nextInt();
                PerA.setManedslonn(ml);
                System.out.println("Månedslønn: " + PerA.getManedslonn());
            }
            else if (endre == 2){
                Scanner spInn = new Scanner(System.in);
                System.out.println("Ny skatteprosent: ");
                int sp = spInn.nextInt();
                PerA.setSkatteprosent(sp);
                System.out.println("Skatteprosent: " + PerA.getSkatteprosent());
            }
            else if (endre == 3){
                Scanner arInn = new Scanner(System.in);
                System.out.println("Antall år: ");
                int ar = arInn.nextInt();
                if (PerA.ansattMerEnn(ar)){
                    System.out.println("Ja, " + PerP.getFornavn() + " har jobbet for bedriften i over " + ar + " år.");
                }
                else{
                    System.out.println("Nei, " + PerP.getFornavn() + " har ikke jobbet for bedriften i over " + ar +
                            " år.");
                }
            }
            else if (endre == 4){
                System.out.println(PerA.toString());
            }
            else if(endre == 5){
                break;
            }
            else{
                System.out.println("Skriv inn en gyldig verdi!");
            }
        }
    }
}
