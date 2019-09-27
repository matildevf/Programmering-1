import java.util.*;

class Spiller{
    private int sumPoeng;

    public Spiller(int sumPoeng){
        this.sumPoeng = sumPoeng;
    }

    public int getSumPoeng(){
        return sumPoeng;
    }

    public void kastTerningen(){
        Random terning = new Random();
        int terningkast = terning.nextInt(6)+1;

        if(sumPoeng < 100){
            sumPoeng += terningkast;
        }
        else{
            sumPoeng -= terningkast;
        }

        if(terningkast == 1){
            sumPoeng = 0;
        }
    }

    public boolean erFerdig(){
        return sumPoeng == 100;
    }
}


class Terningspillet100{
    public static void main(String[] args){
        Spiller A = new Spiller(0);
        Spiller B = new Spiller(0);

        int runde = 1;

        while(A.erFerdig() == false && B.erFerdig() == false){
            System.out.println("\n Runde: " + runde);
            A.kastTerningen();
            System.out.println("Spiller A: " + A.getSumPoeng());
            B.kastTerningen();
            System.out.println("Spiller B: " + B.getSumPoeng());
            runde++;
        }
        if(A.erFerdig()){
            System.out.println("\nSpiller A vant!");
        }
        else{
            System.out.println("\nSpiller B vant!");
        }
    }
}
