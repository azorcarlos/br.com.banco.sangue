package br.com.banco.sangue.helpers;

public class Calculos {

	public static float calcularIMC(Integer peso, Float altura) {

		return peso / (altura * altura);

	}
	
	public static Boolean calulcarDoadores(Integer idade, Integer peso) {
		
		return (peso >=50 && idade >=16 && idade <=69)?true:false;
	}

}
