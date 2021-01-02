import static javax.swing.JOptionPane.*;

class Primtall{
    static boolean primtall() {
        String tallLest = showInputDialog("Tall: ");
        if (tallLest == null) return false;
        int tall = Integer.parseInt(tallLest);

        //Finner ut om tallet er et primtall
        if(tall == 0 || tall == 1){
            showMessageDialog(null, tall + " er ikke et primtall.");
        }
        else if(tall == 2){
            showMessageDialog(null, tall + " er et primtall.");
        }
        for (int i = 2; i < tall; i++){
            if(tall%i==0){ //Om tallet er delelig på i er det ikke et primtall
                showMessageDialog(null, tall + " er ikke et primtall.");
                break;
            }
            else if(i>=tall/2){ //Hvis i blir større eller lik tall/2 er tall et primtall
                showMessageDialog(null, tall + " er et primtall.");
                break;
            }
        }
        return true;
    }
    public static void main (String[] args) {
        while(primtall()); //Kjører metoden primtall til cancle er trykket
    }
}
