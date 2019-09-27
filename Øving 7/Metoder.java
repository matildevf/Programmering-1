class NyString{
    private String tekst;

    public NyString(String tekst){
        this.tekst = tekst.toLowerCase();
    }

    public String forkort() {
        String[] ord = tekst.split(" "); //Tabell med ordene
        String forkortet = "";
        for (int i = 0; i < ord.length; i++) { //Går gjennom alle ordene
            forkortet += ord[i].charAt(0); //Legger til første bokstaven i alle odene til stringen forkortet
        }
        return forkortet; //Returnerer forkortet som er stringen med alle forbokstavene
    }

    public String fjern(String b){
        //BRUK return tekst.replace(b, "");
        //Ikke resten

        char verdi = b.charAt(0); //Lager en variabel for verdien til bokstaven b
        int index = tekst.indexOf(verdi); //Finner indeksen til første forekomst av bokstaven b
        String fjernet = tekst.substring(0,index); //Lager en string fjernet som settes lik teksten fom er før index
        do { //Skal kjøres minst en gang
            //Legger til teksten mellom forige forekomst av bokstaven b og neste
            fjernet += tekst.substring(index+1, tekst.indexOf(verdi, index+1));
            index = tekst.indexOf(verdi, index+1); //Finner neste forekomst av bokstaven b
        }
        //Skal fortsette til det ikke er flere forekomster av bokstaven b. Da vil index bli lik -1
        while(index != -1 && tekst.indexOf(verdi, index+1) != -1);
        fjernet += tekst.substring(index+1); //Legger til teksten som er etter siste forekomst av bokstaven b
        return fjernet; //Returnerer teksten uten bokstaven b
    }
}

public class Metoder {
    public static void main(String[] args) {
        NyString x = new NyString("Hei til deg og dine idioter");

        System.out.println(x.forkort());
        System.out.println(x.fjern("e"));
    }
}
