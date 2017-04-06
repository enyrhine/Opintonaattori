
package com.opintonaattori.kayttoliittyma;
import com.opintonaattori.logiikka.Kayttaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Luokka tarjoaa käyttöliittymän lisäyspainikkeen toiminnallisuuteen liittyvät metodit.
 */
public class LisaysKuuntelija implements ActionListener {

    private Kayttaja kayttaja;
    private JTextField lahde1;
    private JTextField lahde2;
    private int lahde3;
    
    public LisaysKuuntelija(Kayttaja kayttaja, JTextField lahde1, JTextField lahde2, int lahde3) {
        this.kayttaja = kayttaja;
        this.lahde1 = lahde1;
        this.lahde2 = lahde2;
        this.lahde3 = lahde3;
    }
    
    /**
     * Metodi lisää käyttäjälle uuden kurssisuorituksen 
     * kun lisää nappia painetaan.
     *
     * @param e annettu ActionEvent
     *
     * @see com.opintonaattori.logiikka.Kayttaja#lisaaKurssisuoritus(java.lang.String, int, int)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            //int lahdeTesti = Integer.parseInt(this.lahde2.getText());
            int lahdeTesti = 0;
            this.kayttaja.lisaaKurssisuoritus(this.lahde1.getText(), lahdeTesti, this.lahde3);
        } catch (IOException | NumberFormatException ex) {
            Logger.getLogger(LisaysKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    public void setLisaysKuuntelija(JTextField a, JTextField b, int c) {
//        this.lahde1 = a;
//        this.lahde2 = b;
//        this.lahde3 = c;
//    }
    
}
