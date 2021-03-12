package io.javaalmanac.snippets.language;

/**
 * Integer literals can be written in binary, octal, decimal or hexadecimal
 * representation. The <code>L</code> suffix denotes a long type, otherwise
 * <code>int</code> is assumed Floating point literals can be written in decimal
 * or as hexadecimal representation. The suffix <code>d</code> denotes type
 * <code>double</code> (default), the suffix <code>f</code> denotes
 * <code>float</code>.
 * 
 * @title Numeric Literals
 * @category language
 * @since 7
 */
public class NumericLiterals {

	// integer literals

	static int bin = 0b10110110;

	static int oct = 01234_567;

	static int dec = 1_000_000;

	static int dec2 = 4________2;

	static int hex = 0xcafe_babe;

	static long lhex = 0xcafe_babeL;

	// floating point literals

	static double d1 = 1.0E3d;

	static double d2 = .333_333;

	static double dhex = 0xcafe.babeP3;

	static float f = 1.0E3f;

	static float fhex = 0xcafe.babeP3f;

	public static void main(String... args) {
		System.out.println(bin);
		System.out.println(oct);
		System.out.println(dec);
		System.out.println(dec2);
		System.out.println(hex);
		System.out.println(lhex);
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(dhex);
		System.out.println(f);
		System.out.println(fhex);
	}

}
