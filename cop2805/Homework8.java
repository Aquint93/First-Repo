package cop2805;

class Recursive extends Thread {
	
	public static int fibonacci(int n) {
		if(n == 0)
			return 0;
		if(n == 1)
			return 1;
		return fibonacci(n-1) + fibonacci(n-2);
	}
	@Override
	public void run() {
		long before = System.currentTimeMillis();
		int answer = fibonacci(40);
		long time = System.currentTimeMillis() - before;
		
		System.out.println("Recursion Thread found the answer: "+answer+" in "+time+"ms");
	}
}

class Dynamic extends Thread {
	
	public static int fibonacci(int n) {
		int v1 = 0;
		int v2 = 1;
		int v3 = 0;
		
		for(int i = 2; i <= n; i++) {
			v3 = v1 + v2;
			v1 = v2;
			v2 = v3;
		}
		return v3;
	}
	@Override
	public void run() {
		long before = System.currentTimeMillis();
		int answer = fibonacci(40);
		long time = System.currentTimeMillis() - before;
		
		System.out.println("Dynamic Thread found the answer: "+ answer +" in "+time+"ms");
	}
}


public class Homework8 {
	
	public static void main(String[] args) {
		Dynamic d = new Dynamic();
		Recursive r = new Recursive();
		
		d.start();
		r.start();
	}
	
	
}
