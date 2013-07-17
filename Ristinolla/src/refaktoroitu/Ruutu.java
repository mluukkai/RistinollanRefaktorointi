package refaktoroitu;

import javax.swing.JButton;

public class Ruutu extends JButton {
    private int nro;

    public Ruutu(int nro) {
        super();
        this.nro = nro;
    }
  
    public int positio() {
        return nro;
    }
   
}
