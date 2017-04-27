## Aihe: 
Opintojen seurantajärjestelmä, jonka avulla opiskelija pystyy seuraamaan opiskelujensa etenemistä lisäämällä kursseja kandi- tai maisterivaiheeseen, tarkastelemaan opintopisteitään sekä näkemään suoritettujen kurssien arvosanat.

### Opiskelijan toiminnot: 
kurssin ja sen tietojen lisäys

### Luokkakaavio
![Alt text](https://github.com/enyrhine/Opintonaattori/blob/master/dokumentaatio/Java_luokkakaavio2.png "Luokkakaavio")

## Rakennekuvaus:
Kayttaja-luokka on yhteydessä kaikkiin muihin luokkiin. Niissä luetaan käyttäjän tiedostoa ja tehdään siihen muutoksia.
Tiedostojen hallinta tapahtuu Rapottikone ja Tallentaja -luokissa, joissa tiedoston lukemista ja tallennusta vaativat metodit sijaitsevat. Käyttöliittymä luo ohjelman, jolla käyttäjä näkee omat kurssisuorituksensa ja pystyy lisäämään nappia painamalla uuden kurssisuorituksen tiedostoonsa. Kurssisuoritus -luokka pitää sisällään kurssisuorituksen tiedot: nimen. opintopistemäärän ja arvosanan, sen avulla pystyy luomaan käyttäjälle uuden kurssisuoritusolion.

### Sekvenssikaavio
![Alt text](https://github.com/enyrhine/Opintonaattori/blob/master/dokumentaatio/Sekvenssi_java.png "Sekvenssikaavio")

## Käyttöohje:
Uuden käyttäjän luonnin jälkeen, ohjelman avautuessa käyttöliittymän näkymä on tyhjä, siinä voit lisätä uuden kurssisuorituksen, joka tulee heti näkyviin uuteen ikkunaan. Näkymästä näet myös suoritettujen kurssien opintopisteet ja arvosanojen keskiarvot.
