import static javax.swing.JOptionPane.*;

class Kjottdeig{
    public static void main (String[] args) {
        final double aPris = 35.90;
        final double aVekt = 450;
        final double bPris = 39.50;
        final double bVekt = 500;

        double a = aPris/aVekt;
        double b = bPris/bVekt;

        if(a<b){
            showMessageDialog(null, "Det billigste kjøttdeig-merket er A.");
        }
        else if(a>b){
            showMessageDialog(null, "Det billigste kjøttdeig-merket er B.");
        }
        else{
            showMessageDialog(null, "Begge kjøttdeig-merkene koster like mye.");
        }
    }
}
