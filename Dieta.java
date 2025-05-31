import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

public class Dieta extends Persona{
    private double tot;
    public Dieta (double peso, double altezza, String genere, int eta, String attvita) {
        super(peso, altezza, genere, eta, attvita);
        tot=0;
    }

    public double calcoloBMR () {
        if (genere.equals("maschio")) {
            return 10 * peso + 6.25 * altezza - 5 * eta + 5;
        }
        else if (genere.equals("femmina")) {
            return 10 * peso + 6.25 * altezza - 5 * eta - 161;
        }
        return 0;
        //kcal
    }

    public double calcoloTDEE () {
        double fattore=0;
        if (attivita.equals("Sedentaria")) {
          fattore=1.2;
        }
        else if (attivita.equals("Leggera")){
          fattore=1.375;
        }
        else if (attivita.equals("Moderata")){
          fattore=1.55;
        }
        else if (attivita.equals("Intensa")){
          fattore=1.725;
        }
        else if (attivita.equals("Estrema")){
          fattore=1.9;
        }
        tot = calcoloBMR()*fattore; //kcal
        return tot;
    }

    public double calcoloTotale (String fase, double v) {
        if (fase.equals("Surplus")) {
            tot+=v;
        }
        else if (fase.equals("Deficit")) {
            tot-=v;
        }
        return tot;
    }

    public double calcoloProteine () {
        return peso*2;
    }

    public double calcoloGrassi () {
        double cgr = tot*0.2; //kcal dei grassi
        return cgr/9;
    }
    public double calcoloCarboidrati () {
        double ccb = tot-calcoloProteine()*4-tot*0.2;
        return ccb/4; //1g carboidrati = 4kcal
    }
    public int salvaRisultato () {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Scegli dove salvare il file");
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("File di testo (*.txt)", "txt");
        fileChooser.setName("pippo");
        fileChooser.setFileFilter(filtro);
        int scelta = fileChooser.showSaveDialog(null);
        if (scelta == JFileChooser.APPROVE_OPTION) {
            File f = fileChooser.getSelectedFile();
            String percorso = f.getAbsolutePath();
            // Aggiunge ".txt" se manca
            if (!percorso.toLowerCase().endsWith(".txt")) {
                percorso += ".txt";
                f = new File(percorso);
            }
            try (PrintWriter fOUT = new PrintWriter(new FileWriter(f))) {
                fOUT.println("Dati inseriti:\n" + "Altezza: " + altezza + "\nPeso: " + peso + "\nGenere: " + genere + "\nEta: " + eta + "\nAttività: " + attivita);
                fOUT.println("\nCalorie totali: " + String.format("%.2f kcal\n", tot));
                fOUT.println("Macronutrienti consigliati: \nCarboidrati: " + String.format(Locale.ENGLISH, "%.2f", calcoloCarboidrati()) + " g\nProteine: " + String.format(Locale.ENGLISH, "%.2f", calcoloProteine()) + " g\nGrassi: " + String.format(Locale.ENGLISH, "%.2f", calcoloGrassi()) + " g");
                fOUT.flush();
                fOUT.close();
            }
            catch (IOException e) {
                return -1;
            }
        }
        else {
            return 1;
        }
        return 0;
    }
}