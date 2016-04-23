package wordladdertests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileContents {
	public static boolean fileCompare(File file1, File file2) {
		String s1 = null;
		String s2 = null;
		try {
			s1 = toString(file1);
		} catch (FileNotFoundException e) {
			System.err.println("Could not open file " + file1.getName());
		}
		try {
			s2 = toString(file2);
		} catch (FileNotFoundException e) {
			System.err.println("Could not open file " + file2.getName());
		}
		s1 = s1.replaceAll("( |\n|\t|\r)","");
		s2 = s2.replaceAll("( |\n|\t|\r)","");		
		return s1.equals(s2);
	}
	
	private static String toString(File file) 
						throws FileNotFoundException {
		FileInputStream input = new FileInputStream(file);
		byte[] buffer = new byte[1024];
		StringBuilder s = new StringBuilder();
		try {
			while (input.available() != 0) {
				int index = input.read(buffer);
				s.append(new String(buffer,0,index));
			}
		} catch(IOException e) {
			System.err.println("Error reading " + file.getName());
			System.exit(1);
		}
		return s.toString();		
	}
	


}
