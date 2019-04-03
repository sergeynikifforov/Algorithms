import java.math.BigInteger;
import java.lang.reflect.Array;

public class Karatsuba {
    public static BigInteger performeKaratsuba(BigInteger x, BigInteger y){
        BigInteger TWO = new BigInteger("2");
        BigInteger ONE = new BigInteger("1");
        BigInteger TEN = new BigInteger("10");
        if(x.compareTo(TEN) == -1 || y.compareTo(TEN) == -1){
            return x.multiply(y);
        }
        String length = Integer.toString((x.max(y)).toString().length());
        BigInteger n = new BigInteger(length);
        if (n.mod(TWO).equals(ONE))
            n = n.add(ONE);

        BigInteger a = x.divide(TEN.pow(n.divide(TWO).intValue()));
        BigInteger b = x.mod(TEN.pow(n.divide(TWO).intValue()));
        BigInteger c = y.divide(TEN.pow(n.divide(TWO).intValue()));
        BigInteger d = y.mod(TEN.pow(n.divide(TWO).intValue()));

        BigInteger first = performeKaratsuba(a,c);
        BigInteger second = performeKaratsuba(b,d);
        BigInteger third = performeKaratsuba(a.add(b),c.add(d));
        return ((first.multiply(TEN.pow(n.intValue()))).add ((((third.subtract(first)).subtract( second))).multiply(TEN.pow(n.divide(TWO).intValue()))).add(second));
    }
    public static void main(String args[]) {
        BigInteger x = new BigInteger("3141592653589793238462643383279502884197169399375105820974944592");
        BigInteger y= new BigInteger("2718281828459045235360287471352662497757247093699959574966967627");
        BigInteger z = performeKaratsuba(x,y);

        System.out.println("multiplicatation of x and y = " + z);
        System.out.println("multiplicatation of x and y = " + z.toString().length());
    }
}

