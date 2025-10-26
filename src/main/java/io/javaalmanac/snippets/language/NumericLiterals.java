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

	int bin = 0b10110110;

	int oct = 01234_567;

	int dec = 1_000_000;

	int dec2 = 4________2;

	int hex = 0xcafe_babe;

	long lhex = 0xcafe_babeL;

	// floating point literals

	double d1 = 1.0E3d;

	double d2 = .333_333;

	double dhex = 0xcafe.babeP3;

	float f = 1.0E3f;

	float fhex = 0xcafe.babeP3f;

	void main() {
		IO.println(bin);
		IO.println(oct);
		IO.println(dec);
		IO.println(dec2);
		IO.println(hex);
		IO.println(lhex);
		IO.println(d1);
		IO.println(d2);
		IO.println(dhex);
		IO.println(f);
		IO.println(fhex);
	}

}
