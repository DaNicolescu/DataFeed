DataFeed  
	In main se creeaza instanta clasei FeedReder, i se seteaza un nou feed,
apoi se apeleaza metoda run.

FeedReader:
	Clasa FeedReader are ca atribut o instanta a clasei Feed. Metoda run
citeste datele (in cazul de fata de la System.in) si le transmite mai 
departe metodei private interpretCommand linie cu linie. Metoda 
interpretCommand parseaza Stringul primit ca parametru si apeleaza 
operatiile de actualizare a feed-ului, adauga sau sterge observatori si
afiseaza.

FeedCommodity:
	Clasa folosita de Feed pentru a pastra informatiile relevante despre
fiecare stock. Are ca atribute numele stock-ului, valoarea acestuia si numarul
de schimbari. 

Feed:
	Clasa Feed gestioneaza fluxul de informatii despre stock-uri. Are ca
atribute doua HashMap-uri. In primul sunt pastrate ultimele valori ale fiecarui
stock si numarul de schimbari pentru fiecare dintre acestea. Reprezinta un fel 
de log al feed-ului. Cheia pentru fiecare stock este reprezentata de nume.
In celalalt HashMap sunt pastrati observatorii feed-ului. Cheia fiecarui
observator in HashMap o reprezinta chiar id-ul.
	Metoda addCommodity actualizeaza HashMap-ul stock-urilor fie adaugand un 
stock nou, fie actualizand un stock deja existent, apoi notifica toti 
observatorii cu privire la modificare.
	Metoda addObserver adauga un observator nou in HashMap-ul de observatori,
apoi il notifica pe acesta cu privire la ce s-a intamplat in feed pana la
crearea acestuia.
	Metoda deleteObserver sterge observatorul cu id-ul dat ca parametru.
	Metoda print apeleaza metoda print corespunzatoare observatorului cu id-ul
dat ca parametru.

ObserverFactory:
	Metoda createObserver(int id, String filter) creeaza un observator (in
cazul de fata, un printObserver) ce are ca atribute id-ul primit ca parametru
si un arbore de expresie generat cu ajutorul clasei Rpn ce transforma expresia
infix data ca parametru intr-una postfix, ce este mai departe data unei
instante a clasei ExpressionTree ce construieste un arbore pornind de la acea
expresie.

Rpn:
	Clasa Singleton ce transforma o expresie infix intr-una postfix. Rezultatul
este scris intr-o coada.

ExpressionTree:
	 Creeaza un arbore de expresie pornind de la o expresie postfix. Are ca
atribut radacina arborelui generat. Nodurile corespunzatoare operatorilor sunt
create cu ajutorul clasei OperatorFactory.

OperatorFactory:
	Metoda createOperator(OperatorTypetype, Node left, Node right, String 
operand1, String operand2) creeaza un nod operator de tipul type, cu fiii
left si right, cu operandul 1 (name/value) operand1 si operandul 2 operand2.

ObservedCommodity:
	Clasa folosita de PrintObserver pentru a pastra informatii relevante
despre fiecare stock. Are ca atribute numele stock-ului, valoarea, fluctuatia
valorii dintre doua print-uri, vechea valoare printata, folosita pentru a
calcula fluctuatia si numarul de schimbari dintre doua print-uri. 

PrintObserver:
	Observer ce are ca atribute un TreeMap in care sunt pastrate informatii 
despre stock-uri, un arbore de expresie, un id si un visitor.
	Metoda update adauga stock-ul dat ca parametru in TreeMap, sau doar il
updateaza.
	Metoda initialUpdate este apelata imediat dupa crearea observatorului si
este folosita pentru a updata observatorul cu privire la ce s-a intamplat in
feed inainte de crearea lui.
	Metoda print se foloseste de visitor pentru a afisa doar stock-urile care
trec de filtru. Inainte de fiecare afisare se calculeaza fluctuatia pretului,
iar dupa afisare se reseteaza numarul de schimbari dintre doua print-uri si se
seteaza ultima valoare afisata cu valoarea curenta.

CheckVisitor:
	Visitor ce evalueaza un arbore de expresie.
	Metoda setCommodityToCheck seteaza stock-ul pentru care se va efectua
evaluarea.
	CheckVisitor parcurge arborele SDR.
