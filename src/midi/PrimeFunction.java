package midi;

public class PrimeFunction implements Function{

	@Override
	public int getNthValue(int n) {
		for (int i=3;i<100000;i+=2) {
			if (isPrime(i)) {n--;}
			if (n==0) {
				return i;
			}
		}
		return 0;
	}
	
	
	private boolean isPrime(int input) {
		if (input%2==0)return false;
		for (int i=3;i*i<=input;i++) {
			if (input%i==0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		PrimeFunction function = new PrimeFunction();
		for (int i=1;i<200;i++) {
			System.out.println(function.getNthValue(i));
		}
	}

}
