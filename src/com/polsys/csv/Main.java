package com.polsys.csv;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

	public static void main(String[] args) {


		//string containing date in one format
		String strDate = "12/12/07";

		try
		{
			//create SimpleDateFormat object with source string date format
		
			SimpleDateFormat sdfDestination = new SimpleDateFormat("MM-dd-yyyy");

			//parse the date into another format
			strDate = sdfDestination.format(new SimpleDateFormat("dd/MM/yy").parse(strDate));

			System.out.println("Date is converted from dd/MM/yy format to MM-dd-yyyy hh:mm:ss");
			System.out.println("Converted date is : " + strDate);

		}
		catch(ParseException pe)
		{
			System.out.println("Parse Exception : " + pe);
		}
	}



}
