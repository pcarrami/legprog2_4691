package com.edu.cibertec.matricula.utils;

import java.time.LocalDate;

public class Utils {
	public static LocalDate _toLocalDate(String fecha) {
		String[] campos = fecha.split("-");
		int anio, mes , dia;  //yyyy-mm-dd
		anio = Integer.parseInt(campos[0]);
		mes = Integer.parseInt(campos[1]);
		dia = Integer.parseInt(campos[2]);
		return LocalDate.of(anio, mes, dia);
	}
}
