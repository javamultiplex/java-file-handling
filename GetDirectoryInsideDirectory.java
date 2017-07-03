package com.javamultiplex.filehandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetDirectoryInsideDirectory {

	public static void main(String[] args) throws IOException {

		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter full directory path in this format [drive:\\\\directory] example - c:\\\\abc");
			String path = br.readLine();
			if (isValidPath(path)) {
				File file = new File(path);
				if (file.exists()) {
					// Getting all files and folders.
					String[] files = file.list();
					System.out.println("Directories exist in " + path + " : ");
					for (String name : files) {
						File temp = new File(path + "\\" + name);
						if (temp.isDirectory()) {
							System.out.println(name);
						}
					}
				} else {
					System.out.println("Path doesn't exist.");
				}

			} else {
				System.out.println("Please enter path in format [drive:\\\\directory]");
			}
		} finally {
			if (br != null) {
				br.close();
			}
		}

	}

	private static boolean isValidPath(String path) {

		String pattern = "^[a-zA-Z]:\\\\\\\\[\\w]*$";
		boolean result = false;
		if (path.matches(pattern)) {
			result = true;
		}
		return result;
	}

	
}
