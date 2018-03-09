
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Nicolescu Daniel-Marian
 */
public class Builder {

    private Feed feed;
    private static Builder instance;

    private Builder() {

    }

    public static Builder getInstance() {
        if (instance == null) {
            instance = new Builder();
        }

        return instance;
    }

    public void setNewFeed() {
        this.feed = new Feed();
    }

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        try {
            reader.readLine();

            while (true) {
                line = reader.readLine();
                if (line.equals("end")) {
                    break;
                }

                parse(line);
            }
        } catch (IOException e) {
            System.out.println("Error trying to read data");
        }
    }

    private void parse(String line) {
        String firstWord = line.split(" ")[0];

        switch (firstWord) {
            case "feed":
                String name = line.split(" ")[1];
                double value = Double.parseDouble(line.split(" ")[2]);
                this.feed.addCommodity(name, value);
                break;
            case "create_obs": {
                String stringId = line.split(" ")[1];
                String filter = line.substring(12 + stringId.length());
                int id = Integer.parseInt(stringId);
                Observer observer = ObserverFactory.CreateObserver(id, filter);
                this.feed.addObserver(id, observer);
                break;
            }
            case "delete_obs": {
                int id = Integer.parseInt(line.split(" ")[1]);
                this.feed.deleteObserver(id);
                break;
            }
            case "print": {
                int id = Integer.parseInt(line.split(" ")[1]);
                this.feed.print(id);
                break;
            }
            default:
                break;
        }

    }

}
