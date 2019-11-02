/**
 * Klassen Eiendom
 * @author Matilde Volle Fiborg
 */

class Eiendom{
    private int kommunenr;
    private String kommunenavn;
    private int gnr;
    private int bnr;
    private double areal;
    private String eier;
    private String bruksnavn;

    /**
     * Konstruktør som oppretter et objekt av typen Eiendom
     * @param kommunenr et tall fra og med 101 (Halden) til og med 5054 (Indre Fosen)
     * @param kommunenavn navnet til kommunen eiendommen ligger i
     * @param gnr forkortelse for gårdsnummer. Et positivt heltall
     * @param bnr forkortelse for bruksnummer. Et positivt heltall
     * @param areal areal i m^2. Et positivt desimaltall
     * @param eier navn på eier
     * @param bruksnavn et navn på tomta. Ikke alle eiendommer har navn
     */

    public Eiendom(int kommunenr, String kommunenavn, int gnr, int bnr, double areal, String eier, String bruksnavn) {
        this.kommunenr = kommunenr;
        this.kommunenavn = kommunenavn;
        this.gnr = gnr;
        this.bnr = bnr;
        this.areal = areal;
        this.eier = eier;
        this.bruksnavn = bruksnavn;
    }

    /**
     * Konstruktør som oppretter et objekt av typen Eiendom uten bruksnavn
     * @param kommunenr et tall fra og med 101 (Halden) til og med 5054 (Indre Fosen)
     * @param kommunenavn navnet til kommunen eiendommen ligger i
     * @param gnr forkortelse for gårdsnummer. Et positivt heltall
     * @param bnr forkortelse for bruksnummer. Et positivt heltall
     * @param areal areal i m^2. Et positivt desimaltall
     * @param eier navn på eier
     */

    public Eiendom(int kommunenr, String kommunenavn, int gnr, int bnr, double areal, String eier) {
        this.kommunenr = kommunenr;
        this.kommunenavn = kommunenavn;
        this.gnr = gnr;
        this.bnr = bnr;
        this.areal = areal;
        this.eier = eier;
    }

    /**
     * Henter kommunenummeret
     * @return int
     */
    public int getKommunenr() {
        return kommunenr;
    }

    /**
     * Henter kommunenavn
     * @return String
     */
    public String getKommunenavn() {
        return kommunenavn;
    }

    /**
     * Henter gårdsnummeret
     * @return int
     */
    public int getGnr() {
        return gnr;
    }

    /**
     * Henter bruksnummeret
     * @return int
     */
    public int getBnr() {
        return bnr;
    }

    /**
     * Henter arealet
     * @return double
     */
    public double getAreal() {
        return areal;
    }

    /**
     * Henter navnet til eieren
     * @return String
     */
    public String getEier() {
        return eier;
    }

    /**
     * Henter bruksnavnet
     * @return String
     */
    public String getBruksnavn() {
        return bruksnavn;
    }

    /**
     * Metode som skriver ut IDen (kommunenummeret, gårdsnummeret og bruksnummeret) til eiendommen i riktig format (kommunenummer-gårdsnummer/bruksnummer)
     * @return String
     */
    public String getID(){
        return kommunenr + "-" + gnr + "/" + bnr;
    }

    /**
     * equals-metode som sjekker om ID-en allerede er registrert
     * @param obj eiendommen ID-en skal sjekkes opp mot
     * @return boolean
     */

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Eiendom)) return false;
        Eiendom eiendom = (Eiendom) obj;
        String ID = eiendom.getID();
        if (ID.equals(getID())) return true;
        else return false;
    }

    /**
     * Sjekker om ID-en til eiendommen er lik ID-en brukeren har skrevet inn
     * @param ID består av kommunenummer, gårdsnummer og bruksnummer
     * @return boolean
     */

    public boolean likID(String ID) {
        if (ID.equals(getID())) return true;
        else return false;
    }

    /**
     * Sjekker om gårdsnummeret til eiendommen er lik gårdsnummeret brukeren har skrevet inn
     * @param gnr gårdsnummer
     * @return boolean
     */

    public boolean likGnr(int gnr) {
        if (gnr==getGnr()) return true;
        else return false;
    }

    /**
     * Skriver ut informasjonen om eiendommen
     * @return String
     */

    public String toString() {
        String liste = "Kommunenummer: " + kommunenr + "\nKommunenavn: " + kommunenavn + "\nGårdsnummer: " + gnr +
                "\nBruksnummer: " + bnr + "\nAreal: " + areal + "\nEier: " + eier;
        if(bruksnavn!=null){
            liste += "\nBruksnavn: " + bruksnavn;
        }
        return liste;
    }
}