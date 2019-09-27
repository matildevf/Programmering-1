import static javax.swing.JOptionPane.*;

class Analyse {
    private String tekst;
    private String original;
    private int[] antallTegn = new int[30];

    public Analyse(String tekst){
        this.original = tekst;
        this.tekst = tekst.toLowerCase();
    }

    public String getTekst(){
        return original;
    }

    public void setTekst(String tekst){
        original = tekst;
        this.tekst = tekst.toLowerCase();
    }

    public void leggTil(){
        for(int i=0; i < tekst.length(); i++){
            char verdi = tekst.charAt(i);
            int plass;
            if(verdi>=97 && verdi<=122){
                plass = verdi-97;
            }
            else if(verdi == 230){ //æ
                plass = 26;
            }
            else if (verdi == 248) { // ø
                plass = 27;
            }
            else if (verdi == 229) { // å
                plass = 28;
            }
            else {
                plass = 29;
            }
            antallTegn[plass] += 1;
        }
    }

    public int antallUlikeBokstaver(){
        int antall = 0;
        for (int i=0; i<antallTegn.length-1; i++){
            if (antallTegn[i]>0){
                antall++;
            }
        }
        return antall;
    }

    public int antallBokstaver(){
        int antall = 0;
        for (int i=0; i<antallTegn.length-1; i++){
            antall += antallTegn[i];
        }
        return antall;
    }

    public double prosentTegn(){
        double totTegn = antallBokstaver() + antallTegn[29];
        return antallTegn[29]/(totTegn/100);
    }

    public int bokstav(String b){
        char verdi = b.charAt(0);
        int plass;
        if(verdi>=97 && verdi<=122){
            plass = verdi-97;
        }
        else if(verdi == 230){ //æ
            plass = 26;
        }
        else if (verdi == 248) { // ø
            plass = 27;
        }
        else if (verdi == 229) { // å
            plass = 28;
        }
        else {
            plass = 29;
        }
        return antallTegn[plass];
    }

    public String tilChar(int x) {
        String c = "";
        if (x >= 0 && x <= 25) {
            c += (char) (x + 97);
        }
        else if (x == 26) {
            c += "æ";
        }
        else if (x == 27) {
            c += "ø";
        }
        else if (x == 28) {
            c += "å";
        }
        else {
            c += "symbol(er)";
        }
        return c;
    }
    public String flest(){
        String bokstav = "";
        int antall = 0;
        for (int i=0; i<antallTegn.length-1; i++){
            if (antallTegn[i]>antall){
                antall = antallTegn[i];
                bokstav = tilChar(i);
            }
            else if(antallTegn[i]==antall){
                bokstav += tilChar(i);
            }
        }
        return "Bokstaven(e) som forekommer oftest er: " + bokstav + " med " + antall + " ganger.";
    }
}

public class Tekstanalyse{
    public static void main(String[] args){
        while (true) {
            Analyse Teksten = new Analyse("");
            Teksten.setTekst(showInputDialog("Skriv inn en tekst: \n"));
            Teksten.leggTil();
            System.out.println(Teksten.getTekst());
            System.out.println("Det er " + Teksten.antallUlikeBokstaver() + " ulike bokstaver i teksten.");
            System.out.println("Det er totalt " + Teksten.antallBokstaver() + " bokstaver i teksten.");
            System.out.printf("%1.1f prosent av teksten er ikke bokstaver.\n",Teksten.prosentTegn());
            String bokstav = showInputDialog("Skriv inn en bokstav: \n");
            System.out.println("Bokstaven " + bokstav + " forekommer " + Teksten.bokstav(bokstav) + " gang(er).");
            System.out.println(Teksten.flest());

            int svar = showConfirmDialog(null, "Vil du skrive inn ny tekst?", "Avslutt", YES_NO_OPTION);
            if (svar == NO_OPTION){
                break;
            }

        }
    }
}
