import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Spreadsheets { //DOESNT WORK
    final static Pattern rowCol = Pattern.compile("R(\\d+)C(\\d+)");
    final static Pattern colRow = Pattern.compile("([A-Z]+)(\\d+)");

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int ds = in.nextInt();
        in.nextLine();
        for (int dataSet = 0; dataSet < ds; dataSet++) {
            String s = in.nextLine();
            Matcher rowColMatcher = rowCol.matcher(s);
            Matcher colRowMatcher = colRow.matcher(s);
            String res = "";
            if (rowColMatcher.matches()) {
                int col = Integer.parseInt(rowColMatcher.group(2));
                int baseref = 1;
                while (baseref * 26 < col) {
                    baseref *= 26;
                }
                while (col != 1) {
                    int lettern = col / baseref;
                    res += (char)(lettern + 'A' - 1);
                    col %= baseref;
                    col++;
                    baseref /= 26;
                }
                res += rowColMatcher.group(1);
            } else if (colRowMatcher.matches()) {
                res += "R" + colRowMatcher.group(2);
                res += 'C';
                long tmp = 0;
                for (Character c : colRowMatcher.group(1).toCharArray()) {
                    tmp*=26;
                    tmp += c - 'A' + 1;
                }
                res += tmp;
            }
            System.out.println(res);
        }
    }
}
