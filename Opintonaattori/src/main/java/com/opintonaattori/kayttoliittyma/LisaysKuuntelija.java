
package com.opintonaattori.kayttoliittyma;
import com.opintonaattori.main.Kayttaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LisaysKuuntelija implements ActionListener {

    private Kayttaja kayttaja;
    private JTextField lahde1;
    private int lahde2;
    private int lahde3;
    
    public LisaysKuuntelija(Kayttaja kayttaja, JTextField lahde1, int lahde2, int lahde3) {
        this.kayttaja = kayttaja;
        this.lahde1 = lahde1;
        this.lahde2 = lahde2;
        this.lahde3 = lahde3;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.kayttaja.lisaaKurssisuoritus(this.lahde1.getName(), this.lahde2, this.lahde3);
        } catch (IOException ex) {
            Logger.getLogger(LisaysKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setLisaysKuuntelija(JTextField a, int b, int c) {
        this.lahde1 = a;
        this.lahde2 = b;
        this.lahde3 = c;
    }
    
}
