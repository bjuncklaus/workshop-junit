package br.com.workshop.code;

public class Fibonacci {

	public int calculateSequence(int n)  {
		if (n == 0)
			return 0;
		else if(n == 1)
			return 1;
		else
			return calculateSequence(n - 1) + calculateSequence(n - 2);
	}

}
