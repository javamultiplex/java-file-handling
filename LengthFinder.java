package com.javamultiplex.filehandling;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LengthFinder {

	public static void main(String[] args) throws IOException {

		Scanner input = null;
		try {
			input = new Scanner(System.in);
			System.out.println("Enter file name with extension : ");
			String fileName = input.nextLine();
			if (isValidFileName(fileName)) {
				// Here i am assuming file is present in current directory.
				File file = new File(fileName);
				long length = file.length();
				System.out.println("Length of file is : " + length + " bytes.");

			} else {
				System.out.println("File name is invalid.");
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
