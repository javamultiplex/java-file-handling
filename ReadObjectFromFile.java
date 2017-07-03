package com.javamultiplex.filehandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;
import java.util.Scanner;

public class ReadObjectFromFile {

	public static void main(String[] args) throws IOException {

		Scanner input = null;
		ObjectInputStream ois = null;
		FileInputStream fis = null;
		try {
			input = new Scanner(System.in);
			System.out.println("Enter file name with extension : ");
			String fileName = input.nextLine();
			if (isValidFileName(fileName)) {

				File file = new File(fileName);
				if (file.exists()) {
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);
					//Reading object from file.
					Student student = (Student) ois.readObject();
					System.out.println("---Student Information---");
					System.out.println("Name : " + student.getName());
					System.out.println("Age : " + student.getAge());
				} else {
					System.out.println("File not exists in current directory.");
				}

			} else {
				System.out.println("File name is invalid.");
			}

		} catch (ClassNotFoundException exception) {
			System.out.println(exception.getMessage());
		} catch (StreamCorruptedException exception) {
			System.out.println("Object is not present in given file.");
		} finally {
			if (input != null) {
				input.close();
			}
			if (ois != null) {
				ois.close();
			}
			if (fis != null) {
				fis.close();
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
