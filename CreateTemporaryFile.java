package com.javamultiplex.filehandling;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class CreateTemporaryFile {

	
	public static void main(String[] args) throws IOException {
		
		Scanner input=null;
		try
		{
			input=new Scanner(System.in);
			System.out.println("Enter temporary file name : ");
			String fileName=input.nextLine();
			if(fileName==null || fileName.isEmpty())
			{
				System.out.println("File name should not be empty.");
			}
			else
			{
				File file=File.createTempFile(fileName, ".tmp");
				System.out.println("File is created successfully.");
				System.out.println("Temporary file Absolute path : " + file.getAbsolutePath());
			}
			
		}
		finally
		{
			if(input!=null)
			{
				input.close();
			}
		}
		
	}
	
}
