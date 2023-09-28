import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
    This program demonstrates a map that maps names to colors.
*/
public class MapDemo
{
    public static void main(String[] args)
    {
        // Create a map of names to colors
        Map<String, Color> favColors = new HashMap<>();

        // map interface is generic
        // first type is the key type
        // second type is the value type

        favColors.put("Hyder", Color.RED);
        favColors.put("Athena", Color.MAGENTA);
        favColors.put("Bavya", Color.BLUE);
        favColors.put("Mitchell", Color.RED);
        favColors.put("Athena", Color.ORANGE);

        // two keys can have the same value, but the same key cannot have two values
        System.out.println(favColors.get("Athena"));

        for (String key : favColors.keySet())
        {
            System.out.println(key + " (" + key.hashCode() + "): " + favColors.get(key));
        }
    }
}
