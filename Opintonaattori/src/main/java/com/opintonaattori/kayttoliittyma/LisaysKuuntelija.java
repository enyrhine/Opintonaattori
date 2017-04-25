
package com.opintonaattori.kayttoliittyma;
import com.opintonaattori.logiikka.Kayttaja;
import java.awt.Container;
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
    private JTextField lahde3;
    private Kayttoliittyma kayttoliittyma;
    private Container container;
    
    public LisaysKuuntelija(Kayttaja kayttaja, Kayttoliittyma kayttoliittyma, JTextField lahde1, JTextField lahde2, JTextField lahde3) {
        this.kayttaja = kayttaja;
        this.lahde1 = lahde1;
        this.lahde2 = lahde2;
        this.lahde3 = lahde3;
        this.kayttoliittyma = kayttoliittyma;
        //this.container = new Container();
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
            this.kayttaja.lisaaKurssisuoritus(this.lahde1.getText(), intMuunnin(this.lahde2), intMuunnin(this.lahde3));
            this.kayttoliittyma.lisaaKurssi(this.kayttoliittyma.getFrame().getContentPane());
            this.kayttoliittyma.paivita(this.kayttoliittyma.getFrame().getContentPane());
        } catch (IOException | NumberFormatException ex) {
            Logger.getLogger(LisaysKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Metodi muuttaa saadun tekstikentän arvon kokonaisluvuksi.
     *
     * @param a muunnettavaksi haluttu JTextField
     *
     */
    public int intMuunnin(JTextField a) {
        int numero = Integer.parseInt(a.getText());
        return numero;
    }
    
}
