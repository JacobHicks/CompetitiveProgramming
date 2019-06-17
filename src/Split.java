import java.math.BigInteger;
import java.util.Scanner;
//RIIIIGGEREED against java users
public class Split {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        in.nextLine();
        String number = in.nextLine();
        System.out.println(r(number, Math.max(len/2-1,1)).toString());
    }

    static BigInteger r(String number, int i) {
        if(i >= number.length() || i >= number.length()/2 + 2 && number.charAt(i-1) != '0' && number.charAt(i) != '0') return null;
        BigInteger next = r(number, i + 1);
        if(number.charAt(i) != '0') {
            BigInteger res = new BigInteger(number.substring(0, i)).add(new BigInteger(number.substring(i)));
            if(next == null) return res;
            return min(res, next);
        }
        return next;
    }

    static BigInteger min(BigInteger n1, BigInteger n2) {
        int res = n1.compareTo(n2);
        if(res <= 0) return n1;
        return n2;
    }
}
