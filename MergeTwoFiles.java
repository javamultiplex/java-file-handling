package com.javamultiplex.filehandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MergeTwoFiles {

	public static void main(String[] args) throws IOException {
		
		Scanner input=null;
		PrintWriter out=null;
		BufferedReader br=null;
		try
		{
			input=new Scanner(System.in);
			System.out.println("Enter first file with extenstion : ");
			String file1=input.nextLine(); 
			System.out.println("Enter second file with extenstion : ");
			String file2=input.nextLine(); 
			System.out.println("Enter third file with extension : ");
			String file3=input.nextLine(); 
			String temp=null;
			if(isValidFileName(file1) && isValidFileName(file2) && isValidFileName(file3))
			{
				//Reading first file.
				FileReader fr=new FileReader(file1);
				br=new BufferedReader(fr);
				//Creating third file.
				out=new PrintWriter(file3);
				temp=br.readLine();
				while(temp!=null)
				{
					out.println(temp);
					temp=br.readLine();
				}
				//Reading second file.
				fr=new FileReader(file2);
				br=new BufferedReader(fr);
				temp=br.readLine();
				while(temp!=null)
				{
					out.println(temp);
					temp=br.readLine();
				}
				System.out.println("Files has been merged successfully");
			}
			else
			{
				System.out.println("Please enter file name correctly.");
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			if(input!=null)
			{
				input.close();
			}
			if(out!=null)
			{
				out.close();
			}
			if(br!=null)
			{
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
