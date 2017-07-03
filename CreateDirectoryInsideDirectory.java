package com.javamultiplex.filehandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CreateDirectoryInsideDirectory {

	public static void main(String[] args) throws IOException {

		Scanner input = null;
		BufferedReader br = null;

		try {
			int result = 0;
			input = new Scanner(System.in);
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter drive letter : ");
			char ch = input.next(".").charAt(0);
			System.out.println("Enter directory name : ");
			String directoryName = br.readLine();
			System.out.println("Enter new directory : ");
			String newDirectory = br.readLine();
			result = createNewFile(ch, directoryName, newDirectory);
			if (result == 1) {
				System.out.println("Directory " + newDirectory
						+ " successfully created in directory " + ch + ":\\"
						+ directoryName);
			} else if (result == 0) {
				System.out.println("Error occured, path doesn't exist.");
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

	private static int createNewFile(char ch, String directoryName,
			String newDirectoryName) {

		// Creating File reference.
		File directory = new File(ch + ":\\" + directoryName);

		// If directory doesn't exist then creating a new directory.
		if (!directory.exists()) {
			directory.mkdir();
		}
		// Creating File reference.
		File file = new File(directory, newDirectoryName);
		boolean result = false;
		int flag = 0;
		// Checking whether directory exist or not in given path.
		if (file.exists()) {
			System.out.println("Directory " + newDirectoryName
					+ " already exist in directory " + ch + ":\\"
					+ directoryName);
			flag = 2;
		} else {

			result = file.mkdir();
			if (result) {
				flag = 1;
			}

		}
		return flag;
	}

}
