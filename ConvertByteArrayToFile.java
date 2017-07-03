package com.javamultiplex.filehandling;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ConvertByteArrayToFile {

	public static void main(String[] args) throws IOException {

		Scanner input = null;
		FileOutputStream fos = null;
		try {
			input = new Scanner(System.in);
			System.out.println("Enter file name with extension : ");
			String fileName = input.nextLine();
			System.out.println("Enter length of byte array : ");
			int length=input.nextInt();
			if (isValidFileName(fileName)) {

				File file = new File(fileName);
				if (file.exists()) {
					byte[] byteArray = new byte[length];
					System.out.println("Enter "+length+" bytes (ASCII value) : ");
					for(int i=0;i<length;i++)
					{
						byteArray[i]=input.nextByte();
					}
					fos=new FileOutputStream(file);
					//Writing byte[] to file.
					fos.write(byteArray);
					System.out.println("Data has been written successfully.");
				} else {
					System.out.println("File not exists in current directory.");
				}

			} else {
				System.out.println("File name is invalid.");
			}

		} finally {

			if (input != null) {
				input.close();
			}
			if (fos != null) {
				fos.close();
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
