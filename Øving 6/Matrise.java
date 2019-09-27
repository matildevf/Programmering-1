package com.company;

class regning {
    private int[][] m1;
    private int[][] m3;

    public regning(){
        this.m1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    }

    public void addere(int[][] m2){
        if (m1.length == m2.length && m1[0].length == m2[0].length) { //Sjekker om handlingen kan utføres
            System.out.println("\n Addere: ");
            int[][] m3 = new int[m1.length][m1[0].length];
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m1[i].length; j++) {
                    m3[i][j] = m1[i][j] + m2[i][j];
                    System.out.println(m3[i][j]);
                }
            }
        }
        else{
            System.out.println("null");
        }
    }

    public void multiplisere(int[][] m2) {
        if (m1.length == m2[0].length) { //Sjekker om handlingen kan utføres
            System.out.println("\n Multiplisere: ");
            m3 = new int[m2.length][m1[0].length];
            int x = 0;
            for (int i = 0; i < m3.length; i++) {
                for (int j = 0; j < m3[0].length; j++) {
                    x++;
                    if (m1[0].length<m2.length) {
                        for (int k = 0; k < m1[0].length; k++) {
                            m3[i][j] += m1[k][j] * m2[i][k];
                        }
                    }
                    else{
                        for (int k = 0; k < m2.length; k++) {
                            m3[i][j] += m1[k][j] * m2[i][k];
                        }
                    }
                    if (x%m3.length == 0) {
                        System.out.println(m3[i][j]);
                    }
                    else{
                        System.out.print(m3[i][j] + " ");
                    }
                }
            }
        }
        else {
            System.out.println("Null");
        }
    }

    public void transponere(){
        System.out.println("\n Transponere: ");
        int x = 0;
        m3 = new int[m1[0].length][m1.length];
        for (int i=0; i<m1.length; i++){
            for (int j=0; j<m1[i].length; j++){
                x++;
                //System.out.println(x);
                m3[i][j] = m1[j][i];
                if (x%m3.length == 0) {
                    System.out.println(m3[i][j]);
                }
                else{
                    System.out.print(m3[i][j] + " ");
                }
            }
        }
    }
}

public class Matrise{
    public static void main(String[] args) {
        int[][] m2 = {{10, 11, 12}, {13, 14, 15}};

        regning x = new regning();
        x.addere(m2);
        x.multiplisere(m2);
        x.transponere();
    }
}
