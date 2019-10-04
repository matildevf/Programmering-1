import java.util.Scanner;

class Student{
    private String navn;
    private int antOppg;

    public Student(String navn, int antOppg) {
        this.navn = navn;
        this.antOppg = antOppg;
    }

    public String getNavn() {
        return navn;
    }

    public int getAntOppg() {
        return antOppg;
    }

    public void okAntOppg(int okning){
        antOppg += okning;
    }

    public String toString(){
        return "Navn: " + getNavn() + "\nGodkjente oppgaver: " + getAntOppg() + "\n";
    }
}

class Oppgaveoversikt{
    private Student[] studenter;
    private int antStud = 0;

    public Oppgaveoversikt() {
        this.studenter = new Student[0];
    }

    public int antStudenter() {
        return antStud;
    }

    public int antOppgaver(Student stud){
        return stud.getAntOppg();
    }

    public boolean regStud(Student s){
        Student[] nyStudenter = new Student[studenter.length+1];
        for (int i=0; i<studenter.length; i++){
            nyStudenter[i] = studenter[i];
        }
        nyStudenter[nyStudenter.length-1]=s;
        studenter = nyStudenter;
        antStud++;
        return true;
    }

    public boolean okAntOppg(){
        String valg = "";
        for(int i=0; i<antStudenter(); i++){
            valg += (i+1) + ". " + studenter[i].getNavn() + "\n";
        }
        Scanner studInn = new Scanner(System.in);
        System.out.println("Velg student: \n" + valg);
        int v = studInn.nextInt();
        Scanner ngoInn = new Scanner(System.in);
        System.out.println("Øk antall godkjente oppgaver med: ");
        int ngo = ngoInn.nextInt();
        for(int i=0; i<antStudenter(); i++){
            studenter[i].okAntOppg(ngo);
        }
        return true;
    }

    public String toString() {
        String oppgaver = "";
        for (int i = 0; i<studenter.length; i++){
            oppgaver += studenter[i].getNavn() + " har " + antOppgaver(studenter[i]) + " godkjente oppgaver. \n";
        }
        return "Antall registrerte studenter: " + antStudenter() + "\n" + oppgaver;
    }
}

public class Oppgaver {
    public static void main(String[] args){
        Oppgaveoversikt x = new Oppgaveoversikt();

        while (true){
            Scanner endreInn = new Scanner(System.in);
            System.out.println("\nVelg handling: \n1. Vis antall registrerte studenter og antall godkjente oppgaver en student har \n2. Registrer ny student " +
                    "\n3. Øk antall godkjente oppgaver \n4. Avslutt");
            int endre = endreInn.nextInt();
            if (endre == 1){
                System.out.println(x.toString());
            }
            else if (endre == 2){
                System.out.println("Skriv inn navn og antall godkjente oppgaver: ");
                x.regStud(new Student(endreInn.next(),endreInn.nextInt()));
            }
            else if (endre == 3){
                if (x.okAntOppg()) {
                    System.out.println("Oppgavene ble registrert.");
                }
                else{
                    System.out.println("Noe gikk galt.");
                }
            }
            else if(endre == 4){
                break;
            }
            else{
                System.out.println("Skriv inn en gyldig verdi!");
            }
        }
    }
}
