package com.javamultiplex.filehandling;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FileCreationDate {

	public static void main(String[] args) throws IOException {

		Scanner input = null;
		try {
			input = new Scanner(System.in);
			System.out.println("Enter file name with extension : ");
			String fileName = input.nextLine();
			if (isValidFileName(fileName)) {
				File file = new File(fileName);
				if (file.exists()) {
					BasicFileAttributes attributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
					// Getting file creation time.
					FileTime time = attributes.creationTime();
					String dateTime = getStringFromFileTime(time);
					System.out.println("Creation date and time is : "+ dateTime);

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

	private static String getStringFromFileTime(FileTime time) {

		// Getting milliseconds.
		long milliseconds = time.toMillis();
		Date date = new Date();
		// setting milliseconds.
		date.setTime(milliseconds);
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
