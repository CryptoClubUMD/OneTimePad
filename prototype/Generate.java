package oneTimePad;

import java.util.Arrays;

public class Generate {
	public static int[][] list(){
		int pads = 5;
		int length = 100;
		int[][] padbook= new int[pads][length]; 
		for(int i=0; i < length;i++){
			for(int j=0; j < pads;j++){
				padbook[j][i]=(int)(Math.random()*256);
			}
		}
	return padbook;
	}
	public int[] single(){
		int[] pad = new int[100];
		for(int i = 0; i<100;i++){
			pad[i]=(int)(Math.random()*96+32);
		}
		return pad;
	}

}
