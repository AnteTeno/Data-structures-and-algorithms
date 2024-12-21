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
Tässä tehtävässä opin paljon pinojen toimminnasta ja niiden toteutuksesta koodissa. Opin, miten pinon perustoiminnot toteuteetaan ja implementoidaan kuten push ja pop. Lisäksi harjoittelin aikakompleksisuudien analysointia ja ymmärsin vaatimukset, kuten esimerkiksi O(1) aikavaativuuden.

Helpoin osa oli StackImplementation osio, jossa tehtiin pinon perustoimia. Metodit oli helppo tehdä hyvien ohjeiden myötä. ParenthesisChecker oli hankalampi toteuttaa, koska tehtävä vaati ymmärrystä ongelmasta sekä siitä miten pinoja voidaan hyödyntää tässä ongelmassa.

Tehtävässä oli erityisen tärkeää varmistaa, että kaikkien pinoon liittyvien toimintojen aikakompleksisuus täyttää annetut vaatimukset. Tämän takia analysoin jokaisen algoritmin erikseen:

1. Push toteutuksessa lisätään uusi alkio pinon päälle. Kopioidaan siis itemArray- taulukkoon alkiot ja jos se täyttyy, niin kutsutaan reallocatea. Reallocate on O(n), mutta push on ilman sitä O(1).
2. Pop toteutuksessa poistetaan pinon ensimmäinen eli ylin alkio. Eli asetetaan ylin alkio nulliksi ja vähennetään laskurista, joka laskee pinon alkioiden määrän. Tämän aika kompleksisuus on O(1).
3. Peek "kurkistaa" pinon päällimäistä arvoa eli palauttaa sen. O(1)
4. IsEmpty tarkistaa onko pino tyhjä. Tarkistetaan laskuri tai pinon ensimmäinen arvo. Aikakompleksiuus on siis O(1).
5. Clear tyhjentää pinon laittamalla uuden tyhjän taulukon ja tyhjentämällä laskurin "count". Aikakompleksisuus on siis O(1).

ParenthesisCheckerin sulkujen tarkastamiseen on silmukka, joka iteroi merkkijononläpi. Silmukan takia aikakompleksuus on O(n), n riippuu merkkijonon pituudesta. StackImplementation funktiot joita tässä käytetään (push ja pop) ovat aikakompleksisuudelta O(1) ja apufunktio, joka tarkistaa ovatko sulut pareja on myös O(1).


## 05-TASK
Linkitetyn listan perustoimintojen, kuten enqueue ja dequeue oli suhteellisen helppoa ja suoraviivaista. Myös muut metodit kuten isEmpty ja size olivat erittäin yksinkertaisia ja helppoja toteuttaa.
Linkittetty lista muistikompleksisuus on hyvä. Se käyttää vain muistia tarvittavalle määrälle alkioita, koska solmut luodaan dynaamisesti. Ei ole tarvetta varata suurta määrää tilaa etukäteen. Huono puoli on että jokainen solmu sisältää pointterin seuraavaan solmuun, joka lisää muistin käyttöä. Aikakompleksisuus on myös hyvä, sillä enqueue ja dequeue aikakompleksisuusluokka on O(1)n koska ne lisäävät ja poistavat alkion listan alusta tai lopusta. Huonoa on satunnaishaku, jonka luokitus on O(n), koska iteroidaan koko lista läpi haluttuun indeksiin. 

Linkitetty listan vasta vertailuksi taulukko pohjaisessa hyvät puolet: Ei tarvita lisämuistia viitteille, enqueue ja dequeue ovat O(1), paitsi kun taulukkoa on laajennattava reallocationilla. Huonot puolet: Taulukko on varattava kiinteän kokoisena tai laajennattavana, eli käytössä voi olla turha muistia jos taulukkoon on varattu liikaa suhteessa tarpeeseen. Myös uudelleen asettelun aikakompleksisuusluokitus on O(n).

Aikakompleksisuusluokat linkitetyn listan toteutuksessa:
enqueue: Normaalisti O(1), mutta uudelleenasettelussa O(n).
dequeue: O(1), koska vain yksi alkio poistetaan.
element: O(1), koska palautetaan suoraan viite pään alkiolle.
isEmpty ja size: Molemmat O(1), koska ne vain tarkastaa ja eivät käytännlssä tee mitään taulukolle.


## 06-TASK
Tehtävän tekeminen auttoi ymmärtään lajittelualgoritmeista enemmän ja opin myös niiden toimintaperiaatteeista. Myös opin tehokkuudesta eri algoritimien välillä paljon. Opin miten Quicksort toimii ja miksi sen
suorituskyky riippuu pivotista. Opin myös aikakompleksisuuden analysoinnista ja sekä graafisesta visualisoinnista. Vaikeaa oli testitulosten analysointi suurilla aineistolla. Siinä kestää kauan ja on haastavaa tulkita, miten algoritmin ominaisuudet kuten rekursiivisuus vaikuttaa sen suorituskykyyn ja graafien tuottaminen oikein on myös hankalaa. Helppoa oli testien ajaminen ja vertailu. 

