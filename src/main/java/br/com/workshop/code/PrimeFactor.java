package br.com.workshop.code;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactor {

	public int largestPrimeFactor(long number) {
		int i;

		for (i = 2; i <= number; i++) {
			if (number % i == 0) {
				number /= i;
				i--;
			}
		}

		return i;
	}

	public List<Integer> primeFactors(double number) {
		double n = number;
		List<Integer> factors = new ArrayList<Integer>();
		for (int i = 2; i <= n; i++) {
			while (n % i == 0) {
				factors.add(i);
				n /= i;
			}
		}
		return factors;
	}

}
