package com.javamultiplex.filehandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CreateDirectory {

	public static void main(String[] args) throws IOException {

		Scanner input = null;
		BufferedReader br = null;

		try {
			int result = 0;
			input = new Scanner(System.in);
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter drive letter : ");
			char ch = input.next(".").charAt(0);
			System.out.println("Enter Directory (folder) name : ");
			String directoryName = br.readLine();
			result = createNewDirectory(ch, directoryName);
			if (result == 1) {
				System.out.println("Directory " + directoryName
						+ " successfully created in " + ch + " drive.");
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

	private static int createNewDirectory(char ch, String directoryName) {

		// Creating File reference.
		File file = new File(ch + ":\\" + directoryName);
		boolean result = false;
		int flag = 0;
		// Checking whether directory exist or not in given path.
		if (file.exists()) {
			System.out.println("Directory " + directoryName
					+ " already exist in " + ch + " drive.");
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
