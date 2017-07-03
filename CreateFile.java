package com.javamultiplex.filehandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CreateFile {

	public static void main(String[] args) throws IOException {

		Scanner input = null;
		BufferedReader br=null;

		try {
			boolean result = false;
			input = new Scanner(System.in);
			br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter drive letter : ");
			char ch = input.next(".").charAt(0);
			System.out.println("Enter file name with extension : ");
			String fileName = br.readLine();
			if (isValidFileName(fileName)) {
				result = createNewFile(ch, fileName);
				if (result) {
					System.out.println("File " + fileName
							+ " successfully created in " + ch + " drive.");
				}
			} else {
				System.out.println("Enter file name correctly!");
			}
		} catch (InputMismatchException e) {
			System.out.println("Enter drive letter correctly!");
		}finally {
			if (input != null) {
				input.close();
			}
			if(br!=null)
			{
				br.close();
			}
		}
	}

	private static boolean createNewFile(char ch, String fileName) {

		//Creating File reference.
		File file = new File(ch + ":\\" + fileName);
		boolean result = false;
		//Checking whether file exist or not in given path.
		if (file.exists()) {
			System.out.println("File " + fileName + " already exist in " + ch
					+ " drive.");
		} else {
			try {
				result = file.createNewFile();
			} catch (IOException e) {
				System.out.println("Error occured in creating new file.\n"
						+ e.getMessage());
			}

		}
		return result;
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
