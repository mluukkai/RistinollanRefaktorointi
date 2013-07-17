package refaktoroitu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RistiNolla implements ActionListener {

    public JFrame kentta;
    public Ruutu ruudut[];
    
    private Pelilogiikka lauta;

    public static void main(String[] args) {
        RistiNolla r = new RistiNolla();
        r.alustaLauta();
        r.kentta.setVisible(true);
    }

    public RistiNolla() {
        kentta = new JFrame("Ristinolla");
        ruudut = new Ruutu[9];
        lauta = new Pelilogiikka();
    }

    public void actionPerformed(ActionEvent a) {
        Ruutu valittuRuutu = (Ruutu) a.getSource();

        valittuRuutu.setText(lauta.pelaaja().toString());        
        valittuRuutu.setEnabled(false);

        lauta.siirto(valittuRuutu.positio());        
        
        System.out.println(valittuRuutu.positio());
        
        if (lauta.loppunut()) {
            JOptionPane.showMessageDialog(null, lopetusviesti());
            kentta.dispose();
        }
    }

    public void alustaLauta() {
        kentta.setSize(400, 400);
        kentta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        kentta.setLayout(new GridLayout(3, 3));

        for (int i = 0; i <= 8; i++) {
            ruudut[i] = new Ruutu(i);
            kentta.add(ruudut[i]);
            ruudut[i].addActionListener(this);
        }
    }

    private String lopetusviesti() {
        String viesti = "Tasapeli.";
        if (!lauta.tasapeli()) {
            viesti = lauta.voittaja() == Pelaaja.X ? "Pelaaja 1 VOITTI!" : "Pelaaja 2 VOITTI!";
        }
        return viesti;
    }
}