class Brok{
    //Objektvariabler
    private int teller;
    private int nevner;

    //Konstruktører
    public Brok(int teller, int nevner){
        this.teller = teller;
        this.nevner = nevner;
        if(nevner == 0){ //Feilmelding
            throw new IllegalArgumentException("Ugyldig brøk");
        }
    }
    public Brok(int teller){
        this.teller = teller;
        this.nevner = 1;
    }

    //Metoder
    //Henter informasjon
    public int getTeller(){
        return teller;
    }
    public int getNevner(){
        return nevner;
    }
    //Utfører utregninger
    public void summer(int tellerP, int nevnerP){
        teller = (teller * nevnerP) + (tellerP * nevner);
        nevner = nevner * nevnerP;
    }
    public void subtraher(int tellerP, int nevnerP){
        teller = (teller * nevnerP) - (tellerP * nevner);
        nevner = nevner * nevnerP;
    }
    public void multipliser(int tellerP, int nevnerP){
        teller = teller * tellerP;
        nevner = nevner * nevnerP;
    }
    public void divider(int tellerP, int nevnerP){
        teller = teller * nevnerP;
        nevner = nevner * tellerP;
    }
    //Forkorter brøken
    public void forkort(){
        for (int i = 2; i <= nevner; i++){
            while(teller%i==0 && nevner%i==0){ //Om tallet er delelig på i kan brøken forkortes med faktoren i
                teller /= i;
                nevner /= i;
            }
            break;
        }
    }

    public String toString(){
        return "Teller: " + teller + "\nNevner: " + nevner;
    }
}

class Brokregning{
    public static void main(String[] args){
        int tellerPinn = 5;
        int nevnerPinn = 4;

        Brok x = new Brok(2, 4);
        x.summer(tellerPinn, nevnerPinn);
        //x.subtraher(tellerPinn, nevnerPinn);
        //x.multipliser(tellerPinn, nevnerPinn);
        //x.divider(tellerPinn, nevnerPinn);
        x.forkort();
        System.out.println(x);
    }
}
