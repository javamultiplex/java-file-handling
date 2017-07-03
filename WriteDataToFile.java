package com.javamultiplex.filehandling;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WriteDataToFile {

	public static void main(String[] args) throws IOException{

		Scanner input = null;
		PrintWriter out = null;
		try {
			input = new Scanner(System.in);
			System.out.println("Enter file name with extension : ");
			String fileName = input.nextLine();
			String temp = null;
			if (isValidFileName(fileName)) {
				
				//Here i am assuming file is present in current directory.
				out = new PrintWriter(fileName);
				System.out.println("Enter the data in file (enter exit to end) :");
				temp=input.nextLine();
				while(!temp.equals("exit"))
				{
					out.println(temp);
					temp=input.nextLine();
				}
				System.out.println("Data has been written successfully to file ");

			} else {
				System.out.println("File name is invalid.");
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

	private static boolean isValidFileName(String fileName) {

		String pattern = "^.+\\..+$";
		boolean result = false;
		if (fileName.matches(pattern)) {
			result = true;
		}
		return result;
	}

}
