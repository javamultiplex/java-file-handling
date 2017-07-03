package com.javamultiplex.filehandling;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class WriteObjectToFile {

	public static void main(String[] args) throws IOException {

		Scanner input = null;
		try {
			input = new Scanner(System.in);
			System.out.println("Enter file name with extension : ");
			String fileName = input.nextLine();
			if (isValidFileName(fileName)) {

				File file = new File(fileName);
				if (file.exists()) {
					System.out.println("Enter student name : ");
					String name = input.nextLine();
					System.out.println("enter age : ");
					int age = input.nextInt();
					Student student = new Student();
					student.setName(name);
					student.setAge(age);
					writeObjectTofile(file, student);
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
		}

	}

	private static void writeObjectTofile(File file, Student student)
			throws IOException {

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			//Checking Student class is Serializable or not.
			if (student instanceof Serializable) {
				//Writing object to file.
				oos.writeObject(student);
				System.out.println("Object has been written successfully.");
			} else {
				System.out.println(student.getClass().getName() + " is not Serializable.");
			}

		} finally {
			if (fos != null) {
				fos.close();
			}
			if (oos != null) {
				oos.close();
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
