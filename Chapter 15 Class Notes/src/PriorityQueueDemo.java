import java.util.PriorityQueue;
import java.util.Queue;


/**
 * This program demonstrates a priority queue of to-do items. The
 * most important to-do items are removed first.
*/
public class PriorityQueueDemo
{
    public static void main(String[] args)
    {
        // to do list
        // a workorder has a message id that is used to determine priority
        // priorityqueue can only stote comparable objects
        Queue<WorkOrder> todo = new PriorityQueue<>();

        todo.add(new WorkOrder(3, "water plants"));
        todo.add(new WorkOrder(1, "homework"));
        todo.add(new WorkOrder(2, "feed dog"));
        todo.add(new WorkOrder(1, "feed cat"));
        todo.add(new WorkOrder(9, "pay bills"));

        System.out.println(todo);

        while (todo.size() > 0)
        {
            System.out.println(todo.remove());
        }
        

    }
}
