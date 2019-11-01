import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

class Rett{
    private String navn;
    private String type;
    private double pris;
    private String oppskrift;

    public Rett(String navn, String type, double pris, String oppskrift) {
        this.navn = navn;
        this.type = type;
        this.pris = pris;
        this.oppskrift = oppskrift;
    }

    public String getNavn() {
        return navn;
    }

    public String getType() {
        return type;
    }

    public double getPris() {
        return pris;
    }

    public String getOppskrift() {
        return oppskrift;
    }

    public String toString() {
        return "Navn: " + getNavn() + "\nType: " + getType() + "\nPris: " + getPris() + "\nOppskrift: " + getOppskrift() + "\n";
    }
}

class Meny{
    private ArrayList<Rett> retter = new ArrayList<Rett>();
    private String navn;

    public Meny(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public void leggTilRett(Rett x){
        retter.add(x);
    }

    public double pris(){
        double pris = 0;
        for (int i = 0; i<retter.size(); i++){
            pris += retter.get(i).getPris();
        }
        return pris;
    }

    public String toString() {
        String rettene = "";
        for (Rett r : retter){
            rettene += r.toString();
        }
        return "Navn: " + getNavn() + "\nRetter: \n" + rettene + "Totalpris: " + pris() + "\n";
    }
}

class MenyRegister{
    private ArrayList<Rett> retter = new ArrayList<Rett>();
    private ArrayList<Meny> menyer = new ArrayList<Meny>();

    public String regRett(Rett nyRett){
        retter.add(nyRett);
        return nyRett.getNavn() + " ble registrert \n";
    }

    public String navn(String navn){
        String liste = "";
        for (int i=0; i<retter.size(); i++){
            if(Objects.equals(retter.get(i).getNavn().trim().toLowerCase(), navn.trim().toLowerCase())){
                liste += retter.get(i).toString() + "\n";
            }
        }
        return liste;
    }

    public String type(String type){
        String liste = "";
        for (int i=0; i<retter.size(); i++){
            if(Objects.equals(retter.get(i).getType().trim().toLowerCase(), type.trim().toLowerCase())){
                liste += retter.get(i).toString() + "\n";
            }
        }
        return liste;
    }

    public String regMeny(String navn, int[] rettNr){
        menyer.add(new Meny(navn));
        for (int i = 0; i<rettNr.length; i++) {
            menyer.get(menyer.size() - 1).leggTilRett(retter.get(rettNr[i]-1));
        }
        return navn + " ble registrert";
    }

    public String prisIntervall(double pris1, double pris2){
        String liste = "";
        for (int i=0; i<menyer.size(); i++){
            if(menyer.get(i).pris() >= pris1 && menyer.get(i).pris() <= pris2){
                liste += menyer.get(i).toString() + "\n";
            }
        }
        return liste;
    }

    public String toString() {
        String liste = "";
        for (int i = 0; i<retter.size(); i++){
            liste += (i+1) + ". " + retter.get(i).getNavn() + "\n";
        }
        return liste;
    }
}

public class Resturant {
    public static void main(String[] args) {
        MenyRegister x = new MenyRegister();
        Scanner inn = new Scanner(System.in);
        int valg = 0;
        while (valg != 6) {
            System.out.println("\nVelg handling: \n1. Registrer ny rett \n2. Finn rett gitt navn " +
                    "\n3. Finn retter av en gitt type \n4. Registrer ny meny \n5. Menyer i et prisintervall \n6. Avslutt");
            valg = inn.nextInt();
            switch (valg){
                case 1:
                    System.out.println("Skriv inn navn, type, pris, oppskrift: ");
                    System.out.println(x.regRett(new Rett(inn.next(), inn.next(), inn.nextInt(), inn.next()+inn.nextLine())));
                    break;
                case 2:
                    System.out.println("Skriv inn navn på rett: \n");
                    String navn = inn.next();
                    System.out.println(x.navn(navn));
                    break;
                case 3:
                    System.out.println("Skriv inn type: \n");
                    String type = inn.next();
                    System.out.println(x.type(type));
                    break;
                case 4:
                    System.out.println("Skriv inn navn til menyen: ");
                    String menyNavn = inn.next();
                    System.out.println(x.toString());
                    System.out.println("Antall retter: ");
                    int antRetter = inn.nextInt();
                    System.out.println("Skriv inn nummeret til rettene: ");
                    int[] retterInn = new int[antRetter];
                    for (int i = 0; i<antRetter; i++){
                        retterInn[i] = inn.nextInt();
                    }
                    System.out.println(x.regMeny(menyNavn, retterInn));
                    break;
                case 5:
                    System.out.println("Skriv inn start pris: \n");
                    int pris1 = inn.nextInt();
                    System.out.println("Skriv inn slutt pris: \n");
                    int pris2 = inn.nextInt();
                    System.out.println(x.prisIntervall(pris1, pris2));
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Skriv inn en gyldig verdi!");
            }
        }
    }
}