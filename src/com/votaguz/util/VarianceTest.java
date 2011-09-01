package com.votaguz.util;

import JSci.maths.statistics.ChiSqrDistribution;

public class VarianceTest {
	
	public boolean VarianceTest(int trusted, double[] random){
		
		double _trusted = trusted/100.0;
		double _statisticalParameter = statisticalParameter(random);
		ChiSqrDistribution chi = new ChiSqrDistribution(random.length-1);
		double _chi = chi.inverse(_trusted);
		
		System.out.println(_statisticalParameter + "<" + _chi);
		
		return _statisticalParameter < _chi; 
	}

	
	public double statisticalParameter(double[] random ){	
		double variance = 0;
		variance = variance(random);
		
		return ((random.length-1)*variance)/(1/12);
		
	}
	
	public double variance(double[] random){
		double m = 0;

		m = mean(random);
		
		double variance = 0;
		
		for(int i=0; i < random.length ; i++){
			variance += Math.pow((random[i]-m),2)/random.length;
		}
		
		return variance;
		
	}
	
	public double mean(double[] random){
		double mean = 0;
		double test = 0;
		
		for(int i=0; i < random.length ; i++){
			test += random[i];
		}
		mean = test/random.length;
		return mean;
	}
}
