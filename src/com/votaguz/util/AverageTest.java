package com.votaguz.util;

public class AverageTest {

	public AverageTest(){
		
	}
	

	public double statisticalParameter(double mean, int randomNumbers ){
		return (mean - 0.5)/(Math.sqrt(1/12)/Math.sqrt(randomNumbers));
	}
	
}
