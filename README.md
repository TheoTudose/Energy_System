# Proiect Energy System Etapa 2

## Despre

Proiectare Orientata pe Obiecte, Seriile CA, CD
2020-2021

<https://ocw.cs.pub.ro/courses/poo-ca-cd/teme/proiect/etapa2>

Student: Tudose Theodor-Mihai, 321CA

## Rulare teste

Clasa Test#main
  * ruleaza solutia pe testele din checker/, comparand rezultatele cu cele de referinta
  * ruleaza checkstyle

Detalii despre teste: checker/README

Biblioteci necesare pentru implementare:
* Jackson Core 
* Jackson Databind 
* Jackson Annotations

Tutorial Jackson JSON: 
<https://ocw.cs.pub.ro/courses/poo-ca-cd/laboratoare/tutorial-json-jackson>

[Puteti sa folositi si alte biblioteci si sa editati aceasta sectiune]

## Implementare

### Entitati

*Toate clasele din pachetul "input", mai puțin "DataRead" formează o ierarhie de liste pe modelul careia se face citirea din fișierele JSON a datelor de intrare.
*DataRead conține metodele prin care datele de intrare sunt copiate pe Listele de tipul claselor de lucru precum și metodele care actualizează datele lunar.
*Clasa ”Constants” conține 3 constante de tip int.
*Clasele ”GreenStrategy”, ”PriceStrategy” si ”QuantityStrategy” sunt clasele care conțin strategiile de sortare a producatorilor si toate implementează interfața ”Strategy”.
*Clasa ”Context” este clasa care execută strategiile.
*Clasa ”CostDetermination” are rolul de a determina costul.
*Clasa ”ChooseStrategy” sortează lista de producători in funcție de strategia Distribuitorului și returneaza costul.
*Clasa ”DistributorActions” contine o metoda de calcul pentru prețul contractului, metoda pentru reglarea conturilor distribuitorilor dupa ”plata” către cheluielilor
 lunare și una pentru calcularea costului de producție. Am ales să construiesc clasa astfel pentru o accesibilitate mai ușoară.
*Clasa ”EndGame” verifică dacă numarul distribuitorilor Bankrupt devine egal cu numărul total al distribuitorilor.
*Clasa ”FirstMonth” face tot ce ține de runda întâi.
*Clasa ”MonthStats” sorteaza lista de id-uri de distribuitori a fiecarui producator si o adauga intr-un obiect de tipul MonthlyStats, care la randul lui este adaugat in 
lista de MonthlyStats a producatorului.
*Clasa ”UpdateConsumerValues” se folosește de clasa ”Mods” pentru a calcula costurile consumatorilor si a plati catre distribuitor in situațiile în care consumatorul are 
deja un distribuitor sau nu are. Am ales să impart aceasă funcționalitate în doua clase pentru a rezolva o eroare de coding style.
*Clasa ”SortID” sortează crescător o listă de tip Integer.
*Clasa ”SortIDClass” sortează o listă de distribuitori, crescător, în funcție de ID.
*Clasa ”ChooseContract” sortează o listă de distribuitori, crescător, în funcție de prețul contractului fiecăruie si după ID.
Clasele din pachetul "work", mai puțin ”Simulator” reprezintă clasele de lucru.
Clasa ”Simulator” este clasa care rulează simularea.
Clasele din pachetul ”output” mai puțin ”DataWrite” formează o ierarhie de liste, pe modelul careia se face scrierea în fișierele JSON a datelor de ieșire.
Clasa ”DataWrite” este clasa care copiază datele din Listele de lucru, în listele de Output.




### Flow

*Se citesc datele de intrare.
*Pornește simulatorul, reprezentat de clasa ”Simulator”
*În runda 0: 
	*Distribuitorul își alege Producătorii
	*Se calculează costul și , in funcție de asta, costul de producție al fiecărui distribuitor.
	*Se calculeazî prfitul și prețul contractelor distribuitorilor, pentru cazul în care nu au nici un consumator.
	*Consumatorii își aleg fiecare un distribuitor, se creează contracte pentru pentu consumatori, în listele de contracte ale distribuitorilor.
	*Se verifică dacă consumatorul poate să platească contractul, contractul se plătește sau se creaza o datorie și se scade 1 din numarul de luni ramase in contract.
	*Distribuitorii isis platesc cheltuielile lunare si se verifica daca devine bankrupt.
*In celelalte runde:
	*Se actualizeaza datele distribuitorilor, daca exista actualizari pentru runda respectiva.
	*Se adauga consumatori noi, daca este cazul.
	*Se calculeaza pretul contractului, cu costul de productie din runda trecuta.
	*Se modifica valorile pentru consumatori. Daca contractul le-a expirat sau distribuitorul lor a dat faliment, acestia isi aleg un distribuitor.
 Se creaza contracte pentru ei la noul distribuitor.
	*Se verifica daca consumatorul poate sa plateasa contractul, daca da, il plateste, daca nu i se adauga 1 la lunile de restanta.
 Se verifica cate luni de restanta are. Daca are 0 luni restante, plateste pretul normal al contractului, daca are o luna restanta, se recalculeaza costul nou de plata si daca nu poate plati se mai adauga o luna de restanta.
La doua luni restante, consumatorul este declarat bankrupt si este scos din lista de contracte a distribuitorului precedent.
	*Distribuitorii isi platesc cheltuielile lunare si se verifica daca acestia au devenit bankrupt.
	*Se actualizeaza datele producatorilor, daca exista actualizari pentru runda respectiva.
	*Daca un producator a avut actualizari intr-o luna, toti distribuitorii isi cauta noi producatori.
	*Se recalculeaza costul de productie pentru fiecare distribuitor care si-a ales alti porducatori.
	*Se adauga la lista de monthlyStats a fiecarui producator, o lista cu luna si cu id-urile fiecarui distribuitor din acea luna.
	*Se verifica cati distribuitori sunt bankrupt. Daca toti distribuitorii sunt bankrupt, simularea se opreste.
*La finalul rundelor se scriu valorile de output in fisierul JSON.

### Elemente de design OOP

Am folosti Mostenirea, la crearea Strategiilor.

### Design patterns

Am folosit Strategy Pattern pentru diferentierea strategiilor de sortare folosite de distribuitori la alegerea producatorilor.
Am folosti Observer Pattern pentru ca un distribuitor sa observe cand producatorul sau isi schimba valorile intr-o luna, pentru a sti sa-si aleaga alti producatori.

### Dificultati intalnite, limitari, probleme

*Pentru a rezolva problema [MagicNumber] de checkstyle am creat clasa Constants.
*Am restructurat programul pentru a nu avea clase mai mare de 150 de linii.
*La Testul 12 am intampinat probleme la afisarea distribuitorilor pe care ii avea un producator in fiecare luna. In luna in care producatorul avea un distribuitor nou,
 toate valorile , pentru lunile precedente erau suprascrise cu id-ul acelui distribuitor. Am rezolvat prin copierea Listei de ID-uri de distribuitori.
*Testul Complex_5 nu functioneaza in totalitate la momentul scrierii acestui README.

[optional ## Feedback, comments
Tema foarte muncitoreasca. Am stat pe debugging mai mult de cat am stat sa scriu codul.