Testitulosten analyysi

CoderSlowComparatorTests mittaa perinteisen lisäyslajittelun suorituskykyä, jonka aikakompleksisuusluokka on O(n^2). CoderFastComparatorTests testaa Quicksorttia, jonka aikakompleksisuusluokitus on O(n log n). Alla kuva:

![Kuvaaja4](task6.png)

Kuvista huomaa että 50 000 aineiston kohalla hidas algoritmi alkaa jäämään jälkeen Quicksorttiin verrattuna. 100 000 aineiston kohdalla ero on jo huomattava, kun Quicksortilla menee hiukan alle 200ms lajittelussa niin hitaalla algoritmilla menee 500 000 tuhatta ja risat. Testit vahvistavat, että quicksort toimii oikein ja huomattavasti tehokkaammin kuin perus lisäyslajittelun. Lisäyslajittelun aikakompleksisuus per elementti kasvaa exponentiaalisesti, kun taas Quicksortilla se kasvaa tasaisemmin muttei kuitenkaan lineaarisesti.



## 07-TASK
Tämän tehtävän aikana opin paljon etenkin BST:n rakenteen ja sen perustoiminnoiusta, BST:n perustoimintojen, kuten lisäyksen ja haun toteuttaminen syvensi ymmärrystäni rekursiivisista algoritmeistä ja opin uuden tietorakenteen. Syvydeen hallint ja se tasapainoitus oli keskeistä myös. Vaikeuksia aiheuttikin tasapainotuksen puute ja rekursiivisten ratkaisujen tehokkuus. On hankala toteuttaa monimutkaisia metodeja rekursiivisesti. Helppoa oli BST:n perusoperaatiot esimerkiksi lisäys ja haku.

Testit ja niiden analysointi:

Testituloksista ilmeni, että BST ja SimpleContainer toimivat odotetusti. BST:n lisäys ja hakutoiminnot suoritettiin seuraavasti:
![Kuvaaja7](task7.png)

Graafeista huomaa, että SimpleContainerin suorituskyky oli pienillä aineistoilla lähes identtinen BST:n kanssa, mutta isompien aineistojen kohdalla BST osoitti selvästi parempaa suorituskykyä haussa, mikä vastaa teoriaa, kun SimpleContainerin haku oli O(n), joka on hitaampi suuremmalla aineistolla. Aineiston perusteellä BST:n lisäyksen ja haun aikakompleksisuus on keskimäärin O(log n) ja pahimmillaan O(n).

TIRA Coders käyttöliittymä oli intuitiivinen ja antoi selkeäb kuvan mittausten onnistumisista. 

Syvyydestä huomasin sen verran testidatan avulla, että 100 kohteella puun syvyys on keskimäärin 7 ja 1000 kohteella 10. Toteutukseni maksimisyvyys poikkesi hieman ihanteesta, koska puu ei ole täydellisesti tasapainoinen. Esimerkiksi 100 kohteella maksimisyvyys oli 9 ja 1000 14.
## 08-TASK
Opin tämän tehtävän aikana hajautustaulun eli hashtablen toteutuksesta. Sen toteutuksessa erityisesti tärkeitä oli kolarinhallinta ja hajautustaulun dynaaminen laajentaminen datan kasvaessa eli metodi reallocate().
Hajautustaulut ovat erinomaisia haussa ja avainperusteisessa haussa. Siinä on vakio O(1) aikakompleksisuus, kuten get()- metodissa havaitaan. Lajittelut ovat hajautustaulussa tehottomampia verrattuna BST:hen, koska hajautustaulut eivät ole luonnostaan järjestyksessä.

Suorituskyky mittaukset:
![Kuvaaja8](task8.png)

Graafeista näkyy, että hajautustaulun operaatiot skaalautuvat lineaarisesti, paitsi laajennuksen aikana. SimpleKeyedContaineri toiminnassa voi havaita tehottomuutta ja todennäköisesti kolarinhallinnan tai reallocaten heikkouksien takia. 

Aikakompleksisuuksista:
Hajatustaulu näyttää vakion aikakompleksisuudeen lisäykselle ja haulle O(1), hajautustaulun lajittelu vaatii, kun BST säilyttää luonnolisen järjestyksen, joka tekee sen hakutoiminnoista tehokkaita jopa suurilla aineistoilla.

Haasteita oli kolarinhallinnassa, dynaamisessa laajennuksessa ja HashCode metodissa. Helppoa oli get ja find metodien koodaaminen, koska se oli suoraviivaista ja edellytti vain avainten vertailua. 
## 09-TASK