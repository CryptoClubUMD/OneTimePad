package oneTimePad;

import java.util.Scanner;

public class Encode {
	public String Encode(int[] pad) {
		Scanner text = new Scanner(System.in);
		System.out.println("input message");
		String message = text.nextLine();
		return makeString(add(pad, toChar(message)));
	}
	public String Decode(String s, int[] pad) {
	
		return makeString(subtract(pad, toChar(s)));
	}

	private char[] subtract(int[] pad, char[] c) {
		for (int i = 0; i < 100; i++) {
			c[i]=(char) (c[i]-pad[i]);
			if(c[i]<32) c[i]+=95;
		}
		return c;
	}
	private static String makeString(char[] c) {
		String s="";
		for (int i = 0; i < 100; i++) {
			s+=c[i];
		}
		return s;
	}

	private static char[] add(int[] pad, char[] c) {
		for (int i = 0; i < 100; i++) {
			c[i]=(char) (pad[i]+c[i]);
			if(c[i]>126) c[i]-=95;
		}
		return c;
	}

	private static char[] toChar(String s) {
		while (s.length() % 100 != 0)  //adds zero's, compatibale for multi-pad messages
			s += " ";
//		s=s.substring(0,99); 		//stops indexOutOfBounds for now; dosent work
		char[] c = new char[100];
		for (int i = 0; i < 100; i++) {
			c[i] = s.charAt(i);
		}
		return c;
	}

}