package com.javamultiplex.filehandling;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

public class LineFinder {

	public static void main(String[] args) throws IOException {

		Scanner input = null;
		LineNumberReader lnr = null;
		try {
			input = new Scanner(System.in);
			System.out.println("Enter file name with extension : ");
			String fileName = input.nextLine();
			if (isValidFileName(fileName)) {

				File file = new File(fileName);
				if (file.exists()) {

					FileReader fr = new FileReader(file);
					lnr = new LineNumberReader(fr);
					int count = 0;
					while (lnr.readLine() != null) {
						count++;
					}
					System.out.println("There are " + count + " lines present in given file.");
				} else {
					System.out.println("File is not present in current directory.");
				}
			} else {
				System.out.println("File name is not valid.");
			}
		} finally {
			if (input != null) {
				input.close();
			}
			if (lnr != null) {
				lnr.close();
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
