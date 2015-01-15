package com.study;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Count40 {
	//File f = new File("/Users/nunssuby/Downloads/gen.txt");
	
		public int noFileNum() throws IOException{
			//FileInputStream fis = new FileInputStream("/Users/nunssuby/Downloads/gen.txt");
//			FileReader fis = new FileReader("/Users/nunssuby/Downloads/gen.txt");
//			FileReader fis = new FileReader("C:\\Users\\nunssuby\\Downloads\\gen.txt");
//			
//			BufferedReader in = new BufferedReader(fis);
//			Scanner scan = new Scanner(fis);
//			
//			String test = in.readLine();
//			System.out.println("test : "+test);
//			
//			String tests = in.readLine();
//			System.out.println("test2 : "+tests);
//			fis.
//	        //int i;
//	        System.out.println("xxxxx : ");
//	        
//	        System.out.println("has : "+scan.hasNextInt());
//	        int intr = scan.nextInt();
//	        System.out.println("intr : "+intr);
//	        
//	        int intr2 = scan.nextInt();
//	        System.out.println("intr2 : "+intr2);
//	        
//	        System.out.println("yyyyy : ");
//	        
//	        
//	        int intr3 = scan.nextInt();
//	        System.out.println("intr3 : "+intr3);
//	        
//	        int intr4 = scan.nextInt();
//	        System.out.println("intr4 : "+intr4);
	        
	        
	        //System.out.println(fis.read());
	        //i = fis.read();
	        
	        //System.out.println((char) i);
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
			Scanner in = new Scanner(new FileReader("C:\\Users\\nunssuby\\Downloads\\gen.txt"));
			boolean[] check = new boolean[200];
			int pivot=0;
			if(in.hasNext())
				pivot = in.nextInt();
			int min = (pivot>100)? pivot-100:0;
			int max = pivot+99;
			
			System.out.println("min : "+min);
			System.out.println("max : "+max);
			
			while (in.hasNext()){
				int x = in.nextInt();
				if(x>=min && x<=max)
					check[x-min] = true;
			}
			
//			꼼꼼한 테스트할 방법을 생각해야함.
//			test case를 만들면서 돌려봐야하나? 
//		    여튼 머저리 2탄임
//			for (int i=0; i<check.length;i++){
//				if(!check[i])
//					return i+min;
//			}
			
			
			for (int i=0; i<check.length;i++){
				if(check[i]){
					min = i+min;
					break;
				}
			}
			
			for (int i=min;i<check.length;i++){
				if(!check[i])
					return i+min;
			}
			
	        //fis.close();
	        
	        return 0;
		}
		
}
