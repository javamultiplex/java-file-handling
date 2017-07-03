package com.javamultiplex.filehandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class DeleteCommonDataFromTwoFiles {

	public static void main(String[] args) throws IOException {

		Scanner input = null;
		PrintWriter out = null;
		try {
			input = new Scanner(System.in);
			System.out.println("Enter first file with extenstion : ");
			String file1 = input.nextLine();
			System.out.println("Enter second file with extenstion : ");
			String file2 = input.nextLine();
			System.out.println("Enter third file with extension : ");
			String file3 = input.nextLine();
			Set<String> set = new LinkedHashSet<>();
			String temp = null;
			if (isValidFileName(file1) && isValidFileName(file2)
					&& isValidFileName(file3)) {

				// Reading first file and adding elements into Set.
				set = addElementFromFileToSet(file1, set);
				// Reading second file and adding elements into Set.
				set = addElementFromFileToSet(file2, set);
				Iterator<String> iterator = set.iterator();
				out = new PrintWriter(file3);
				while (iterator.hasNext()) {
					temp = (String) iterator.next();
					out.println(temp);
				}

				System.out.println("Common data has been deleted successfully!!");

			} else {
				System.out.println("Please enter file name correctly.");
			}
		} finally {
			if (input != null) {
				input.close();
			}
			if (out != null) {
				out.close();
			}
		}

	}

	private static Set<String> addElementFromFileToSet(String file,
			Set<String> set) throws IOException {

		BufferedReader br = null;
		try {
			FileReader fr = new FileReader(file);
			br = new BufferedReader(fr);
			String temp = br.readLine();
			while (temp != null) {
				// Adding elements into Set.
				set.add(temp);
				temp = br.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println("Please enter correct file name.");
			System.exit(1);
		} finally {
			if (br != null) {
				br.close();
			}
		}
		return set;
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
