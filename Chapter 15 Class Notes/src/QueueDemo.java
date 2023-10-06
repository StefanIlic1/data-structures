import java.util.LinkedList;
import java.util.Queue;

/**
 * This program simulates a print queue. Note that documents are printed
 * in the same order as they are submitted.
*/
public class QueueDemo
{
    public static void main(String[] args)
    {
        Queue<String> jobs = new LinkedList<>();
        jobs.add("Steve: resume");
        jobs.add("Jane: letter to husband at war");
        jobs.add("Bill: homework");
        
        System.out.println("Printing... " + jobs.remove());

        jobs.add("Sally: grocery list");
        jobs.add("Joe: homework");

        System.out.println("Printing... " + jobs.remove());

        System.out.println();
        System.out.println("Printing all jobs in queue...");
        while(jobs.size()>0) {
            System.out.println(jobs.remove());
        }
    }
}
