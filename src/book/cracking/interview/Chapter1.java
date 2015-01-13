package book.cracking.interview;

public class Chapter1 {
	public boolean uniquecheck(String str){
		boolean[] temp = new boolean[256];
		for(int i=0;i<str.length();i++){
			if(temp[str.charAt(i)])
				return false;
			else
				temp[str.charAt(i)]=true;
		}
		
		return true;
	}
	
//	public boolean uniquecheck2(String str){
//		boolean[] temp = new boolean[str.length()];
//		for(char ch:str.charAt()){
//			if(temp[str.charAt(i)])
//				return false;
//			else
//				temp[str.charAt(i)]=true;
//		}
//		
//		return true;
//	}
	
}
