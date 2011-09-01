package com.votaguz.util;

import JSci.maths.statistics.ChiSqrDistribution;

//TODO Create a ChiSquare Function
public class FrequencyTest {

	public boolean FrequencyTest(double[] random, int trusted, int interval){
		
		int _interval = interval;
		double _trusted = trusted/100.0;

		//give the interval for array
		int[] results = clasify(random,_interval);
		
		System.out.println("Frecuencia Observada: ");
		for(int i : results){
			System.out.println(results[i]);
		}
		double _hopeFreq = hopeFrequency(random, _interval);
		
		double _statisticalParameter = statisticalParameter(results, _hopeFreq);
		//Freedom Grades
		ChiSqrDistribution chi = new ChiSqrDistribution(results.length-1);
		double _chi = chi.inverse(_trusted);
		
		System.out.println("Frecuencia Esperada: "+ _hopeFreq);
		System.out.println("Estadistico de Prueba: "+ _statisticalParameter);
		System.out.println(_statisticalParameter + " < " +_chi);
		
		//Return True or False, For True : The random numbers come from uniform distribution. False: 
		return _statisticalParameter < _chi ;
			
	}
	
	//Clasificator for random numbers in variable interval
	public int[] clasify(double[] random, double interval ){
		
		int[] results = new int[(int) interval];

		for(double i : random){
			results[(int) (i*interval)]++;
			}
		
		return results;	
	}
	
	//Hope Frequency
	public double hopeFrequency(double[] random, double interval){
		return random.length/interval;
	}
	
	//Calculate the "Statistical Parameter" C
	 
	public int statisticalParameter(int[] results, double hopeFreq){
		double statisticalParameter = 0;
	
		for(int i=0; i<results.length; i++){		
			statisticalParameter += Math.pow((results[i] - hopeFreq),2)/hopeFreq;
		}
			
		return (int) statisticalParameter;
	}
	
	
}
