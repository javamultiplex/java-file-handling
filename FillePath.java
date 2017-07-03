package com.javamultiplex.filehandling;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FillePath {

	public static void main(String[] args) throws IOException {

		Scanner input = null;
		try {
			input = new Scanner(System.in);
			System.out.println("Enter file name with extension : ");
			String filename = input.nextLine();
			if (isValidFileName(filename)) {
				String workingDirectory = System.getProperty("user.dir");
				String absoluteFilePath = workingDirectory + File.separator + filename;
				System.out.println("File path : "+absoluteFilePath);
			}
			else
			{
				System.out.println("File name is not valid.");
			}
		} finally {
			if (input != null) {
				input.close();
			}
		}
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
