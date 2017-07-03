package com.javamultiplex.filehandling;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FilePermission {

	public static void main(String[] args) throws IOException {

		Scanner input = null;
		try {
			input = new Scanner(System.in);
			System.out.println("Enter file name with extension : ");
			String fileName = input.nextLine();
			if (isValidFileName(fileName)) {

				File file = new File(fileName);
				if (file.exists()) {
					System.out.println("Executable : " + file.canExecute());
					System.out.println("Readable : " + file.canRead());
					System.out.println("Writable : " + file.canWrite());

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