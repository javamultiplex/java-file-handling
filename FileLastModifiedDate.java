package com.javamultiplex.filehandling;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FileLastModifiedDate {

	public static void main(String[] args) throws IOException {

		Scanner input = null;
		try {
			input = new Scanner(System.in);
			System.out.println("Enter file name with extension : ");
			String fileName = input.nextLine();
			if (isValidFileName(fileName)) {
				File file = new File(fileName);
				if (file.exists()) {

					long time = file.lastModified();
					String dateTime = getStringFromFileTime(time);
					System.out.println("Last modified date and time is : " + dateTime);

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

	private static String getStringFromFileTime(long time) {

		Date date = new Date();
		// setting milliseconds.
		date.setTime(time);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
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
