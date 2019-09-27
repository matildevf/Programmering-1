import java.util.*;

class Tilfeldigtallgenerator{
    public static void main(String[] args){
        int[] antall = new int[10];

        // Bruker random for å velge tilfeldige tall. For så å legge til 1 på plassen til tallet
        Random tilfeldig = new Random();
        for(int i = 1; i<=1000; i++){
            int tall = tilfeldig.nextInt(10);
            antall[tall] += 1;
        }

        // Skriver ut tallet, antall ganger tallet ble valgt og 1 sjerne for hver 10. gang tallet ble valgt
        for(int j = 0; j<antall.length; j++){
            System.out.print(j + ": " + antall[j]);
            int stjerner = antall[j]/10;
            if (antall[j]%10>=5){
                stjerner++;
            }
            for(int k = 1; k<=stjerner; k++){
                System.out.print("*");
            }
            System.out.println("(" + stjerner + ")");
        }
    }
}