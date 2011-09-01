package com.votaguz.random;

public class Mixed_Congruential {

	//Get all variables Seed (s), Module(m), Additive Constant(c), Multiplier (a), a prime Number (p). 
	public double[] Mixed_Congruential(int s, int m, int a, int c, int prime){
		
		//TODO define the size of array
		double[] _random = new double[m];
		if(validate(s, m, a, c, prime)){
			 _random = generate(s, m, a, c);
		}else{
			System.out.println("Existen valores que no cumplen con las reglas para la generacion de aleatorios");
			System.exit(0);
		}
		return _random; 
	}

	public double[] generate(int s, int m, int a, int c){
		double random[] = new double[m]; 
		int _s = s;
		for(int i=0; i < m; i++){
			_s = (a*s+c)%m;
			//Change the seed for the next iteration.
			random[i] = (double) _s /m ;
			s = _s;
		}
		return random;
	}
	
	public boolean validate(int s, int m, int a, int c, int prime){
		 return validateModuleIsGreater(s, m, a, c) &&
				validateNonNegativity(s, m, a, c) &&
				relativelyPrime(c, m) &&
				isDivisibleBy4(m, a) &&
				isDivisibleByPrime(m, a, prime);
	}

	//Validate module is greater than others
	public boolean validateModuleIsGreater(int s, int m, int a, int c){
		return m > a && m > s && m > c;	 
	}
	
	//Validation Non Negativity for all numbers 
	public boolean validateNonNegativity(int s, int m, int a, int c){
		return s > 0 && m > 0 && a > 0 && c > 0;
	}
	
	//Validation if a y c are realtivaly primes
	public boolean relativelyPrime(int a, int b){	
		return (a%b) != 0 && (b%a) != 0; 
	 
	}
	
	//The prime number is obtained from interface
	public boolean isDivisibleByPrime(int m, int a, int prime){
		int _prime = prime; 
		return ( m%_prime == 0) && ((a-1)%_prime == 0) ;
	}
	
	//Validate 5 rule, if m is divisible by 4 then a-1 too. 
	public boolean isDivisibleBy4(int m, int a){
		return ( m%4 == 0)  && ((a-1)%4 == 0) ;
	}
}
