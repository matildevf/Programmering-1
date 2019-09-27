import java.util.*;

class MinRandom{
    Random tilfeldigTall;

    public MinRandom(){
        this.tilfeldigTall = new Random();
    }

    public int nesteHeltall(int nedre, int ovre){
        return tilfeldigTall.nextInt((ovre - nedre)+1)+nedre;
    }

    public double nesteDesimaltall(double nedre, double ovre){
        return nedre + (ovre - nedre) * tilfeldigTall.nextDouble();
    }
}

class Tilfeldig{
    public static void main(String[] args){
        int nedreI = 5;
        int ovreI = 7;
        double nedreD = 0.2;
        double ovreD = 0.3;

        MinRandom x = new MinRandom();
        System.out.println(x.nesteHeltall(nedreI, ovreI));
        System.out.println(x.nesteDesimaltall(nedreD, ovreD));
    }
}
