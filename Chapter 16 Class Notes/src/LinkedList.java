import java.util.NoSuchElementException;

/**
 * A linked list is a sequence of nodes with efficient
 * element insertion and removal. This class
 * contains a subset of the methods of the standard
 * java.util.LinkedList class.
*/
public class LinkedList
{
    private Node first;

    /**
        Constructs an empty linked list.
    */
    public LinkedList() {
        first = null;
    }



    /**
        Returns the first element in the linked list.
        @return the first element in the linked list
    */
    public Object getFirst() {
        if (this.first == null) {
            throw new NoSuchElementException();
        }
        return this.first.data;
    }


    /**
        Removes the first element in the linked list.
        @return the removed element
    */
    public Object removeFirst() {
        if (this.first == null) {
            throw new NoSuchElementException();
        }
        Object oldData = this.first.data;
        this.first = this.first.next;
        return oldData;
    }


    /**
        Adds an element to the front of the linked list.
        @param element the element to add
    */
    public void addFirst(Object newData) {
        Node newFirst = new Node();
        newFirst.data = newData;
        newFirst.next = this.first;
        this.first = newFirst;
    }


    /**
        Returns an iterator for iterating through this list.
        @return an iterator for iterating through this list
    */
    public ListIterator listIterator() {
        return new LinkedListIterator();
    }


    //Class Node
    static class Node
    {
        public Object data;
        public Node next;


    }


    class LinkedListIterator implements ListIterator
    {
      //private data
        private Node position;
        private Node previous;
        private boolean isAfterNext;

        /**
            Constructs an iterator that points to the front
            of the linked list.
        */
        public LinkedListIterator() {
            position = null;
            previous = null;
            isAfterNext = false;
        }


        /**
            Moves the iterator past the next element.
            @return the traversed element
        */
        public Object next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }

            this.previous = position;
            this.isAfterNext = true;

            // if position is null then it means that it is at the start (just initialized)
            if (position == null) {
                position = first;
            } else {
                position = position.next;
            }

            return position.data;
        }


        /**
            Tests if there is an element after the iterator position.
            @return true if there is an element after the iterator position
        */
        public boolean hasNext() {
            if (position == null) {
                return first != null;
            }
            return position.next != null;
        }

        /**
            Adds an element before the iterator position
            and moves the iterator past the inserted element.
            @param element the element to add
        */
        public void add(Object o) {
            // check if iterator is at the start of the list
            if (position == null) {
                addFirst(o);
                position = first;
            } else {
                Node newAdd = new Node();
                newAdd.data = o;
                newAdd.next = position.next;
                position.next = newAdd;
                position = newAdd;
            }

            this.isAfterNext = false;
        }

        /**
            Removes the last traversed element. This method may
            only be called after a call to the next() method.
        */
        public void remove() {
            if (position == null) {
                throw new NoSuchElementException();
            } else if (!isAfterNext) {
                throw new IllegalStateException();
            }

            if (position == first) {
                removeFirst();
                position = null;
            } else {
                previous.next = position.next;
                position = previous;
            }

            this.isAfterNext = false;
        }

        /**
            Sets the last traversed element to a different value.
            @param element the element to set
        */
        public void set(Object o) {
            if (!isAfterNext) {
                throw new IllegalStateException();
            }

            position.data = o;
        }


    }//LinkedListIterator
}//LinkedList
