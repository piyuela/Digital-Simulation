package com.votaguz.util;

import JSci.maths.statistics.ChiSqrDistribution;

public class IndependenceTest {

	public boolean IndependenceTest(double[] random, int trusted, int interval){
		
		int _interval = interval;
		double _trusted = trusted/100.0;
		
		//give the interval for array
		int[][] results = clasify(random, _interval);
		
		
		System.out.println("Frecuencia Observada: ");
		for(int i=0; i < results.length ; i++){
			for(int j=0; j < results.length ; j++){
			System.out.print(results[i][j]);
			}
			System.out.println();
		}
		double _hopeFreq = hopeFrequency(random, _interval);
		
		double _statisticalParameter = statisticalParameter(results, _hopeFreq);
		
		ChiSqrDistribution chi = new ChiSqrDistribution((_interval*_interval)-1);
		double _chi = chi.inverse(_trusted);
		
		System.out.println("Frecuencia Esperada: "+ _hopeFreq);
		System.out.println("Estadistico de Prueba: "+ _statisticalParameter);
		System.out.println(_statisticalParameter + " < " +_chi);
		
		//Return True or False, For True : The random numbers come from uniform distribution. False: 
		return _statisticalParameter < _chi;
		
	}
	
	//Clasify all random array elements in the Matrix.
	public int[][] clasify(double[] random, double interval){
		
		int[][] results = new int[(int) interval][(int) interval];
		int _x = 0;
		int _y = 0; 
		
		for( int i=0 ; i < random.length-1; i++){
			_x = (int) (random[i]*interval);
			_y = (int) (random[i+1]*interval);
			
			results[_x][_y]++;
		}
		return results;
	}
	
	//Hope Frequency
	public double hopeFrequency(double[] random, double interval){
		return (random.length-1)/(interval*interval);
	}
	
	//Statistical Parameter
	public int statisticalParameter(int[][] results, double hopeFreq){
		double statisticalParameter = 0;
	
		for(int i=0; i<results.length; i++){
			for(int j=0; j<results.length; j++){
				statisticalParameter += Math.pow((results[i][j] - hopeFreq),2)/hopeFreq;
			}
		}
			
		return (int) statisticalParameter;
	}

	
}
