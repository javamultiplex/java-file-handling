package com.javamultiplex.filehandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ConvertFileToByteArray {

	public static void main(String[] args) throws IOException {

		Scanner input = null;
		FileInputStream fis = null;
		try {
			input = new Scanner(System.in);
			System.out.println("Enter file name with extension : ");
			String fileName = input.nextLine();
			if (isValidFileName(fileName)) {

				File file = new File(fileName);
				if (file.exists()) {
					byte[] byteArray = new byte[(int) file.length()];
					fis = new FileInputStream(file);
					//Reading file data into byte[]
					fis.read(byteArray);
					System.out.println("File data in byte[] ");
					System.out.println(Arrays.toString(byteArray));
				} else {
					System.out.println("File not exists in current directory.");
				}

			} else {
				System.out.println("File name is invalid.");
			}

		} finally {

			if (input != null) {
				input.close();
			}
			if (fis != null) {
				fis.close();
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
