import java.util.Stack;

/**
 * This program simulates an undo stack. Note that operations
 * must be undone in the opposite order in which they are first
 * issued.
*/
public class StackDemo
{
    public static void main(String[] args)
    {
        Stack<String> commands = new Stack<>(); // do not have to specify size for stack
        commands.push("Insert: 'hello'");
        commands.push("Insert: ','");
        commands.push("Insert: ' '");
        commands.push("Insert: 'world'");
        commands.push("Insert: '?'");
        commands.push("Delete: '?'");
        commands.push("Insert: '!'");

        // simulate user pressing undo 4 times
        for (int i = 0; i < 4; i++)
        {
            
            String command = commands.pop();
            System.out.println("Undo: " + command);
        }

        System.out.println(commands);
    }
}
