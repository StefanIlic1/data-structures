import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;



/**
 * A program that implements the sieve of Eratosthenes.
*/
public class Sieve
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Compute primes up to which integer?");
        int n = in.nextInt();

        Set<Integer> nums = new HashSet<>();
        

        for (int i = 2; i <= n; i++) {
            nums.add(i);
        }
        
        for (int i = 2; i <= n; i++) {
            Iterator<Integer> it = nums.iterator();
            while (it.hasNext()) {
                int nextNum = it.next();
                if (nextNum%i==0 && nextNum!=i) {
                    it.remove();
                }
            }
        }

        for (Integer number : nums){
            System.out.println(number);
        }


    }
}
