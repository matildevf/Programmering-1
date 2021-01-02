import static javax.swing.JOptionPane.*;

class Kjottdeig{
    public static void main (String[] args) {
        final double A_PRIS = 35.90;
        final double A_VEKT = 450;
        final double B_PRIS = 39.50;
        final double B_VEKT = 500;

        double a = A_PRIS/A_VEKT;
        double b = B_PRIS/B_VEKT;

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
