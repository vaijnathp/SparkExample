package com.polsys.csv;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateFormater {

	public static void main(String[] args) {
		String strDate = "12/12/07";
		try
		{
			SimpleDateFormat sdfDestination = new SimpleDateFormat("MM-dd-yyyy");
			strDate = sdfDestination.format(new SimpleDateFormat("dd/MM/yy").parse(strDate));

			System.out.println("Formated date is : " + strDate);
		}
		catch(ParseException pe)
		{
			System.out.println("Parse Exception : " + pe);
		}
	}



}
