
package alukuperainen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RistiNolla implements ActionListener {
    static public boolean pelaaja1Vuoro;
    static public boolean voitto1;
    static public boolean voitto2;
    static public boolean tasapeli;
    static public int vuoro;

    public JFrame kenttä = new JFrame("Ristinolla");
    public JButton ruudut[] = new JButton[9];
 
    public static void main(String[] args) {
        RistiNolla r = new RistiNolla();
        r.alustaLauta();
        r.kenttä.setVisible(true);
    }

    public void actionPerformed(ActionEvent a) {

        JButton valittuRuutu = (JButton)a.getSource(); 
	if (pelaaja1Vuoro) {
            valittuRuutu.setText("X");
            pelaaja1Vuoro = false;
        } else {
            valittuRuutu.setText("O");
            pelaaja1Vuoro = true;
        }
        valittuRuutu.setEnabled(false);
        tarkistaVoitto();
        if (voitto1) {
            JOptionPane.showMessageDialog(null,  "Pelaaja 1 VOITTI!");
            System.exit(0);
        } else if (voitto2) {
            JOptionPane.showMessageDialog(null,  "Pelaaja 2 VOITTI!");
            System.exit(0);
        } else if (tasapeli) {
            JOptionPane.showMessageDialog(null,  "Tasapeli.");
            System.exit(0);
        }
        ++vuoro;
    }

    public void alustaLauta() {
        vuoro=1;
        voitto1 = false;
        voitto2 = false;
        tasapeli = false;
        pelaaja1Vuoro = true;
        kenttä.setSize(400,400);
        kenttä.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        kenttä.setLayout(new GridLayout(3,3));
        for(int i=0; i<=8; i++){
		ruudut[i] = new JButton();
		kenttä.add(ruudut[i]);
		ruudut[i].addActionListener(this);
	}
 
    }
       
    public void tarkistaVoitto() {
        
        for (int i=0; i < 3; i++) {
            if (ruudut[i].getText() == ruudut[i+3].getText() && ruudut[i].getText() == ruudut[i+6].getText()) {
                if (ruudut[i].getText() == "X") {
                    voitto1 = true;
            }
                if (ruudut[i].getText() == "O") {
                    voitto2 = true;
                }
            }
        }
        for (int i=0; i < 8; i = i+3) {
            if (ruudut[i].getText() == ruudut[i+1].getText() && ruudut[i].getText() == ruudut[i+2].getText()) {
                if (ruudut[i].getText() == "X") {
                    voitto1 = true;
            }
                if (ruudut[i].getText() == "O") {
                    voitto2 = true;
                }
            }
        }
        
        if(ruudut[0].getText() == ruudut[4].getText() && ruudut[0].getText() == ruudut[8].getText()) {       
           if (ruudut[0].getText() == "X") {
               voitto1 = true;
           }
           if (ruudut[0].getText() == "O") {
               voitto2 = true;
           }
       } 
        if(ruudut[2].getText() == ruudut[4].getText() && ruudut[2].getText() == ruudut[6].getText()) {       
           if (ruudut[2].getText() == "X") {
               voitto1 = true;
           }
           if (ruudut[2].getText() == "O") {
               voitto2 = true;
           }
       }
        if (!voitto1 && !voitto2 && vuoro == 9) {
            tasapeli = true;
        }
    }  
}