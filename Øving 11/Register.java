import java.util.ArrayList;

class Register{
    /**
     * Til denne oppgaven er det brukt arrayList fordi den har innebygde funksjoner som vil gjøre det enklere å legge til, slette og sammenligne objekter.
     */
    ArrayList<Eiendom> eiendommer = new ArrayList<Eiendom>();

    /**
     * Registrerer eiendommen
     * @param eiendommen eiendommen som skal registreres
     * @return boolean
     */

    public boolean regEiendom(Eiendom eiendommen){
        for (Eiendom e : eiendommer) {
            if (e.equals(eiendommen)){
                return false;
            }
        }
        return eiendommer.add(eiendommen);
    }

    /**
     * Sletter en eiendom. Brukeren skriver inn nummeret til eiendommen den ønsker å slette, ut fra en liste som skrives ut.
     * Nummeret blir dermed endret til indeksen og sendt inn til metoden.
     * @param indeks indeksen til eiendommen som skal slettes
     * @return boolean
     */

    public boolean slettEiendom(int indeks){
        if (eiendommer.size()-1 >= indeks) {
            return eiendommer.remove(eiendommer.get(indeks));
        }
        else return false;
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
     * @param kommunenr et tall fra og med 101 (Halden) til og med 5054 (Indre Fosen)
     * @param gnr forkortelse for gårdsnummer. Et positivt heltall
     * @param bnr forkortelse for bruksnummer. Et positivt heltall
     * @return String
     */

    public ArrayList<Eiendom> finnEiendommerMedID(int kommunenr, int gnr, int bnr){
        String ID = kommunenr + "-" + gnr + "/" + bnr;
        ArrayList<Eiendom> eiendommene = new ArrayList<>();
        for (Eiendom e : eiendommer) {
            if (e.likID(ID)){
                eiendommene.add(e);
            }
        }
        return eiendommene;
    }

    /**
     * Beregner gjennomsnittsarealet til eiendommene. Navnet er gjennomsnittsAreal fordi det er det metoden skal beregne
     * @return double fordi areal har typen double og det gjør det enklere å bruke verdiene i videre beregninger.
     */

    public double gjennomsnittsAreal(){
        double a = 0;
        for (Eiendom e : eiendommer){
            a += e.getAreal();
        }
        a /= eiendommer.size();
        return a;
    }

    /**
     * Finner eiendommene med gårdsnummeret. Navnet er finnEiendommerMedGnr fordi det beskriver hva metoden gjør
     * @param gnr gårdsnummeret som skal sjekkes
     * @return ArrayList fordi det da vil være enklere å bruke informasjonen i videre beregninger
     */

    public ArrayList<Eiendom> finnEiendommerMedGnr(int gnr){
        ArrayList<Eiendom> eiendommene = new ArrayList<Eiendom>();
        for (Eiendom e : eiendommer){
            if (e.likGnr(gnr)) {
                eiendommene.add(e);
            }
        }
        return eiendommene;
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