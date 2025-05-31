import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIMacro {
    public GUIMacro(Dieta dieta) {
        ImageIcon icona = new ImageIcon("./img/logo.png");
        JFrame frame = new JFrame("App Dieta");
        frame.setSize(880, 600);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        gbc.insets = new Insets(10, 5, 10, 5);

        JLabel lblTitolo = new JLabel("Calcolo dei macronutrienti");
        lblTitolo.setFont(new Font("Serif", Font.BOLD, 22));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(lblTitolo, gbc);


        double carbo = dieta.calcoloCarboidrati();
        double proteine = dieta.calcoloProteine();
        double grassi = dieta.calcoloGrassi();
        JTextArea txtArea = new JTextArea("Macronutrienti consigliati: \nCarboidrati: " + String.format("%.2f g", carbo) + "\nProteine: " + String.format("%.2f g", proteine) + "\nGrassi: " + String.format("%.2f g", grassi));
        txtArea.setEditable(false);
        txtArea.setFont(new Font("Serif", Font.ITALIC, 20));
        txtArea.setBackground(new Color(204, 153, 255));
        txtArea.setForeground(new Color(0, 0, 0));
        txtArea.setLineWrap(true);
        txtArea.setWrapStyleWord(true);
        txtArea.setPreferredSize(new Dimension(300, 150));  // Dimensioni più contenute
        txtArea.setMargin(new Insets(10, 10, 10, 10));
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        panel.add(txtArea, gbc);

        JButton btnFile = new JButton("Salva su un file");
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(btnFile, gbc);

        btnFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int r = dieta.salvaRisultato();
                if (r == 0) {
                    JOptionPane.showMessageDialog(null, "Il file e' stato salvato nella directory selezionata", "File creato", JOptionPane.PLAIN_MESSAGE);
                }
                else if (r == 1) {
                    JOptionPane.showMessageDialog(null, "Salvataggio annullato", "Attenzione", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Non e' stato possibile creare il file", "Attenzione", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
