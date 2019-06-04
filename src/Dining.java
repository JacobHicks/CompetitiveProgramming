// Date: 3 June 2019; Sophomore-Junior Summer
// Type: USACO Gold December
// Got AC: Yes
// Time taken for coming up with algorithm: 0:25
// Ideal Time Taken: < 0:40
// Time Taken to Implement: Not measured. USACO network outage
// Number of wrong submissions : 0
// Link: http://usaco.org/index.php?page=viewproblem2&cpid=861

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Dining {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("dining.in"));
        PrintWriter out = new PrintWriter(new File("dining.out"));
        int N = in.nextInt();
        int M = in.nextInt();
        int K = in.nextInt();
        int[][] G = new int[N][N];
        int[] hay = new int[N];
        int maxLast = 0;
        while (M-- > 0) {
            int s = in.nextInt() - 1;
            int d = in.nextInt() - 1;
            int t = in.nextInt();

            maxLast = Math.max(t, maxLast);
            G[s][d] = t;
            G[d][s] = t;
        }
        while (K-- > 0) {
            hay[in.nextInt() - 1] = in.nextInt();
        }

        for(int i = 0; i < N - 1; i++) {
            Object[] res = move(new int[N][maxLast + 1][2], G, hay, i, 0, N - 1, 0, false);
            out.println(((boolean)res[1]) ? "1" : "0");
        }
        out.close();
    }

    private static Object[] move(int[][][] visited, int[][] G, int[] hay, int node, int time, int dest, int last, boolean eaten) {
        Object[] res = new Object[]{Integer.MAX_VALUE, eaten};
        if(node == dest) res[0] = time;
        if(eaten && node == dest) return res;
        if(visited[node][last][eaten ? 1 : 0] != 0) return new Object[]{visited[node][last][eaten ? 1 : 0], eaten};
        visited[node][last][eaten ? 1 : 0] = Integer.MAX_VALUE;
        for(int edge = 0; edge <= dest; edge++) {
            if(G[node][edge] != 0) {
                Object[] tmpres = move(visited, G, hay, edge, time + G[node][edge], dest, G[node][edge], eaten);
                if((int)res[0] > (int)tmpres[0]) {
                    res = tmpres;
                }
            }
        }
        if(!eaten && hay[node] != 0) {
            for(int edge = 0; edge <= dest; edge++) {
                if(G[node][edge] != 0) {
                    Object[] tmpres = move(visited, G, hay, edge, time + G[node][edge] - hay[node], dest, G[node][edge], true);
                    if((int)res[0] > (int)tmpres[0]) {
                        res = tmpres;
                    }
                }
            }
        }
        visited[node][last][eaten ? 1 : 0] = (int)res[0];
        return res;
    }
}
