import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppDieta {
    public static void main(String[] args) {
        ImageIcon icona = new ImageIcon("./img/logo.png");
        JFrame frame = new JFrame("App Dieta");
        frame.setSize(880, 600);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(icona.getImage());
        frame.getContentPane().setBackground(new Color(204, 153, 255));
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(204, 153, 255));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel inse = new JLabel("Inserimento dei dati");
        inse.setFont(new Font("Serif", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(inse, gbc);

        gbc.gridwidth = 1;

        JLabel lblAltezza = new JLabel("Altezza (cm):");
        lblAltezza.setFont(new Font("Serif", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(lblAltezza, gbc);

        JTextField txtAltezza = new JTextField(10);
        gbc.gridx = 1;
        panel.add(txtAltezza, gbc);

        JLabel lblPeso = new JLabel("Peso (kg):");
        lblPeso.setFont(new Font("Serif", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(lblPeso, gbc);

        JTextField txtPeso = new JTextField(10);
        gbc.gridx = 1;
        panel.add(txtPeso, gbc);

        JLabel lblGenere = new JLabel("Scegli il genere:");
        lblGenere.setFont(new Font("Serif", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(lblGenere, gbc);

        JRadioButton maschio = new JRadioButton("Maschio");
        JRadioButton femmina = new JRadioButton("Femmina");
        maschio.setBackground(new Color(204, 153, 255));
        femmina.setBackground(new Color(204, 153, 255));

        ButtonGroup gruppoGenere = new ButtonGroup();
        gruppoGenere.add(maschio);
        gruppoGenere.add(femmina);

        gbc.gridx = 1;
        panel.add(maschio, gbc);
        gbc.gridx = 2;
        panel.add(femmina, gbc);

        JLabel lblEta = new JLabel("Età:");
        lblEta.setFont(new Font("Serif", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(lblEta, gbc);

        JTextField txtEta = new JTextField(10);
        gbc.gridx = 1;
        panel.add(txtEta, gbc);

        JLabel lblAttivita = new JLabel("Livello di attività:");
        lblAttivita.setFont(new Font("Serif", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(lblAttivita, gbc);

        String[] livelliAttivita = {"Sedentaria", "Leggera", "Moderata", "Intensa", "Estrema"};
        JComboBox<String> cmbAttivita = new JComboBox<>(livelliAttivita);
        gbc.gridx = 1;
        panel.add(cmbAttivita, gbc);

        JLabel lblFase = new JLabel("Fase:");
        lblFase.setFont(new Font("Serif", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(lblFase, gbc);

        String[] fase = {"Mantenimento","Surplus" , "Deficit"};
        JComboBox<String> cmbFase = new JComboBox<>(fase);
        gbc.gridx = 1;
        panel.add(cmbFase, gbc);

        JLabel lblValore = new JLabel("Inserisci il valore: ");
        JTextField txtValore = new JTextField(10);
        lblValore.setVisible(false);
        txtValore.setVisible(false);
        gbc.gridy = 7;
        gbc.gridx = 0;
        panel.add(lblValore, gbc);
        gbc.gridx = 1;
        panel.add(txtValore, gbc);

        cmbFase.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if (cmbFase.getSelectedItem().equals("Surplus") || cmbFase.getSelectedItem().equals("Deficit")) {
                    lblValore.setVisible(true);
                    txtValore.setVisible(true);
                }
                else {
                    lblValore.setVisible(false);
                    txtValore.setVisible(false);
                }
                panel.revalidate();
                panel.repaint();
            }
        });


        JButton btnCalcola = new JButton("Calcola");
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        panel.add(btnCalcola, gbc);

        JButton btnInfoAttivita = new JButton("Dettagli sulle attività");
        gbc.gridx = 3;
        panel.add(btnInfoAttivita, gbc);
        btnInfoAttivita.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null,"Sedentaria: Nessuna o poca attività fisica. Lavoro d’ufficio, studio, vita quotidiana con poco movimento.\n" +
                        "Leggera: Attività fisica leggera 1–3 volte a settimana (camminate, ginnastica dolce, attività non intense).\n" +
                        "Moderata: Allenamenti regolari 3–5 volte a settimana (palestra, sport amatoriale, lavori fisicamente attivi).\nIntensa: Attività fisica intensa 6–7 giorni a settimana (allenamenti sportivi, lavori fisici impegnativi).\n" +
                        "Estrema: Attività fisica molto intensa, due volte al giorno o lavoro fisico pesante quotidiano (atleti professionisti, lavori manuali pesanti).","Dettagli sulle attività",JOptionPane.INFORMATION_MESSAGE);
            }
        });

        JTextArea txtArea = new JTextArea("\nBMR e TDEE verranno mostrati qui.");
        txtArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        txtArea.setEditable(false);
        txtArea.setFont(new Font("Serif", Font.PLAIN, 18));
        txtArea.setBackground(new Color(204, 153, 255));
        txtArea.setForeground(new Color(0, 0, 0));
        txtArea.setLineWrap(true);
        txtArea.setWrapStyleWord(true);
        //txtArea.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 2));

        txtArea.setPreferredSize(new Dimension(300, 125));  // Dimensioni più contenute
        txtArea.setMargin(new Insets(10, 10, 10, 10));

        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 3;
        panel.add(txtArea, gbc);

        btnCalcola.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double peso = Double.parseDouble(txtPeso.getText());
                    double altezza = Double.parseDouble(txtAltezza.getText());
                    int eta = Integer.parseInt(txtEta.getText());
                    if (peso < 20 || peso > 150) {
                        txtArea.setText("Errore: Il peso deve essere tra 20 e 150 kg.");
                        return;
                    }
                    if (altezza < 100 || altezza > 250) {
                        txtArea.setText("Errore: L'altezza deve essere tra 100 e 250 cm.");
                        return;
                    }
                    if (eta < 10 || eta > 120) {
                        txtArea.setText("Errore: L'età deve essere tra 10 e 120 anni.");
                        return;
                    }
                    String genere;
                    if (maschio.isSelected()){
                        genere = "maschio";
                    }
                    else if (femmina.isSelected()){
                        genere = "femmina";
                    }
                    else {
                        txtArea.setText("Errore: Genere non selezionato.");
                        return;
                    }
                    String attivita = (String) cmbAttivita.getSelectedItem();

                    Dieta dieta = new Dieta(peso, altezza, genere, eta, attivita);

                    double bmr = dieta.calcoloBMR();
                    double tdee = dieta.calcoloTDEE();

                    String fase = (String) cmbFase.getSelectedItem();
                    double aggiunta = 0;
                    if (!cmbFase.getSelectedItem().equals("Mantenimento")) {
                        aggiunta= Double.parseDouble(txtValore.getText());
                    }
                    double totale = dieta.calcoloTotale(fase,aggiunta);

                    txtArea.setText("CALORIE CONSIGLIATE\nBMR: " + String.format("%.2f kcal", bmr) + "\nTDEE: " + String.format("%.2f kcal", tdee) + "\nTotale: " + String.format("%.2f kcal\n", totale));
                    JButton btnPassa = new JButton("Clicca qui per passare al calcolo dei macronutrienti");
                    gbc.gridy = 10;
                    panel.add(btnPassa, gbc);
                    btnPassa.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e){
                            GUIMacro gui_macro = new GUIMacro(dieta);
                        }
                    });
                } catch (NumberFormatException ex) {
                    txtArea.setText("E' richiesta la compilazione di tutti i campi.");
                }
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
