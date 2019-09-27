class Behandling{
    private String tekst;
    private String orgTekst;

    public Behandling(String tekst){
        this.orgTekst = tekst;
        this.tekst = tekst;
    }

    public String antallOrd(){
        String[] ord = tekst.split(" ");
        return "Antall ord: " + ord.length;
    }

    public String ordLengde(){
        String[] ord = tekst.split("[ .!:?,]+");
        int bokstaver = 0;
        for (int i=0; i<ord.length; i++){
            bokstaver += ord[i].length();
        }
        return "Gjennomsnittlig ordlengde: " + bokstaver/ord.length;
    }

    public String ordPerSet(){
        int antallOrd = 0;
        String[] setninger = tekst.split("[.!:?]+");
        for (int i=0; i<setninger.length; i++) {
            String[] ord = setninger[i].split(" ");
            antallOrd += ord.length;
        }
        return "Gjennomsnittlig mengde ord per periode: " + antallOrd/setninger.length;
    }

    public String skift(String fraOrd, String tilOrd){
        return fraOrd + " byttet ut med " + tilOrd + ": " + orgTekst.replace(fraOrd, tilOrd);
    }

    public String getOrgTekst(){
        return "Originaltekst: " + orgTekst;
    }

    public String getStorTekst(){
        return "Teksten i store bokstaver: " + orgTekst.toUpperCase();
    }
}

public class Tekstbehandling {
    public static void main(String[] args) {
        Behandling x = new Behandling("Hei på deg din nisse. Jeg heter Per og går på skole nå. Hvet ikke hvor, men samma det.");

        System.out.println(x.antallOrd());
        System.out.println(x.ordLengde());
        System.out.println(x.ordPerSet());
        System.out.println(x.skift("Hei", "Hallo"));
        System.out.println(x.getOrgTekst());
        System.out.println(x.getStorTekst());
    }

}
