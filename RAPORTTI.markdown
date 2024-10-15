# Raportit tehtävistä

Kirjaa tähän tiedostoon **jokaiseen** tehtävään liittyvät omat raporttisi ja analyysisi. Muista että raportti on myös kurssilla **arvosteltava tehtävä**.

Voit sisällyttää raporttiin tekstimuotoisia taulukoita (tasaukset välilyönnein):

```
n     Fill     Search   Total
500   7        700      707
1000  9        288      297
```

Ja näihin liittyviä kuvatiedostoja:

![Esimerkkikuva](report-sample-image.png)

Nämä näkyvät sitten VS Coden Preview -näkymässä (tai oman repositorysi webbisivulla) oikein muotoiltuna. Käytä tässä dokumentissa olevia muotoiluja esimerkkinä kun kirjoitat raporttiasi. 

Huomaa että jos laitat kuvatiedostot vaikka omaan alihakemistoonsa, Markdown -muotoilussa on oltava suhteellinen polku tiedostoon, esimerkiksi `images/report-sample-image.png`. **Älä** käytä absoluuttisia polkuja `C:\Users\tippaleipa\kurssit\TIRA\kuva.png`, koska nämä eivät tietenkään toimi opettajan koneella. Ei kannata laittaa linkkiä etärepoosikaan, vaan nimenomaan paikalliseen tiedostoon.

Voit myös sisällyttää *lyhyitä* koodinpätkiä vaikkapa Java -formaatilla:

```Java
	@Override
	public int hashCode() {
		// Oma nerokas hajautufunktioni!
	}
```
Tarvittaessa käytä myös paremmin muotoiltuja taulukoita:

| n	| Fill	| Search	| Total |
|-----|--------|--------|-------|
| 500	 | 7	| 700	| 707 |
| 1000 |	9	| 288	| 297 | 

Alaluvut jokaisen tehtävän raportille löydät alta.


## 01-TASK

Tehtävän aloittaminen oli suhteellisen vaikee, mutta sen jälkeen kun havainnollisti tehtävää paperille tehtävä helpottui. Etenkin miten elementit vaihtavat paikkaa ja miksi pitää olla väliaikainen muistipaikka yhdelle elementille. Esim vasen--> väliaikainen, sitten vasen --> oikea ja oikea ---> väliaikainen. Eli toisin sanoin logiikan ymmärtämiseen meni tovi, ja syntaxia piti opetella uudestaan. Piti katsoa esimerkiksi miten for ja while loopit kirjoittettiinkaan Javalla. Tehtävän toteuttamisjärjestys oli kuitenkin todella selkeä minulle. Tiesin, että ensin selvitän logiikan, sitten kirjoitan koodin ja lopuksi testaan. Reversealgoritmin logiikan miettiminen ja koodin kirjoittaminen sujui mutkitta. Oli jo helpompi hahmottaa logiikka, kun oli tehnyt ensimmäisen askeleen task 1 markdownista.

Aikakompleksisuus luokista:

Tehdään oletuksena, että meillä on "huonoin tapaus" eli kaikki alkiot ovat päin vastaisessa paikassa missä niiden kuuluisi olla. esim. [3, 2 ,1].
Lajittelualgoritmihan toimii siten, että se aloittaa ensimmäisestä indeksistä ja katsoo seuraavaan ja vertaa onko seuraava isompi. Jos on, niin se siirtää nykyisen seuraavan paikalle ja seuraavan nykyisen paikalle. Jos on 7 pitkä lista, jossa kaikki ovat oletuksen mukaisessa paikassa (huonoin tilanne), niin siirtoja on ![Kuva](kuva-7-summa.png)
Kuvaaja: ![Kuvaaja](kuvaaja.png) 

Voimme havainnollistamisesta huomata, että aikakompleksisuus on exponentiaalinen koska kuvaajalla ei esiinny suoraa.

Reverse -algoritmin tein siten, että vaihdoin vain aina vasemmanpointterin ja oikean pointterin paikkaa vastaikkain joka kierroksella. Eli joka kierroksella tulee kaksi siirtoa, ja voimme huomata, että kun kasvatetaan jonoa niin siirtojen määrä, muuttuu lineaarisesti jononpituuteen verrattuna.

Tilanteessa, jossa taulukko on jo valmiiksi nousevassa järjestyksessä, ja se aiottaan laskevaan järjestykseen Reverse -algoritmi on parempi. Koska jos pituutta lisätään vaikka 200 niin siirtojen määrä on 400, mutta Lajittelualgoritmilla siirtojen määrä olisi 20 100. Eli 20 kertaa enemmän siirtoja kuin Reverse -algoritmilla.

## 02-TASK
Tehtävän tekeminen oli opettavainen kokemus, jossa oppi paljon sekä ohjelmoinnista että algoritmien toiminnasta. Erityisesti sain syvempää ymmärrystä siitä, miten erilaiset lajittelu- ja hakualgoritmit toimivat ja miten niitä voidaan hyödyntää käytännön sovelluksissa.

Vaikeinta oli ymmärtää lajittelu- ja hakualgoritmien logiikka ja miten aikakompleksisuus vaihtelee tiedostojen koon ja järjestyksen mukaan.

Suoritusajan analyysi:

Nopeat ja hitaita tilanteita

Nopeat tilanteet johtuu siitä, että data on lajiteltu tai sitten käytetään tehokasta algoritmia.

Hitaat tilanteet johtuvat huonosti järjestetyistä datoista ja huonoista algoritmeistä.

Jos aineisto on valmiiksi lajiteltuna ja haluat vaihtaa alkioiden järjestyksen päinvastaiseksi, käytän mieluummin reverse-algoritmia. Tämä johtuu siitä, että käänteinen järjestys voidaan saavuttaa O(n) aikakompleksisuudella, kun taas lajittelu vie O(n log n) aikaa.

Toteutettuja hakualgoritmeja, kuten get ja indexOf kutsutaan lineaarisiksi, koska ne käyvät läpi taulukon alkiot yksi kerrallaan. Eli ne vertaavat joka elementtiä hakuehtoon, mikä tekee niiden aikakompleksisuus luoksata O(n):n. Eli suoritusaika kasvaa lineaarisesti datan koon kanssa.

 ![Kuvaaja2](kuvaaja3.png)
## 03-TASK
![Kuvaaja3](Kuvaaja4.png)

Kuvasta ilmenee selvästi, että täyttöaika kasvaa lineaarisesti koon n kasvaessa eli sen aikakompleksisuusluokka on O(n). Lajitteluaika kasvaa myös syötteen koon kasvaessa, mutta nopeammin kuin lineaarisesti. Lajitteluaika noudattaa O(n log n) aikakompleksisuutta. Hakuaika suoritusajat ovat huomattavasti pienempiä kuin lahittelussa, koska binäärihaun aikakompleksiuus on O(log n).


## 04-TASK

## 05-TASK

## 06-TASK

## 07-TASK

## 08-TASK

## 09-TASK