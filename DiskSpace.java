package com.javamultiplex.filehandling;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DiskSpace {

	public static void main(String[] args) throws IOException {

		Scanner input = null;
		try {
			input = new Scanner(System.in);
			System.out.println("Enter drive letter : ");
			char ch = input.next(".").charAt(0);
			File file=new File(ch+":");
			//Finding total space.
			long totalSpace=file.getTotalSpace();
			//Finding free space.
			long freeSpace=file.getFreeSpace();
			/*
			 * 1 KB = 1024 Byte
			 * 1 MB = 1024 KB
			 * 1 GB = 1024 MB
			 * 1 TB = 1024 GB
			 * 
			 */
			long totalSpaceInGB=totalSpace/(1024*1024*1024);
			long freeSpaceInGB=freeSpace/(1024*1024*1024);
			long usableSpaceInGB=totalSpaceInGB-freeSpaceInGB;
			System.out.println("Total Space : " + totalSpaceInGB+ " GB");
			System.out.println("Free Space : " + freeSpaceInGB + " GB");
			System.out.println("Usable Space : " + usableSpaceInGB + " GB");

		} catch (InputMismatchException e) {
			System.out.println("Enter drive letter correctly!");
		} finally {
			if (input != null) {
				input.close();
			}
		}
	}

}
