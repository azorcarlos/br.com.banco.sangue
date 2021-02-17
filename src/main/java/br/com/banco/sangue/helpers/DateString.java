package br.com.banco.sangue.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateString {

	public static int getIdade(Date inputDate) {

		Calendar dataNascimento = Calendar.getInstance();
		Calendar currentDate = Calendar.getInstance();

		dataNascimento.setTime(inputDate);
		dataNascimento.set(Calendar.YEAR, currentDate.get(Calendar.YEAR));

		int idade = dataNascimento.after(currentDate) ? -1 : 0;
		dataNascimento.setTime(inputDate);
		return idade += currentDate.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR);

	}

	public static Date getDateFormat(String formatDate, String stringDate) {

		SimpleDateFormat formatter = new SimpleDateFormat(formatDate);

		Date date = null;
		try {
			date = formatter.parse(stringDate);

			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return new Date();

	}

}
