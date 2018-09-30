/*
*
* Author: Schahin Rajab
*
*/
import java.util.*;
import java.io.*;

public class Anagram{
	
	public static void main(String[] args){
			Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
			List<Integer> save = new ArrayList<Integer>();	//arraylist to store each output vale
			String a = new String();
			String b = new String();
			int t = sc.nextInt();	//choose number of test cases
			int l = 0;	//stores length of strings
			int count;	//will count number of anagrams
			int k;	
			boolean flag;
			
			for(int i = 0; i < t; i++){	//iterate number of test cases
				l = sc.nextInt();	//choose length of the strings
				flag = true;
				count = 0;
				k = 0;
				
				a = sc.next();	//enter string A
				b = sc.next();	//enter string B
				
				//trim string if needed
				if (a.length() > l)
				     a = a.substring(0, l);
				if (b.length() > l)
				     b = b.substring(0, l);
			if(l > 1) {	
				//count anagrams
			while(flag) {
			for(int n = 1; n < l; n++) {
				k=0;
				for(int j = 0; j < l; j++) {
					while(k < l) {
						//System.out.println("n: " + n + " j: " + j + " k: " + k);
						if(j+n > l || k+n > l) {
							flag = false;
							break;
							}
						
						if(sameChars(a.substring(j,j+n), b.substring(k,k+n))) {
							count++;
							//System.out.println("a: " + a.substring(j,j+n) + " b: " + b.substring(k,k+n) + " count: " + count);	
								if(j<l-1)
									j++;
								else
									break;
								k=0;
						}
						else {
							//System.out.println("a: " + a.substring(j,j+n) + " b: " + b.substring(k,k+n) + " count: " + count);
								if(k+n < l)
									k++;
								else {
									j++;
									k=0;
								}
						}
					}
				}
			}
			}
			}
			if(sameChars(a, b))
				count++;
			
					//System.out.println("count " + count);
				save.add(count);
			//close for-loop
			}
			
			for(int r = 0; r < save.size(); r++)	//for-loop that will iterate through arraylist
			System.out.println("Case #" + (r+1) + ": " + save.get(r));	//output results for each test case
			
	//close main
	}
	
	public static boolean sameChars(String firstStr, String secondStr) {
		  char[] first = firstStr.toCharArray();
		  char[] second = secondStr.toCharArray();
		  Arrays.sort(first);
		  Arrays.sort(second);
		  return Arrays.equals(first, second);
		}
//close class
}