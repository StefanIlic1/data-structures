import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
 * Write a program that checks whether a sequence of HTML tags
 * is properly nested. For each opening tag, such as <p>, there
 * must be a closing tag </p>. A tag such as <p> may have other
 * tags inside, for example <p> <ul> <li> </li> </ul> <a> </a> </p>
 * <p>
 * The inner tags must be closed before the outer ones.
 * Your program should process a file containing tags.
 * For simplicity, assume that the tags are separated by
 * spaces, and that there is no text inside the tags.
*/
public class HTMLChecker
{
    public static void main(String[] args)
    {
        String filename = "Chapter 15 Activities/HTMLChecker/src/TagSample1.html";

        try (Scanner in = new Scanner(new File(filename)))
        {
            // Your code goes here
            Stack<String> stack = new Stack<>();
            boolean check = true;
            while (in.hasNext()) {
                String tag = in.next();
                if (!tag.contains("/")) {
                    stack.push(tag);
                } else {
                    // if tag is matching without the slash
                    if (stack.peek().substring(1).equals(tag.substring(2))) {
                        stack.pop();
                    } else {
                        check = false;
                        break;
                    }
                }
                System.out.println(stack);
            }
            
            if (check) {
                System.out.println("HTML tags are in order");
            } else {
                System.out.println("HTML tags are out of order");
            }


        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }

    }
}
