package com.votaguz.random;


//TODO calculate the period
public class Multiplicative_Congruential {

	public double[] Multiplicative_Congruential(int s, int m, int a){
		
		double[] _random = new double[m/4];
		if(validate(s, m, a)){
			_random = generate(s, m, a);
		}else{
			System.out.println("Existen valores que no cumplen con las reglas para la generacion de aleatorios");
			System.exit(0);
		}
		return _random;
	}
	
	public boolean validate(int s, int m, int a){
		
		return 	validateModuleIsGreater(s, m, a) &&
				validateNonNegativity(s, m, a) &&
				relativelyPrime(s, m);
	}
	
	public double[] generate(int s, int m, int a){
		double random[] = new double[m/4];
		int _s = s;
		for(int i=0; i< m/4; i++){
			_s = (a*s)%m;
			random[i] = (double) _s/m;
			s = _s;
		}
		return random;
	}
	
	
	//Validate module is greater than others
	public boolean validateModuleIsGreater(int s, int m, int a){
		return m > a && m > s;
	}
	
	//Validation Non Negativity for all numbers 
	public boolean validateNonNegativity(int s, int m, int a){
		return s > 0 && m > 0 && a > 0;
	}
	
	//Validation if s y m are realtivaly primes
	public boolean relativelyPrime(int a, int b){
		return (a%b) != 0 && (b%a) != 0;
	}
	
	
	//Validation if a = 8t +- 3
	// Value of t, come from the View 	
	public boolean validateA(int a, int t){
		 return a == (8*t+3) || a == (8*t-3);
	 }
	
	public boolean validateM(int m){
		return m == (2^generateD(m)) && m == (2^generateD(m)-2); 
	}
	
	public int generateD(int m){
		int d = 0;
		int product = 2;
		while(product <= m){
			product = product*2;
			d++;
		}
		return d;
	}
}
