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

     public static int lcm(int a, int b){;

	 return Math.abs(a * b) / gcd(a , b);
     
    }

    public static Rational sum(Rational a, Rational b){
	return new Rational((a.num * b.denom) + (b.num * a.denom), (a.denom * b.denom));
    }
    
    public Rational plus(Rational r){
	return sum(this, r);
    }

     public static Rational difference(Rational a, Rational b){
	 return new Rational((a.num * b.denom) - (b.num * a.denom), (a.denom * b.denom));
    }

    public Rational minus(Rational r){
	return difference(this, r);
    }

    public Rational reciprocalOf(){
	int tempNum = this.num;
	if(tempNum == 0)
	    throw new ArithmeticException();
	int tempDenom = this.denom;
	return new Rational(tempDenom, tempNum);
    }

    public static Rational quotient(Rational a, Rational b){
	Rational temp = b.reciprocalOf();
	return product(a, temp);
    }
    
    public Rational dividedBy(Rational r){
	return quotient(this, r);
    }
    
    /** 
	For testing getters.  
	@param args unused
     */

    public static void main (String [] args) {
	Rational r = new Rational(5,7);
	Rational r2 = new Rational(1,2);
	Rational r3 = r2.reciprocalOf();
	System.out.println("r.getNumerator()=" + r.getNumerator());
	System.out.println("r.getDenominator()=" + r.getDenominator());
	System.out.println("Testing lcm" + lcm(3,5));
	System.out.println("Testing sum" + sum(r , r2));
	System.out.println("Testing plus" + r.plus(r2));
	System.out.println("Testing minus" + r.minus(r2));
	System.out.println("Testing difference" + difference(r , r2));
	System.out.println("Testing reciprocal" + r3.getNumerator() + r3.getDenominator());
	System.out.println("Testing dividedBy" + r.dividedBy(r2));
	System.out.println("Testing quotient" + quotient(r , r2));
    }

 

    
}
