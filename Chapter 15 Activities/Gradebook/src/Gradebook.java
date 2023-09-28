import java.util.Scanner;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
// imports
/**
 * A program to add, remove, modify or print
 * student names and grades.
*/
public class Gradebook
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        //
        Map<String, String> gradebook = new HashMap<>();

        boolean done = false;
        while(!done)
        {
            System.out.println("A)dd R)emove M)odify P)rint Q)uit");
            String input = in.next().toUpperCase();
            if (input.equals("Q"))
            {
                done = true;
            } else if (input.equals("A"))
            {
                // add a student and their grade
                System.out.println("Student name: ");
                String name = in.next();

                System.out.println("Student letter grade: ");
                String grade = in.next();

                // add the student and grade to the gradebook
                gradebook.put(name, grade);

                System.out.println();
            } else if (input.equals("R"))
            {
                // remove a student by grabbing their name
                System.out.println("Student name to remove: ");
                String name = in.next();


                gradebook.remove(name);

                System.out.println();
            } else if (input.equals("M"))
            {
                System.out.println("Student name to change grade: ");
                String name = in.next();


                System.out.println("New letter grade: ");
                String newGrade = in.next();


                gradebook.put(name, newGrade);

                System.out.println();
            } else if (input.equalsIgnoreCase("P"))
            {
                Set<String> keys = gradebook.keySet();
                for (String key : keys) {
                    System.out.println(key + " : " + gradebook.get(key));
                }

                System.out.println();
            } else
            {
                done = true;
            }
        }
    }
}
