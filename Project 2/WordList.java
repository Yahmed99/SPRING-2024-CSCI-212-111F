//Name: Yousuf Ahmed
//LAB: 212 111F with Arianna Campbell
public class WordList {
   protected WordNode first;
   protected WordNode last;
   protected int length;

   public WordList() {
      first = new WordNode(null);
      last = first;
      length = 0;
   }

   public void append(Word s) {
      WordNode n = new WordNode(s);
      last.next = n;
      last = n;
      length++;
   }

   public int getLength() {
      return length;
   }

   public LinkedListIterator reset() {
      return new LinkedListIterator(first.next);
   }
}
