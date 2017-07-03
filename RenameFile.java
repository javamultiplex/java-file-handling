package com.javamultiplex.filehandling;

import java.io.File;
import java.util.Scanner;

public class RenameFile {

	public static void main(String[] args) {

		Scanner input = null;
		try {
			input = new Scanner(System.in);
			System.out.println("Enter old file name with extension : ");
			String oldFileName = input.nextLine();
			if (isValidFileName(oldFileName)) {
				File oldFile = new File(oldFileName);
				if (oldFile.exists()) {
					System.out.println("Enter new file name with extension : ");
					String newFileName = input.nextLine();
					if (isValidFileName(newFileName)) {
						File newFile = new File(newFileName);
						oldFile.renameTo(newFile);
						System.out.println("File renamed successfully.");
					}
				} else {
					System.out.println("Old File doesn't exist in current directory.");
				}
			} else {
				System.out.println("Old file name is not valid.");
			}
		} finally {
			if (input != null) {
				input.close();
			}
		}

	}

	private static boolean isValidFileName(String fileName) {

	    //Regular expression for validating file names.
		String pattern = "^.+\\..+$";
		boolean result = false;
		if (fileName.matches(pattern)) {
			result = true;
		}
		return result;
	}

}
