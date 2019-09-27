import static javax.swing.JOptionPane.*;

class Valuta{
    private String valuta;
    private double kurs;

    public Valuta(String valuta, double kurs){ //Konstruktør for valuta
        this.valuta = valuta;
        this.kurs = kurs;
    }
    public String getValuta(){
        return valuta;
    }
    public double fra(int belop){ //Regner om fra NOK
        return belop / kurs;

    }
    public double til(int belop){ //Regner om til NOK
        return belop * kurs;
    }
}

class OmgjoringValuta{
    public static void main(String[] args){
        while(1<2){ //Lar brukeren omgjøre flere beløp
            //Henter verdier og deklarerer variabler
            String ftLest = showInputDialog("Velg handling: \n 1. Fra NOK \n 2. Til NOK \n 3. Avslutt");
            int ft = Integer.parseInt(ftLest);
            if(ft == 3){
                break;
            }

            String valutaLest = showInputDialog("Velg valuta: \n 1. Dollar \n 2. Euro \n 3. Svenske kroner \n 4. Avslutt");
            int valutaInt = Integer.parseInt(valutaLest);
            if(valutaInt == 4){
                break;
            }

            String belopLest = showInputDialog("Fyll inn beløp: ");
            int belop = Integer.parseInt(belopLest);

            Valuta d = new Valuta("dollar", 9.06);
            Valuta e = new Valuta("euro", 10.04);
            Valuta sk = new Valuta("svenske kroner", 0.93);
            //Valuta nk = new Valuta("norske kroner", 1);

            if(valutaInt == 1){
                if(ft == 1){
                    System.out.printf(belop + "NOK tilsvarer %1.2f" + d.getValuta() + "\n", d.fra(belop));
                }
                else if(ft == 2){
                    System.out.printf(belop + d.getValuta() + " tilsvarer %1.2fNOK\n", d.til(belop));
                }
                else{
                    showMessageDialog(null, "Skriv inn gyldige verdier");
                }
            }
            else if(valutaInt == 2){
                if(ft == 1){
                    System.out.printf(belop + "NOK tilsvarer %1.2f" + e.getValuta() + "\n", e.fra(belop));
                }
                else if(ft == 2){
                    System.out.printf(belop + d.getValuta() + " tilsvarer %1.2fNOK\n", e.til(belop));
                }
                else{
                    showMessageDialog(null, "Skriv inn gyldige verdier");
                }
            }
            else if(valutaInt == 3){
                if(ft == 1){
                    System.out.printf(belop + "NOK tilsvarer %1.2f" + sk.getValuta() + "\n", sk.fra(belop));
                }
                else if(ft == 2){
                    System.out.printf(belop + d.getValuta() + " tilsvarer %1.2fNOK\n", sk.til(belop));
                }
                else{
                    showMessageDialog(null, "Skriv inn gyldige verdier");
                }
            }
            else{
                showMessageDialog(null, "Skriv inn gyldige verdier");
            }

        }
    }
}
