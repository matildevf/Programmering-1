import static javax.swing.JOptionPane.*;
import java.util.*;

class Skuddar{
    public static void main (String[] args) {
        //Henter inn årstall
        String arstallLest = showInputDialog("Årstall: ");
        int arstall = Integer.parseInt(arstallLest);

        if(arstall > 0){
            //Sjekker om det er skuddår
            if(arstall%400==0){ //Årstall delelig på 400 er skuddår
                showMessageDialog(null, arstall + " er et skuddår.");
            }
            else if(arstall%4==0 && arstall%100!=0){ //Årstall delelig på 4, men ikke 100 er skuddår
                showMessageDialog(null, arstall + " er et skuddår.");
            }
            else{ //Resten er ikke skuddår
                showMessageDialog(null, arstall + " er ikke et skuddår.");
            }
        }
        else{
            showMessageDialog(null, "Skriv inn gyldig verdi.");
        }
    }
}
