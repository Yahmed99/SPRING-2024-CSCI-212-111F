//Name: Yousuf Ahmed
//LAB: 212 111F with Arianna Campbell
public class SortedWordList extends WordList {
    public SortedWordList() {
        super();
    }

    public void add(Word w) {
        if (length == 0) {
            append(w);
        } else {
            prepend(w.getWord());
        }
    }

    public void prepend(String d) {
        WordNode newNode = new WordNode(new Word(d));
        WordNode tempNode = first.next;

        int counter = 0;
        // Go through the list until either the input string is less than the tempNode
        // or the end of the list is reached
        while (tempNode != null && d.compareTo(tempNode.data.getWord()) > 0) {
            System.out.println("comparing " + d + " with " + tempNode.data.getWord());
            tempNode = tempNode.next;
            counter++;
        }
        WordNode p = first;
        // go through the list to find the node we have to insert before
        for (int j = 0; j < counter; j++) {
            p = p.next;
        }

        // Insert the new node before the current node p then set p to the previous
        // current node
        newNode.next = p.next;
        p.next = newNode;

        // Update the last node if newNode is inserted at the end
        if (tempNode == null) {
            last = newNode;
        }

        length++;
    }

}
