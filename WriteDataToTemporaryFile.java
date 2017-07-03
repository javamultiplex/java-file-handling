package com.javamultiplex.filehandling;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WriteDataToTemporaryFile {

	public static void main(String[] args) throws IOException {

		Scanner input = null;
		PrintWriter out = null;
		try {
			input = new Scanner(System.in);
			System.out.println("Enter temporary file name: ");
			String fileName = input.nextLine();
			String temp = null;
			if (fileName == null || fileName.isEmpty()) {
				System.out.println("File name should not be empty.");
			} else {
				File file = File.createTempFile(fileName, ".tmp");
				out = new PrintWriter(file);
				System.out.println("Enter the data in file (enter exit to end) :");
				temp = input.nextLine();
				while (!temp.equals("exit")) {
					out.println(temp);
					temp = input.nextLine();
				}
				System.out.println("Data has been written successfully to file");

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
}
