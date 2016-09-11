package com.marqo404.javajax.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainTest {

	public static void main(String[] args) {
		System.out.println("DATE >> " + toDatePattern(new Date(), "dd/MM/yyyy"));
	}
	
	private static Date toDatePattern(Date date, String pattern) {
		SimpleDateFormat simplePattern = new SimpleDateFormat(pattern);
		String stringWithPattern = simplePattern.format(date);
		
		Date dateWithFormat = null;
		try {
			dateWithFormat = new SimpleDateFormat(pattern).parse(stringWithPattern);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return dateWithFormat;
	}
	
}
