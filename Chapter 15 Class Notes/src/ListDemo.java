import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This program demonstrates the LinkedList class
 * and ListIterator class.
*/
public class ListDemo
{
    public static void main(String[] args)
    {
        LinkedList<String> staff = new LinkedList<>();
        staff.addLast("Diana");
        staff.addLast("Harry");
        staff.addLast("Romeo");
        staff.addLast("Tom");
        // DHRT

        // | in the comments indicates the iterator position
        // listiterator method creates new list positioned at the heat of the list
        ListIterator<String> iterator = staff.listIterator();
        // |DHRT

        iterator.next(); // Advance to first entry
        // D|HRT

        // returns the element that the iterator passes
        String name = iterator.next(); // DH|RT

        // add method *for iterators* inserts an element at the iterator position, and moves the iterator past the new element
        iterator.add("Juliet"); // DHJ|RT
        iterator.add("Nina"); // DHJN|RT

        // remove method *for iterators* removes the last element returned by next or previous
        // remove method can only be called once per call of next or previous
        // remove method cannot be called after calling add

        iterator.next(); // DHJNR|T
        iterator.remove(); // DHJN|T

        // iterator set method updates the element returned by the last call to next or previous
        // set method cannot be called after calling add or remove
        iterator.previous(); // DHJ|NT
        iterator.set("Albert") ; // DHJ|AT

        // hasnext method checks if there is a next element
        // often used in the condition of a while loop
        iterator = staff.listIterator();
        while (iterator.hasNext()) {
            String n = iterator.next();
            if (n.equals("Juliet")) { //DHJ|AT
                iterator.remove();             // DH|AT
            }
        }
        // DHAT|

        // enhanced for loop
        for (String n : staff) {
            System.out.print(n + " ");
        }
        
        iterator = staff.listIterator();

        while (iterator.hasNext()) {
            String n = iterator.next();
            if (n.equals("Harry")) {
                // cannot modify another part of the list while iterating through it unless if you use the iterator to do it
                // concurrent modification exception
                // staff.remove("Diane");
            }
        }


    }
}
