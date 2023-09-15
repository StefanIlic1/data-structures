import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This class supplies a utility method to reverse the entries in a linked list.
*/
public class ListUtil
{
    /**
     * Reverses the elements in a linked list
     *
     * @param strings the linked list to reverse
    */
    public static void reverse(LinkedList<String> strings)
    {
        ListIterator<String> it = strings.listIterator(); // starts from the start
        ListIterator<String> it2 = strings.listIterator(); // starts from the back

        int i = 0;
        int total = 0;

        while (it2.hasNext()) {
            it2.next();
            total++;
        }
        
        
        while (i<total/2) {
            String first = it.next();
            String last = it2.previous();
            String temp = first;
            it.set(last);
            it2.set(temp);
            i++;
        }
    }
}