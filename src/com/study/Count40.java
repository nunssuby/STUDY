package com.study;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Count40 {
	//File f = new File("/Users/nunssuby/Downloads/gen.txt");
	
		public int noFileNum() throws IOException{
			//FileInputStream fis = new FileInputStream("/Users/nunssuby/Downloads/gen.txt");
			FileReader fis = new FileReader("/Users/nunssuby/Downloads/gen.txt");
			
			
	        int i;
	        
	        //System.out.println(fis.read());
	        i = fis.read();
	        
	        System.out.println((char) i);
//	        i = fis.read();
//	        System.out.println(i);
//	        i = fis.read();
//	        System.out.println(i);
//	        i = fis.read();
//	        System.out.println(i);
	        
	        
	        //int j = fis.
//	        while ((i = fis.read()) != -1) {
//	            System.out.print((char) i);
//	        }
	        fis.close();
	        
	        return 0;
		}
		
}
