import java.util.ArrayList;
import java.util.Scanner;

public class KefaAndPark {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nnodes = in.nextInt();
        int ncatsAllowed = in.nextInt();
        boolean[] hasCat = new boolean[nnodes];
        ArrayList<ArrayList<Integer>> G = new ArrayList<>();
        for (int i = 0; i < nnodes; i++) {
            G.add(i, new ArrayList<>());
            hasCat[i] = in.nextInt() == 1;
        }
        for (int i = 0; i < nnodes - 1; i++) {
            int v1 = in.nextInt() - 1;
            int v2 = in.nextInt() - 1;
            G.get(v1).add(v2);
            G.get(v2).add(v1);
        }
        System.out.println(r(new boolean[nnodes], hasCat, G, 0, 0, ncatsAllowed + 1));
    }

    static int r(boolean[] visited, boolean[] hasCat, ArrayList<ArrayList<Integer>> G, int current, int ncats, int allowedCats) {
        if (visited[current]) return 0;
        visited[current] = true;
        if (hasCat[current]) ncats++;
        else ncats = 0;
        if (ncats == allowedCats) return 0;
        int numEdges = 0;
        int res = 0;
        for (int i = 0; i < G.size(); i++) {
            if (G.get(current).contains(i)) {
                numEdges++;
                res += r(visited, hasCat, G, i, ncats, allowedCats);
            }
        }
        if (numEdges <= 1 && current != 0) res++;
        return res;
    }
}