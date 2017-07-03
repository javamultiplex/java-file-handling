package com.javamultiplex.filehandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MergeTwoFilesLineByLine {

	public static void main(String[] args) throws IOException {

		Scanner input = null;
		PrintWriter out = null;
		BufferedReader br1 = null;
		BufferedReader br2 = null;
		try {
			input = new Scanner(System.in);
			System.out.println("Enter first file with extenstion : ");
			String file1 = input.nextLine();
			System.out.println("Enter second file with extenstion : ");
			String file2 = input.nextLine();
			System.out.println("Enter third file with extension : ");
			String file3 = input.nextLine();
			String temp1 = null;
			String temp2 = null;
			if (isValidFileName(file1) && isValidFileName(file2)
					&& isValidFileName(file3)) {
				// Reading first file.
				FileReader fr1 = new FileReader(file1);
				br1 = new BufferedReader(fr1);
				// Reading second file.
				FileReader fr2 = new FileReader(file2);
				br2 = new BufferedReader(fr2);
				// Creating third file.
				out = new PrintWriter(file3);
				temp1 = br1.readLine();
				temp2 = br2.readLine();
				while (temp1 != null || temp2 != null) {
					if (temp1 != null) {
						out.println(temp1);
					}
					if (temp2 != null) {
						out.println(temp2);
					}
					temp1 = br1.readLine();
					temp2 = br2.readLine();
				}
				System.out.println("Files has been merged line by line successfully");
			} else {
				System.out.println("Please enter file name correctly.");
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} finally {
			if (input != null) {
				input.close();
			}
			if (out != null) {
				out.close();
			}
			if (br1 != null) {
				br1.close();
			}
			if (br2 != null) {
				br2.close();
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
