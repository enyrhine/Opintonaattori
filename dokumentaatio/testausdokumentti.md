## Testausdokumentti

Kaikki testit on käsin kirjoitettu. Hankaluuksia tuottivat tiedostojen kirjoittamiseen ja lukemiseen liittyvät testit. Tuottivat paljon erroreita ja ilmeisesti try-catch:illa niistä päästiin eroon. Testit on pyritty tekemään mahdollisimman kattaviksi kuitenkaan käyttöliittymää ei ole testattu JUnit testeillä. Käyttöliittymän toimintaa testasin manuaalisesti ajamalla ohjelman ja muokkamalla näkymää halutunlaiseksi.

Ohjelma ei pyöristä keskiarvoja, vaan näyttää päättymättömistä luvuista 15 ensimmäistä desimaalia. 
Lisäksi ohjelmaa suorittaessa esiintyy error: java.lang.NumberFormatException: For input string: "Opintopisteet", kun yritetään muuttaa käyttöliittymän JTextField:in parametria Integeriksi, tämä siksi että syötteenä tulee kuitenkin antaa kokonaisluku. Ei vaikuta ohjelman toimintaan.
Kun lisätään tarpeeksi monta kurssisuoritusta, käyttöliittymä alkaa pienentämään riviväliä. En saanut kuitenkaan lisättyä niin montaa suoritusta, että vaikuttaisi ohjelman käyttömukavuuteen.
