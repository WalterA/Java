import java.util.HashMap;
public class Main {
	
	    private static HashMap<Integer, Integer> memoizationMap = new HashMap<>();
	    public static int fibonacci(int n) {
	        if (memoizationMap.containsKey(n)) {
	            return memoizationMap.get(n);
	        }

	        if (n == 0 || n == 1) {
	            memoizationMap.put(n, 1);
	            return 1;
	        }

	        int result = fibonacci(n - 1) + fibonacci(n - 2);
	        memoizationMap.put(n, result);
	        return result;
	    }

	    public static void main(String[] args) {
	        int n = 10;
	        System.out.println("F(" + n + ") = " + fibonacci(n));
	        
	        System.out.println("Valori memorizzati: " + memoizationMap);
	    }
	}

 	