package com.votaguz.TestingArea;

import java.util.Scanner;

import com.votaguz.random.Mixed_Congruential;
import com.votaguz.random.Multiplicative_Congruential;
import com.votaguz.util.FrequencyTest;
import com.votaguz.util.IndependenceTest;
import com.votaguz.util.VarianceTest;

public class Testing {

	public static void main(String[] args) {
	
		
		Mixed_Congruential mxc = new Mixed_Congruential();
		Multiplicative_Congruential mlc = new Multiplicative_Congruential();
		
		Scanner sc = new Scanner(System.in);
		
		//Xo 
		int semilla = 0;
		//a
		int constante_multiplicativa = 0;
		//c
		int constante_aditiva = 0;
		//m
		int modulo = 0;
		System.out.println("Semilla: ");
		semilla = sc.nextInt();
		System.out.println("Constante Multiplicativa: ");
		constante_multiplicativa = sc.nextInt();
		System.out.println("constante aditiva: ");
		constante_aditiva = sc.nextInt();
		System.out.println("Modulo: ");
		modulo = sc.nextInt();
		
		System.out.println("---------------------------------------------------------------------------");
		
		double[] random; 
		
		int option = 0;
		
		System.out.println("[1] Congruencial Mixto\n [2] Congruencial Multiplicativo");
		option = sc.nextInt();
		
		if(option == 1){
//			int _prime=0;
//			System.out.println("Ingrese Un Numero primo");
//			_prime = sc.nextInt();
			random = mxc.Mixed_Congruential(semilla, modulo, constante_multiplicativa, constante_aditiva, 2);
			
			for(int i=0; i<random.length ; i++){
				System.out.println(random[i]);
			}
		}else{
			random = mlc.Multiplicative_Congruential(semilla, modulo, constante_multiplicativa);
			
			for(int i=0; i<random.length ; i++){
				System.out.println(random[i]);
			}
				
		}
		
		
		System.out.println("---------------------------------------------------------------------------");
		
		
		System.out.println("---------------------------------------------------------------------------");
		
		int intervaloConfianza = 0;
		int numeroCeldas = 0;
		System.out.println("Prueba Frencuencia");
		
		System.out.println("Ingrese Porcentaje % para intervalo de Confianza: ");
		intervaloConfianza = sc.nextInt();
		
		System.out.println("Ingrese Numero de celdas para la prueba");
		numeroCeldas = sc.nextInt();
		
		FrequencyTest fq = new FrequencyTest();
		if(fq.FrequencyTest(random, intervaloConfianza, numeroCeldas)){
			System.out.println("El modelo paso la prueba de frecuencia");
		}else{
			System.out.println("El modelo NO paso la prueba de frecuencia");
		}
		
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("Prueba de Independencia");
		
		System.out.println("Ingrese Porcentaje % para intervalo de Confianza: ");
		intervaloConfianza = sc.nextInt();
		
		System.out.println("Ingrese Numero de celdas para la prueba");
		numeroCeldas = sc.nextInt();
		
		IndependenceTest in = new IndependenceTest();
		if(in.IndependenceTest(random, intervaloConfianza, numeroCeldas)){
			System.out.println("El modelo paso la prueba de Independencia");
		}else{
			System.out.println("El modelo NO paso la prueba de Independencia");
		}
		
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("Prueba de Varianza");
		System.out.println("Ingrese Porcentaje % para intervalo de Confianza: ");
		intervaloConfianza = sc.nextInt();
		
		VarianceTest vt = new VarianceTest();
		if(vt.VarianceTest(intervaloConfianza, random)){
			System.out.println("El modelo paso la prueba de Varianza");
		}else{
			System.out.println("El modelo NO paso la prueba de Varianza");
		}
	}

}
