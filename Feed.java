
import java.util.HashMap;
import java.util.Set;

/**
 * Clasa care gestioneaza fluxul de informatii despre stock-uri
 * si observatorii feed-ului.
 *
 * @author Nicolescu Daniel-Marian
 */
public class Feed {

    /**
     * Un HashMap in care este sunt pastrate valorile si numarul de aparitii
     * ale fiecarui stock in feed. Reprezinta un fel de log al feed-ului. 
     * Sunt pastrate doar informatiile relevante.
     */
    private final HashMap<String, FeedCommodity> feedCommodities;

    /**
     * Un HashMap in care sunt pastrati observatorii feed-ului.
     */
    private final HashMap<Integer, Observer> observers;

    public Feed() {
        this.feedCommodities = new HashMap<>();
        this.observers = new HashMap<>();
    }

    /**
     * Adauga un nou stock in HashMap sau doar il updateaza, apoi notifica
     * observatorii cu privire la schimbarea efectuata.
     *
     * @param name numele stock-ului
     * @param value valoarea acestuia
     */
    public void addCommodity(String name, double value) {
        if (this.feedCommodities.containsKey(name)) {
            this.feedCommodities.get(name).updateFeedCommodity(value);
            
        } else {
            this.feedCommodities.put(name, new FeedCommodity(name, value));
        }
        
        notifyObservers(this.feedCommodities.get(name));
    }

    /**
     * Adauga un observator nou si il notifica pe acesta cu privire la ce s-a
     * intamplat in feed inainte de crearea acestuia.
     *
     * @param id
     * @param observer
     */
    public void addObserver(int id, Observer observer) {
        this.observers.put(id, observer);
        
        observer.initialUpdate(this.feedCommodities); // initial update
    }

    /**
     * Sterge observatorul cu id-ul dat ca parametru.
     *
     * @param id
     */
    public void deleteObserver(int id) {
        this.observers.remove(id);
    }

    /**
     * Notifica toti observatorii in legatura cu stock-ul dat ca parametru.
     *
     * @param commodity
     */
    public void notifyObservers(Commodity commodity) {
        Set<Integer> keySet = this.observers.keySet();

        for (Integer key : keySet) {
            this.observers.get(key).update(commodity); // notify observers for new feed line
        }
    }

    /**
     * Afiseaza informatiile relevante pentru observatorul cu id-ul
     * dat ca parametru.
     *
     * @param id
     */
    public void print(int id) {
        this.observers.get(id).print();
    }
}
