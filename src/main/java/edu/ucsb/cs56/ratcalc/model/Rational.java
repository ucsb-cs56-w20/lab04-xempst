/** A class to represent a rational number
    with a numerator and denominator

    @author P. Conrad for CS56 F16

	*/
package edu.ucsb.cs56.ratcalc.model;

public class Rational {

    private int num;
    private int denom;

    /** 
	greatest common divisor of a and b
	@param a first number
	@param b second number
	@return gcd of a and b
    */
    public static int gcd(int a, int b) {
	if (a==0)
	    return b;
	else if (b==0)
	    return a;
	else
	    return gcd(b%a, a);
	}
	
	/** 
	 * least common multiple of a and b
	 * @param a first number
	 * @param b second number
	 * @return lcm of a and b
     */
    public static int lcm(int a, int b) {
		if (a == 0 && b == 0)
			return 0;
		else
			return Math.abs(a*b)/gcd(a,b);		//stub
	}

	/**
	 * sum of this number plus r
	 * @param r rational number
	 * @return sum of this number plus r
	 */
	public Rational plus(Rational r) {
		int cm = lcm(this.denom,r.denom);			//cm = common multiple
		int scale = cm/this.denom;
		this.num *= scale;
		scale = cm/r.denom;
		r.num *= scale;
		this.num += r.num;
		this.denom = cm;

		//simplify 'this'
		Rational n = new Rational(this.num, this.denom);

		//force negative sign on numerator
		if (n.denom < 0) {
			n.denom *= -1;
			n.num *= -1;
		}
		return n;
	}

	/**
	 * a + b
	 * @param a first rational number
	 * @param b	second rational number
	 * @return sum of a and b
	 */
	public static Rational sum(Rational a, Rational b) {
		Rational sum = new Rational(0,1);			//create a rational for sum since there is no copy constructor
		sum.plus(a);
		return sum.plus(b);
	}

	/**
	 * this number minus r
	 * @param r rational number
	 * @return difference of this number and r
	 */
	public Rational minus(Rational r) {
		Rational nr = new Rational(-1, 1);
		return this.plus(r.times(nr));
	}

	/**
	 * a minux b
	 * @param a first rational number
	 * @param b second rational number
	 * @return the difference between a and b
	 */
	public static Rational difference(Rational a, Rational b) {
		Rational diff = new Rational(a.num, a.denom);
		return diff.minus(b);
	}
  
    public Rational() {
	this.num = 1;
	this.denom = 1;
    }

    public Rational(int num, int denom) {
	if (denom== 0) {
	    throw new IllegalArgumentException("denominator may not be zero");
	}
	this.num = num;
	this.denom = denom;
	if (num != 0) {
	    int gcd = Rational.gcd(num,denom);
	    this.num /= gcd;
	    this.denom /= gcd;
	}
    }

    public String toString() {
	if (denom == 1 || num == 0)
	    return "" + num;
	return num + "/" + denom;
    }

    public int getNumerator() { return this.num; }
    public int getDenominator() { return this.denom; }

    public Rational times(Rational r) {
	return new Rational(this.num * r.num,
			    this.denom * r.denom);
    }

    public static Rational product(Rational a, Rational b) {
	return new Rational(a.num * b.num,
			    a.denom * b.denom);
	}
	
	/**
	 * swap numberator and denominator
	 * @return reciprocal of this number
	 */
	public Rational reciprocalOf() {
		if (this.num == 0)
			throw new ArithmeticException("denominator may not be zero");

		Rational r = new Rational(this.denom, this.num);

		//force negative sign on numerator
		if (r.denom < 0) {
			r.denom *= -1;
			r.num *= -1;
		}
		return r;

	}

	/**
	 * this number divided by r
	 * @param r	rational number
	 * @return this number divided by r
	 */
	public Rational dividedBy(Rational r) {
		if (r.num == 0)
			throw new ArithmeticException("cannot divide by zero");

		Rational n = this.times(r.reciprocalOf());

		//force negative sign on numerator 
		if (n.denom < 0) {
			n.denom *= -1;
			n.num *= -1;
		}
		return n;
	}

	/**
	 * a divided by b
	 * @param a first rational number
	 * @param b second rational number
	 * @return a divided by b
	 */
	public static Rational quotient(Rational a, Rational b) {
		return a.dividedBy(b);
	}
	
    /** 
	For testing getters.  
	@param args unused
     */

    public static void main (String [] args) {
	Rational r = new Rational(5,7);
	System.out.println("r.getNumerator()=" + r.getNumerator());
	System.out.println("r.getDenominator()=" + r.getDenominator());
    }

    
}
