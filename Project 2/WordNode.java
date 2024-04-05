//Name: Yousuf Ahmed
//LAB: 212 111F with Arianna Campbell
public class WordNode {
    protected Word data;
    protected WordNode next;

    // Constructor with a Word argument
    public WordNode(Word w) {
        this.data = w;
        this.next = null;
    }

    // Constructor with a Word and a WordNode argument
    public WordNode(Word w, WordNode n) {
        this.data = w;
        this.next = n;
    }

    // Default constructor
    public WordNode() {
        this.data = null;
        this.next = null;
    }
}
