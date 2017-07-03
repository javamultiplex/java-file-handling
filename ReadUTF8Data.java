package com.javamultiplex.filehandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class ReadUTF8Data {

	public static void main(String[] args) throws IOException {

		Scanner input = null;
		BufferedReader in = null;
		try {
			input = new Scanner(System.in);
			System.out.println("Enter file name with extension : ");
			String fileName = input.nextLine();
			if (isValidFileName(fileName)) {

				File file = new File(fileName);
				if (file.exists()) {
					in = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF8"));
					String str=in.readLine();
					while (str!=null) {
						System.out.println(str);
						str=in.readLine();
					}

				} else {
					System.out.println("File is not present in current directory.");
				}
			} else {
				System.out.println("File name is not valid.");
			}
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		} finally {
			if (input != null) {
				input.close();
			}
			if (in != null) {
				in.close();
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
