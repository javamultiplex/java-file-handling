package com.javamultiplex.filehandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class AssignFileContentToVariable {

	public static void main(String[] args) throws IOException {

		Scanner input = null;
		BufferedReader br = null;
		try {
			input = new Scanner(System.in);
			System.out.println("Enter file name with extension : ");
			String fileName = input.nextLine();
			StringBuffer sb=new StringBuffer();
			if (isValidFileName(fileName)) {
				// Here i am assuming file is present in current directory.
				FileReader reader = new FileReader(fileName);
				br = new BufferedReader(reader);
				String line = br.readLine();
				while (line != null) {
					
					//line by line appending data to StringBuffer.
					sb.append(line).append(" ");
					line = br.readLine();
				}
				//remove last " ".
				String result=sb.substring(0,sb.length()-1);
				System.out.println(result);
			} else {
				System.out.println("File name is invalid.");
			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
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
