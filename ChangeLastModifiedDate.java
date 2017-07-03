package com.javamultiplex.filehandling;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ChangeLastModifiedDate {

	public static void main(String[] args) throws IOException {

		Scanner input = null;
		try {
			input = new Scanner(System.in);
			System.out.println("Enter file name with extension : ");
			String fileName = input.nextLine();
			if (isValidFileName(fileName)) {
				File file = new File(fileName);
				if (file.exists()) {
					// Getting last modified date in milliseconds.
					long time = file.lastModified();
					String dateTime = getStringFromFileTime(time);
					System.out.println("Last modified date is : " + dateTime);
					System.out.println("Enter new date in format (dd/MM/yyyy) : ");
					String newDate = input.next();
					// Validating given date and converting String to Date.
					Date mydate = getValidDate(newDate);
					if (mydate != null) {
						// Getting given date in milliseconds.
						time = mydate.getTime();
						// Setting last modified date in milliseconds.
						file.setLastModified(time);
						// Getting last modified date in milliseconds.
						time = file.lastModified();
						dateTime = getStringFromFileTime(time);
						System.out.println("Now Last modified date is : "+ dateTime);
					} else {
						System.out.println("Date is invalid.");
					}

				} else {
					System.out.println("File doesn't exist in current directory.");
				}
			} else {
				System.out.println("File name is not valid.");
			}
		} finally {
			if (input != null) {
				input.close();
			}
		}
	}

	private static Date getValidDate(String date) {

		Date mydate = null;
		if (isValidDateFormat(date)) {
			/*
			 * d -> Day of month 
			 * M -> Month of year 
			 * y -> Year
			 */
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			/*
			 * By default setLenient() is true. We should make it false for
			 * strict date validations.
			 * 
			 * If setLenient() is true - It accepts all dates. If setLenient()
			 * is false - It accepts only valid dates.
			 */
			dateFormat.setLenient(false);
			try {
				mydate = dateFormat.parse(date);
			} catch (ParseException e) {
				mydate = null;
			}
		}
		return mydate;
	}

	private static boolean isValidDateFormat(String date) {

		/*
		 * Regular Expression that matches String with format dd/MM/yyyy. 
		 * dd -> 01-31 
		 * MM -> 01-12 
		 * yyyy -> 4 digit number
		 */
		String pattern = "(0?[1-9]|[12][0-9]|3[01])\\/(0?[1-9]|1[0-2])\\/([0-9]{4})";
		boolean result = false;
		if (date.matches(pattern)) {
			result = true;
		}
		return result;
	}

	private static String getStringFromFileTime(long time) {

		Date date = new Date();
		// setting milliseconds.
		date.setTime(time);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		// Convert Date to String.
		String dateTime = dateFormat.format(date);
		return dateTime;

	}

	private static boolean isValidFileName(String fileName) {

		String pattern = "^.+\\..+$";
		boolean result = false;
		if (fileName.matches(pattern)) {
			result = true;
		}
		return result;
	}

}
