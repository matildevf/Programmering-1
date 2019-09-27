import static javax.swing.JOptionPane.*;
import java.util.*;

class Primtall{
    static void primtall() {
        //Henter inn et tall
        String tallLest = showInputDialog("Tall: ");
        int tall = Integer.parseInt(tallLest);

        //Finner ut om tallet er et primtall
        if(tall == 0 || tall == 1){
            showMessageDialog(null, tall + " er ikke et primtall. \n");
        }
        else if(tall == 2){
            showMessageDialog(null, tall + " er et primtall. \n");
        }
        for (int i = 2; i < tall; i++){
            if(tall%i==0){ //Om tallet er delelig på i er det ikke et primtall
                showMessageDialog(null, tall + " er ikke et primtall. \n");
                break;
            }
            if(i==tall-1){ //Hvis i blir lik tallet under tall er tall et primtall
                showMessageDialog(null, tall + " er et primtall. \n");
            }
        }
    }
    public static void main (String[] args) {
        while(1<2){ //Gjør det mulig å teste flere tall
            primtall();
        }
    }
}
