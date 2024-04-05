// Yousuf Ahmed
//LAB: 212 111F with Arianna Campbell

public class LinkedListIterator {

   private WordNode node;

   public LinkedListIterator(WordNode first) {
      node = first;
   }

   public boolean hasNext() {
      return (node != null);
   }

   public String next() {
      if (node == null)
         throw new NullPointerException("Linked list empty.");
      Word currentData = node.data;
      node = node.next;
      return currentData.getWord();
   }

}