package com.javamultiplex.filehandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MoveFile {

	public static void main(String[] args) throws IOException {

		Scanner input = null;
		BufferedReader br = null;

		try {
			input = new Scanner(System.in);
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter file name with extension: ");
			String fileName = br.readLine();
			System.out.println("Enter drive letter : ");
			char ch = input.next(".").charAt(0);
			System.out.println("Enter directory name : ");
			String directoryName = br.readLine();
			if (isValidFileName(fileName)) {
				File file1 = new File(fileName);
				if (file1.exists()) {
					String folder = ch + ":" + File.separator + directoryName;
					File file2 = new File(folder);
					if (file2.exists()) {
						file2 = new File(folder + File.separator + fileName);
						if (file1.renameTo(file2)) {
							System.out.println("File moved successfully.");
						} else {
							System.out.println("File move is unsuccessfull.");
						}
					} else {
						System.out.println("Folder path is invalid.");
					}

				} else {
					System.out.println("File not exists in current directory.");
				}
			} else {
				System.out.println("Enter file name correctly!");
			}
		} catch (InputMismatchException e) {
			System.out.println("Enter drive letter correctly!");
		} finally {
			if (input != null) {
				input.close();
			}
			if (br != null) {
				br.close();
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
