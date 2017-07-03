package com.javamultiplex.filehandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CopyFile {

	public static void main(String[] args) throws IOException {

		Scanner input = null;
		try {
			input = new Scanner(System.in);
			System.out.println("Enter source file name with extension : ");
			String sourceFileName = input.nextLine();
			if (isValidFileName(sourceFileName)) {
				File sourceFile = new File(sourceFileName);
				if (sourceFile.exists()) {
					System.out.println("Enter destination file name with extension : ");
					String destinationFileName = input.nextLine();
					if (isValidFileName(destinationFileName)) {
						File destinationFile = new File(destinationFileName);
						if (isFileCopied(sourceFile, destinationFile)) {
							System.out.println("File copied successfully.");
						} else {
							System.out.println("Some error occurred while copying file.");
						}
					} else {
						System.out .println("Destination file name is not valid.");
					}
				} else {
					System.out.println("Source file doesn't exist in current directory.");
				}
			} else {
				System.out.println("Source file name is not valid.");
			}

		} finally {
			if (input != null) {
				input.close();
			}
		}

	}

	private static boolean isFileCopied(File sourceFile, File destinationFile)
			throws IOException {

		BufferedReader in = null;
		PrintWriter out = null;
		boolean result = true;
		try {
			FileReader fr = new FileReader(sourceFile);
			in = new BufferedReader(fr);
			out = new PrintWriter(destinationFile);
			String temp = in.readLine();
			while (temp != null) {
				out.println(temp);
				temp = in.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			result = false;
		} finally {
			if (in != null)
				in.close();
			if (out != null)
				out.close();
		}

		return result;
	}

	private static boolean isValidFileName(String fileName) {

		// Regular expression for validating file names.
		String pattern = "^.+\\..+$";
		boolean result = false;
		if (fileName.matches(pattern)) {
			result = true;
		}
		return result;
	}

}
