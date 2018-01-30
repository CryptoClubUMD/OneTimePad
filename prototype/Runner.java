package oneTimePad;

public class Runner {
	public static void main(String args[]){
		Generate g = new Generate();
		int[] pad = g.single();
		Encode e = new Encode();
		String s = e.Encode(pad);
		System.out.println(s);
		String d = e.Decode(s, pad);
		System.out.println(d);
	}
}
