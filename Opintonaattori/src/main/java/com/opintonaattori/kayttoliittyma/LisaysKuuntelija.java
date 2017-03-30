
package com.opintonaattori.kayttoliittyma;
import com.opintonaattori.Kayttaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        this.kayttaja.lisaaKurssisuoritus(this.lahde.getText(), 0, 0);
    }
    
}
