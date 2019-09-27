class Temp{
    private double[][] malinger;
    double[] middelTemperDager;
    double[] middelTemperTimer;
    int[] middelTempGrupper = new int[5];

    public Temp(){
        this.malinger = new double[][]{{16.5, 16.2, 13.5, 14.0, 12.4}, {14.4, 13.9, 13.0, 12.3, 11.6}, {12.0, 11.9, 11.8, 11.7, 11.5}};
    }

    public double[] middelTempDag(){
        middelTemperDager = new double[malinger.length];
        for (int i=0; i<malinger.length; i++){ // Går gjennom hver dag
            double max = malinger[i][0];
            double min = malinger[i][0];
            for (int j=0; j<malinger[i].length; j++){ //Går gjennom hver time
                if (malinger[i][j]>max){
                    max = malinger[i][j];
                }
                if (malinger[i][j]<min){
                    min = malinger[i][j];
                }
            }
            middelTemperDager[i] = ((max-min)/2)+min; // Regner ut middeltemperaturen og legger den til i tabellen
        }
        return middelTemperDager;
    }

    public double[] middelTempTimer(){
        middelTemperTimer = new double[malinger[0].length];
        for (int j=0; j<malinger[0].length; j++){ //Går gjennom alle timene
            double max = malinger[0][j];
            double min = malinger[0][j];
            for (int i=0; i<malinger.length; i++){ //Går gjennom alle dagene
                if (malinger[i][j]>max){
                    max = malinger[i][j];
                }
                if (malinger[i][j]<min){
                    min = malinger[i][j];
                }
            }
            middelTemperTimer[j] = ((max-min)/2)+min; //Regner ut alle middeltemperatueren og legger den til i tabellen
        }
        return middelTemperTimer;
    }

    public double middelTempManed(){
        double max = malinger[0][0];
        double min = malinger[0][0];
        for (int i=0; i<malinger.length; i++){ //Går gjennom alle dagene
            for (int j=0; j<malinger[i].length; j++){ //Går gjennom alle timene
                if (malinger[i][j]>max){
                    max = malinger[i][j];
                }
                if (malinger[i][j]<min){
                    min = malinger[i][j];
                }
            }
        }
        return ((max-min)/2)+min; //Regner ut og returnerer middeltemperaturen
    }

    public int[] grupper(){
        for (int i=0; i<middelTemperDager.length; i++) { //Går gjennom tabellen med middeltemperaturene for dagene
            //Sjekker hvilken gruppe temperaturen passer i
            if (middelTemperDager[i]<-5){
                middelTempGrupper[0]++;
            }
            else if (middelTemperDager[i]>=-5 && middelTemperDager[i]<0){
                middelTempGrupper[1]++;
            }
            else if (middelTemperDager[i]>=0 && middelTemperDager[i]<5){
                middelTempGrupper[2]++;
            }
            else if (middelTemperDager[i]>=5 && middelTemperDager[i]<10){
                middelTempGrupper[3]++;
            }
            else{
                middelTempGrupper[4]++;
            }
        }
        return middelTempGrupper;
    }

    public String toString(){
        String tekst = "Middeltemperaturen for hver dag: \n";
        for (int i=0; i<middelTemperDager.length; i++){
            tekst += "Dag " + (i+1) + ": " + middelTemperDager[i] + " grader \n";
        }
        tekst += "Middeltemperaturen for hver time: \n";
        for (int i=0; i<middelTemperTimer.length; i++) {
            tekst += "Time " + (i+1) + ": " + middelTemperTimer[i] + " grader \n";
        }
        tekst += "Middeltemperaturen for måneden: \n" + middelTempManed() + " grader \n";
        tekst += "Middeltemperaturene i grupper: \nMindre enn -5 grader: " + middelTempGrupper[0] +
                "\nMellom -5 og 0 grader: " + middelTempGrupper[1] + "\nMellom 0 og 5 grader: " +
                middelTempGrupper[2] + "\nMellom 5 og 10 grader: " + middelTempGrupper[3] +
                "\n10 og over 10 grader: " + middelTempGrupper[4];

        return tekst;
    }
}

public class Temperaturer {
    public static void main(String[] args){
        Temp x = new Temp();

        x.middelTempDag();
        x.middelTempTimer();
        x.grupper();
        System.out.println(x.toString());
    }

}
