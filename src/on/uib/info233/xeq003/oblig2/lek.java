package on.uib.info233.xeq003.oblig2;

public class lek {

	private Bag<String> baggy = new Bag<String>();
	
	public static void main(String[] args) {
		//lek test = new lek();
		String s = "abcdefg";
		//writeBackwards(s);
		//System.out.println(fibonacchi(5));
		int test = (9/2);
		System.out.println(test);
		foo();
	}
	
	private static void print(String x) {
		System.out.println(x);
	}
	
	private static void writeBackwards(String s) {
		
		if(s.length() == 0){
			
		}else {
			System.out.println("recursing");
			writeBackwards(s.substring(1, s.length()));
			System.out.println(s.charAt(0));
		}
	}
	
	private static void foo() {
		for (int i = 0; i < 2*7; i += 2) { 
			System.out.println("outer, i=" + i);
		    for (int j = 7; j > i; j--) {    	// 2
		        System.out.println("inner, j=" + j);      // 3
		    }
		}
	}
	
	public static int fibonacchi (int n) 
	{ 
		print("hey");
		if (n == 0 || n == 1) return 1;
		else return fibonacchi(n-1)+fibonacchi(n-2);
	}
}
