
/**
 *
 * @author Nicolescu Daniel-Marian
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creeaza instanta clasei FeedReader
        FeedReader reader = FeedReader.getInstance();
        // ii seteaza un nou Feed
        reader.setNewFeed();

        reader.run();
    }

}
