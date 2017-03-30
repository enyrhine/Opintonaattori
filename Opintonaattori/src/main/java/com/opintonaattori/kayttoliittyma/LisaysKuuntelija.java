
package com.opintonaattori.kayttoliittyma;
import com.opintonaattori.main.Kayttaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

public class LisaysKuuntelija implements ActionListener {

    private Kayttaja kayttaja;
    private JTextArea lahde;
    
    public LisaysKuuntelija(Kayttaja kayttaja, JTextArea lahde) {
        this.kayttaja = kayttaja;
        this.lahde = lahde;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.kayttaja.lisaaKurssisuoritus(this.lahde.getText(), 0, 0);
        } catch (IOException ex) {
            Logger.getLogger(LisaysKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
