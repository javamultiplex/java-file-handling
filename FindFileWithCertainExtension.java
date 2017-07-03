package com.javamultiplex.filehandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindFileWithCertainExtension {

	public static void main(String[] args) throws IOException {

		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter full directory path in this format [drive:\\\\directory] example - c:\\\\abc");
			String path = br.readLine();
			if (isValidPath(path)) {
				File file = new File(path);
				if (file.exists()) {
					System.out.println("Enter file extension : ");
					String extension = br.readLine();
					if (isValidExtension(extension)) {
						new FindFileWithCertainExtension().findFiles(path,extension);
					} else {
						System.out.println("Invalid extension.");
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

	private void findFiles(String path, String extension) {

		FileExtensionExtractor extractor = new FileExtensionExtractor(extension);
		File dir = new File(path);
		//list() method internally called accept() method of FilenameFilter interface.
		String[] list = dir.list(extractor);
		if (list.length == 0) {
			return;
		}
		System.out.println("Following "+extension+" files present in folder "+path);
		for (String file : list) {
			//Creating file path using File.separator 
			String temp = new StringBuffer(path).append(File.separator).append(file).toString();
			System.out.println(temp);
			
		}
	}

	private static boolean isValidExtension(String extension) {

		/*
		 * Regular expression for validating file extension.
		 * for example - .txt, .exe, .doc etc
		 * 
		 */
		String pattern = "^\\.[a-zA-Z]{3}$";
		boolean result = false;
		if (extension.matches(pattern)) {
			result = true;
		}
		return result;
	}

	private static boolean isValidPath(String path) {

		/*
		 * Regular expression for validating paths.
		 * for example - c:\\abc, D:\\mnop etc
		 */
		String pattern = "^[a-zA-Z]:\\\\\\\\[\\w]*$";
		boolean result = false;
		if (path.matches(pattern)) {
			result = true;
		}
		return result;
	}

	/*
	 * This is an inner class.
	 * FilenameFilter is an interface, it's implementation is required to fetch files with specific property.
	 * Here we are fetching files based on extension. 
	 * We have to provide definition of accept() method otherwise it won't work.
	 */
	public class FileExtensionExtractor implements FilenameFilter {

		private String extension;

		public FileExtensionExtractor(String extension) {
			this.extension = extension;
		}

		@Override
		public boolean accept(File dir, String name) {
			//Checking whether file ends with particular extension.
			return name.endsWith(extension);
		}

	}
}
