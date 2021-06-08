package midi;

import java.util.ArrayList;
import java.util.List;

public class TwinPrimeGapGaps implements Function {

	private final static List<Integer> twinPrimeStarts = new ArrayList<>();
	
	@Override
	public int getNthValue(int n) {
		if (n>=twinPrimeStarts.size()) {
			return 0;
		}
		int firstBase = twinPrimeStarts.get(n);
		int secondBase = twinPrimeStarts.get(n+1);
		return (secondBase-firstBase)/6;
	}
	
	public TwinPrimeGapGaps() {
		for (int i=3;i<=100000;i+=2) {
			if (isStartOfTwinPrime(i)) {
				twinPrimeStarts.add(i);
			}
		}
	}
	
	/**
	 * Give the first number n of a twin prime pair,
	 * return the gap between n and the previous first prime of
	 * a twin prime pair.
	 */
	private int getGapBetweenLastTwinPrime(int n) {
		if (n<=3) {return 1;}
		for (int i=n-2;n>=3;n-=2) {
			if (isStartOfTwinPrime(i)) {
				return (n-i)/2;
			}
		}
		return 1;
	}
	
	private boolean isStartOfTwinPrime(int n) {
		if (n<2)return false;
		if (isPrime(n) && isPrime(n+2)) {
			return true;
		}
		return false;
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
		Function f = new TwinPrimeGapGaps();
		
		for (int i=1;i<500;i++) {
			System.out.println(f.getNthValue(i));
		}
	}
	
}
