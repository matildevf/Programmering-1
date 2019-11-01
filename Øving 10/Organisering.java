import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

class Arrangement{
    private int nummer;
    private String navn;
    private String sted;
    private String arrangor;
    private String type;
    private long tidsponkt;

    public Arrangement(int nummer, String navn, String sted, String arrangor, String type, long tidsponkt) {
        this.nummer = nummer;
        this.navn = navn;
        this.sted = sted;
        this.arrangor = arrangor;
        this.type = type;
        this.tidsponkt = tidsponkt;
    }

    public int getNummer() {
        return nummer;
    }

    public String getNavn() {
        return navn;
    }

    public String getSted() {
        return sted;
    }

    public String getArrangor() {
        return arrangor;
    }

    public String getType() {
        return type;
    }

    public long getTidsponkt() {
        return tidsponkt;
    }

    public long getKlokkeslett() {
        return Long.parseLong(Long.toString(tidsponkt).substring(8, 10)) + Long.parseLong(Long.toString(tidsponkt).substring(10, 12));
    }
}

class ArrangementRegister{
    private ArrayList<Arrangement> arrangementer = new ArrayList<Arrangement>();

    public int lengde(){
        return arrangementer.size();
    }

    public boolean regArang(Arrangement a){
        arrangementer.add(a);
        return true;
    }

    public String sted(String stedet){
        String liste = "";
        for (int i=0; i<arrangementer.size(); i++){
            if(Objects.equals(arrangementer.get(i).getSted().trim().toLowerCase(), stedet.trim().toLowerCase())){
                liste += arrangementer.get(i).getNavn() + "\n";
            }
        }
        return liste;
    }

    public String dato(long datoen){
        String liste = "";
        for (int i=0; i<arrangementer.size(); i++){
            if(Objects.equals(Long.parseLong(Long.toString(arrangementer.get(i).getTidsponkt()).substring(0, 8)), datoen)){
                liste += arrangementer.get(i).getNavn() + "\n";
            }
        }
        return liste;
    }

    public String tidsintervall(long dato1, long dato2){
        String liste = "";
        for (int i=0; i<arrangementer.size(); i++){
            long tid = Long.parseLong(Long.toString(arrangementer.get(i).getTidsponkt()).substring(0, 8));
            if(tid >= dato1 && tid <= dato2){
                liste += arrangementer.get(i).getNavn() + "\n";
            }
        }
        return liste;
    }

    public void sorterNummer(){
        arrangementer.sort(Comparator.comparing(Arrangement::getNummer));
    }

    public void sorterSted(){
        arrangementer.sort(Comparator.comparing(Arrangement::getSted));
    }

    public void sorterType(){
        arrangementer.sort(Comparator.comparing(Arrangement::getType));
    }

    public void sorterTidspunkt(){
        arrangementer.sort(Comparator.comparing(Arrangement::getTidsponkt));
    }

    public void sorterKlokkeslett(){
        arrangementer.sort(Comparator.comparing(Arrangement::getKlokkeslett));
    }

    public String toString(){
        String liste = "";
        for (int i = 0; i < arrangementer.size(); i++){
            liste += "Nummer: " + arrangementer.get(i).getNummer() +
                    "\nNavn: " + arrangementer.get(i).getNavn() +
                    "\nSted: " + arrangementer.get(i).getSted() +
                    "\nArrangør: " + arrangementer.get(i).getArrangor() +
                    "\nType: " + arrangementer.get(i).getType() +
                    "\nTidspunkt: kl. " + Long.toString(arrangementer.get(i).getTidsponkt()).substring(8, 10) + ":" +
                    Long.toString(arrangementer.get(i).getTidsponkt()).substring(10, 12) + " " +
                    Long.toString(arrangementer.get(i).getTidsponkt()).substring(6, 8) + "." +
                    Long.toString(arrangementer.get(i).getTidsponkt()).substring(4, 6) + "." +
                    Long.toString(arrangementer.get(i).getTidsponkt()).substring(0, 4) + "\n\n";
        }
        return liste;
    }
}

public class Organisering {
    public static void main(String[] args) {
        ArrangementRegister x = new ArrangementRegister();
        Scanner inn = new Scanner(System.in);
        int valg = 0;
        while (valg != 6) {
            x.sorterNummer();
            System.out.println("\nVelg handling: \n1. Registrer et nytt arrangement \n2. Finn arrangement på et sted " +
                    "\n3. Finn arrangement på en dato \n4. Finn arrangement i et tidsintervall \n5. Skriv ut sortert liste \n6. Avslutt");
            valg = inn.nextInt();
            switch (valg){
                case 1:
                    System.out.println("Skriv inn navn, sted, arrangør, type og tidspunkt (ÅÅÅÅMMDDTTTT): ");
                    x.regArang(new Arrangement((x.lengde() + 1), inn.nextLine()+inn.nextLine(), inn.nextLine(),
                            inn.nextLine(), inn.nextLine(), inn.nextLong()));
                    break;
                case 2:
                    System.out.println("Skriv inn et sted: \n");
                    String sted = inn.next();
                    System.out.println(x.sted(sted));
                    break;
                case 3:
                    System.out.println("Skriv inn en dato: \n");
                    Long dato = inn.nextLong();
                    System.out.println(x.dato(dato));
                    break;
                case 4:
                    x.sorterKlokkeslett();
                    System.out.println("Skriv inn start dato: \n");
                    Long dato1 = inn.nextLong();
                    System.out.println("Skriv inn slutt dato: \n");
                    Long dato2 = inn.nextLong();
                    System.out.println(x.tidsintervall(dato1, dato2));
                    System.out.println(x.toString());
                    break;
                case 5:
                    System.out.println("Sorter etter: \n1. Sted \n2. Type \n3. Tidspunkt \n4. Avbryt");
                    int valgSortering = inn.nextInt();
                    switch (valgSortering) {
                        case 1:
                            x.sorterSted();
                            System.out.println(x.toString());
                            break;
                        case 2:
                            x.sorterType();
                            System.out.println(x.toString());
                            break;
                        case 3:
                            x.sorterTidspunkt();
                            System.out.println(x.toString());
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Skriv inn en gyldig verdi!");
                    }
                case 6:
                    break;
                default:
                    System.out.println("Skriv inn en gyldig verdi!");
            }
        }
    }
}
