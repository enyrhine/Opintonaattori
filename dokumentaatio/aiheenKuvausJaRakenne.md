## Aihe: 
Opintojen seurantajärjestelmä, jonka avulla opiskelija pystyy seuraamaan opiskelujensa etenemistä lisäämällä kursseja, tarkastelemaan opintopisteitään sekä näkemään suoritettujen kurssien arvosanat.

### Käyttäjän toiminnot: 
kurssin ja sen tietojen lisäys.

### Luokkakaavio
![Alt text](https://github.com/enyrhine/Opintonaattori/blob/master/dokumentaatio/Java_luokkakaavio2.png "Luokkakaavio")

## Rakennekuvaus:
Kayttaja-luokka on yhteydessä kaikkiin muihin luokkiin. Niissä luetaan käyttäjän tiedostoa ja tehdään siihen muutoksia.
Tiedostojen hallinta tapahtuu Rapottikone ja Tallentaja -luokissa, joissa tiedoston lukemista ja tallennusta vaativat metodit sijaitsevat. Käyttöliittymä luo ohjelman, jolla käyttäjä näkee omat kurssisuorituksensa ja pystyy lisäämään nappia painamalla uuden kurssisuorituksen tiedostoonsa. Kurssisuoritus -luokka pitää sisällään kurssisuorituksen tiedot: nimen. opintopistemäärän ja arvosanan, sen avulla pystyy luomaan käyttäjälle uuden kurssisuoritusolion.

### Sekvenssikaaviot
![Alt text](https://github.com/enyrhine/Opintonaattori/blob/master/dokumentaatio/sekvenssi2.png "Sekvenssikaavio")

###

![Alt text](https://github.com/enyrhine/Opintonaattori/blob/master/dokumentaatio/Sekvenssi_java.png "Sekvenssikaavio")

## Käyttöohje:
Uuden käyttäjän luonnin jälkeen, ohjelman avautuessa käyttöliittymän näkymä on tyhjä ja valmis uuden kurssin lisäystä varten. Lomakkeella pystyt lisäämään uuden kurssisuorituksen. Kurssisuorituksen tietoihin vaaditaan kurssin nimi, opintopisteiden määrä ja arvosana. Uuden suorituksen lisäyksen jälkeen näkymä päivittyy ja uusi suoritus tulee näkyviin. Näkymästä näet myös suoritettujen kurssien yhteenlasketut opintopisteet ja arvosanojen keskiarvot.
