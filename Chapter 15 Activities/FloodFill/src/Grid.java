import java.util.Stack;

public class Grid
{
    private static final int SIZE = 10;
    int[][] pixels = new int[SIZE][SIZE];
    Stack<Pair> stack = new Stack<>();

    /**
     * Flood fill, starting with the given row and column.
    */
    public void floodfill(int row, int column)
    {
        Pair p = new Pair (row, column);
        stack.push(p);

        Pair current = stack.peek();
        int r = current.getY();
        int c = current.getX();
        pixels[c][r] = 1;
        int counter = 2;
        while (!stack.isEmpty()) {
            current = stack.pop();
            r = current.getY();
            c = current.getX();
            
            // try to go north, then east, then south, then west
            if (c > 0 && pixels[c-1][r] == 0) {
                pixels[c-1][r] = counter;
                stack.push(new Pair(c-1, r));
            } else if (r < SIZE-1 && pixels[c][r+1] == 0) {
                pixels[c][r+1] = counter;
                stack.push(new Pair(c, r+1));
            } else if (c < SIZE-1 && pixels[c+1][r] == 0) {
                pixels[c+1][r] = counter;
                stack.push(new Pair(c+1, r));
            } else if (r > 0 && pixels[c][r-1] == 0) {
                pixels[c][r-1] = counter;
                stack.push(new Pair(c, r-1));
            }
            counter++;
        }
    }


    @Override
    public String toString()
    {
        String r = "";
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
                r = r + String.format("%4d", pixels[i][j]);
            r = r + "\n";
        }
        return r;
    }
}