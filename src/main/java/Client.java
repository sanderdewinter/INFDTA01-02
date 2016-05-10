import java.util.Vector;

public class Client {
    Vector<Integer> wine = new Vector<>();

    public Client(Vector<Integer> wine) {
        this.wine = wine;
    }

    public Client() {
        this.wine = new Vector<>();
    }

    public Vector<Integer> getWine() {
        return wine;
    }

    public void setWine(Vector<Integer> wine) {
        this.wine = wine;
    }
}
