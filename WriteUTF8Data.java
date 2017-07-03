package com.javamultiplex.filehandling;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class WriteUTF8Data {

	public static void main(String[] args) throws IOException {

		Scanner input = null;
		PrintWriter out = null;
		try {
			input = new Scanner(System.in);
			System.out.println("Enter file name with extension : ");
			String fileName = input.nextLine();
			if (isValidFileName(fileName)) {
				File file = new File(fileName);
				out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF8"));
				System.out.println("Enter data to the file :(enter exit to stop) ");
				String temp=input.nextLine();
				while(!temp.equals("exit"))
				{
					out.println(temp);
					temp=input.nextLine();
				}
				System.out.println("Data has been written successfully.");
				out.flush();
			} else {
				System.out.println("File name is not valid.");
			}
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
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
