package modelo;

import java.io.*;

public final class Console {

	public static boolean readBoolean () {
		try {
			BufferedReader br = new BufferedReader (
					new InputStreamReader (System.in) );
			String s = br.readLine ();
			Boolean b = new Boolean (s);
			return b.booleanValue ();
		} catch (IOException e) {
			return false;
		}
	}

	public static byte readByte () {
		try {
			BufferedReader br = new BufferedReader (
					new InputStreamReader (System.in) );
			String s = br.readLine ();
			return Byte.parseByte (s);
		} catch (IOException e) {
			return 0;
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public static short readShort () {
		try {
			BufferedReader br = new BufferedReader (
					new InputStreamReader (System.in) );
			String s = br.readLine ();
			return Short.parseShort (s);
		} catch (IOException e) {
			return 0;
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public static int readInteger () {
		try {
			BufferedReader br = new BufferedReader (
					new InputStreamReader (System.in) );
			String s = br.readLine ();
			return Integer.parseInt (s);
		} catch (IOException e) {
			return 0;
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public static long readLong () {
		try {
			BufferedReader br = new BufferedReader (
					new InputStreamReader (System.in) );
			String s = br.readLine ();
			return Long.parseLong (s);
		} catch (IOException e) {
			return 0;
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public static float readFloat () {
		try {
			BufferedReader br = new BufferedReader (
					new InputStreamReader (System.in) );
			String s = br.readLine ();
			Float f = new Float (s);
			return f.floatValue ();
		} catch (IOException e) {
			return 0;
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public static double readDouble () {
		try {
			BufferedReader br = new BufferedReader (
					new InputStreamReader (System.in) );
			String s = br.readLine ();
			Double d = new Double (s);
			return d.doubleValue ();
		} catch (IOException e) {
			return 0;
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public static char readChar () {
		try {
			/* BufferedReader br = new BufferedReader (
	                new InputStreamReader (System.in) );
	         String s = br.readLine ();
	         return s.charAt(0); */
	         return ((char) System.in.read());
		} catch (IOException e) {
			return '\0';
		}
	}

	public static String readString () {
		try {
			BufferedReader br = new BufferedReader (
					new InputStreamReader (System.in) );
			String s = br.readLine ();
			return s;
		} catch (IOException e) {
			return "";
		}
	}

}