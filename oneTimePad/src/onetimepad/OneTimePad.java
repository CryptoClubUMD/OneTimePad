package onetimepad;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author garzio
 */
public class OneTimePad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {	Random rng = new Random(System.currentTimeMillis());
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter message:");
	String message = scanner.nextLine();
	String pad = makePad(64, rng);
	String encoded = encode(message, pad);
	String decoded = decode(encoded, pad);
	System.out.println(String.format(
			   "Message:\t%s\n"
			 + "Pad:\t\t%s\n"
			 + "Encoded:\t%s\n"
			 + "Decoded:\t%s",
			 message,pad,encoded,decoded));
    }
    
    //Creates a oneTimePad with given length, generated from the Random object
    public static String makePad(int length, Random rng)
    {	char[] c = new char[length];
	for(int i =0; i<length; i++)
	    c[i] = (char)(rng.nextInt(95)+32);
	return new String(c);
    }
    
    //Encrypts message with given pad
    //message must be not be longer than the pad or it will be truncated
    public static String encode(String message, String pad)
    {	char[] encrypted = new char[pad.length()];
	for(int i = 0; i<pad.length() && i<pad.length(); i++)
	    encrypted[i] = i < message.length() ?
		    addChar(message.charAt(i), pad.charAt(i)):
		    addChar(' ', pad.charAt(i));
	return new String(encrypted);
    }
    
    //Decrypts an encrypted message via the given pad
    public static String decode(String encrypted, String pad)
    {	char[] message = new char[pad.length()];
	for(int i = 0; i<pad.length(); i++)
	    message[i] = subtractChar(encrypted.charAt(i), pad.charAt(i));
	return new String(message).trim();
    }
    
    //Adds two printable chars
    //returns a printable char
    private static char addChar(char x, char y)
    {	return (char)(mod((x+y-32),95)+32);
    }
    
    //Subtracts two printable chars
    //returns a printable char
    private static char subtractChar(char x, char y)
    {	return (char)(mod((x-y-32),95)+32);
    }
    
    //Becaue the built in Java % operator is incorrect
    private static int mod(int a, int b)
    {	return (a % b + b) % b;
    }    
}
