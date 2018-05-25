import java.io.File;

public class programming_assignment_4_d {
    public static void main(String[] args) {
        File file = new File("/Users/zeyangxu/Java Projects/ShortestPath/src/graph_3_c");
        In in = new In(file);
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);

        int s = 7;

        DijkstraSP sp = new DijkstraSP(G, s);

        // print shortest path
        for (int t = 0; t < G.V(); t++) {
            if (sp.hasPathTo(t)) {
                StdOut.printf("%d to %d (%.2f)  ", s, t, sp.distTo(t));
                for (DirectedEdge e : sp.pathTo(t)) {
                    StdOut.print(e + "   ");
                }
                StdOut.println();
            }
            else {
                StdOut.printf("%d to %d         no path\n", s, t);
            }
        }
    }
}
