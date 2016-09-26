import java.util.ArrayList;

/**
 * Created by Shaun on 9/3/2016.
 */
public class Sieve {

    public static ArrayList<Integer> getPrime(int upperbound){
        int[] track = new int[upperbound+1];
        ArrayList<Integer> result = new ArrayList<>();

        if(upperbound <= 1) return result;
        // initialize
        track[1] = 1;
	result.add(2);
        // use 2 to skip plural
        for(int i = 1; i <= upperbound; i = i + 2){
            if(track[i] == 0){
				
                // i is a prime, add i to the list
                result.add(i);
                for(int j = 1; i*j <= upperbound; j++) track[i*j] = 1;
            }
        }
        System.out.print("Total: " + result.size());

        return result;
    }

    public static void main(String[] args){
        getPrime(1);
    }
}
