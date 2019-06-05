// Date: 5 June 2019; Sophomore-Junior Summer
// Type: Problem Set Codeforces Type A
// Got AC: Yes
// Number of wrong submissions : 4
// Link: http://codeforces.com/problemset/problem/377/A
import java.util.Scanner;

public class Maze {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        int w = in.nextInt();
        int k = in.nextInt();
        in.nextLine();
        char[][] M = new char[h][w];
        int cells = 0;
        for (int i = 0; i < h; i++) {
            char[] nxt = in.nextLine().toCharArray();
            for(int x = 0; x < w; x++) {
                if(nxt[x] == '.') {
                    nxt[x] = 'X';
                    cells++;
                }
                M[i][x] = nxt[x];
            }
        }
        int sy = 0, sx = 0;
        for(int y = 0; y < h; y++) {
            for(int x = 0; x < w; x++) {
                if(M[y][x] == 'X') {
                    sy = y;
                    sx = x;
                    break;
                }
            }
        }
        flood(M, sy, sx, new int[]{cells - k});
        for(char[] r : M) {
            for(char c : r) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
    static void flood(char[][] M, int y, int x, int[] cells) {
        if(cells[0] == 0) return;
        M[y][x] = '.';
        cells[0]--;
        if(bounds(M, y + 1, x)) flood(M, y + 1, x, cells);
        if(bounds(M, y - 1, x)) flood(M, y - 1, x, cells);
        if(bounds(M, y, x + 1)) flood(M, y, x + 1, cells);
        if(bounds(M, y, x - 1)) flood(M, y, x - 1, cells);
    }

    static boolean bounds(char[][] M, int y, int x) {
        return !(y >= M.length || y < 0 || x >= M[y].length || x < 0 || M[y][x] == '#' || M[y][x] == '.');
    }
}
