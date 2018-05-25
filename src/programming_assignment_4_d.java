import java.io.File;

public class programming_assignment_4_d {
    public static void main(String[] args) {
        File file = new File("/Users/zeyangxu/Java Projects/ShortestPath/src/graph_3_c");
        In in = new In(file);
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);

        DijkstraSP[] sp = new DijkstraSP[5];

        sp[0] = new DijkstraSP(G, 7);
        sp[1] = new DijkstraSP(G, 14);
        sp[2] = new DijkstraSP(G, 25);
        sp[3] = new DijkstraSP(G, 28);
        sp[4] = new DijkstraSP(G, 40);

        MinTravelTime mtt = new MinTravelTime(G, 5);

        // print shortest path
        for (int s = 0; s < 5; s++)
        {
            for (int t = 0; t < G.V(); t++) {
                if (sp[s].hasPathTo(t)) {
                    mtt.addStation(sp[s].distTo(t), s, t);
                    //StdOut.printf("%d to %d (%.2f)  ", s, t, sp.distTo(t));
//                for (DirectedEdge e : sp.pathTo(t)) {
//                    StdOut.print(e + "   ");
//                }
//                    StdOut.println();
                }
                else {
                    StdOut.printf("%d to %d         no path\n", s, t);
                }
            }
        }

        for (int t = 0; t < G.V(); t++)
        {
            if (t == 7 || t == 14 || t == 25 || t==28 || t == 40) continue;
            int s = mtt.shortestStation(t);
            double dist = mtt.shortestDist(t);
            StdOut.printf("Customer %d : Station %d (%.2f)   ", t, sp[s].getSource(), dist);
            for (DirectedEdge e : sp[s].pathTo(t))
            {
                StdOut.print(e + " ");
            }
            StdOut.println();
        }
    }
}

// Console Output:
//
//        Customer 0 : Station 7 (52.00)   7->5 15.00 5->6 20.00 6->0 17.00
//        Customer 1 : Station 7 (28.00)   7->5 15.00 5->1 13.00
//        Customer 2 : Station 14 (30.00)   14->3 15.00 3->2 15.00
//        Customer 3 : Station 14 (15.00)   14->3 15.00
//        Customer 4 : Station 7 (31.00)   7->4 31.00
//        Customer 5 : Station 7 (15.00)   7->5 15.00
//        Customer 6 : Station 7 (35.00)   7->5 15.00 5->6 20.00
//        Customer 8 : Station 14 (30.00)   14->3 15.00 3->8 15.00
//        Customer 9 : Station 14 (46.00)   14->3 15.00 3->9 31.00
//        Customer 10 : Station 14 (44.00)   14->12 22.00 12->10 22.00
//        Customer 11 : Station 40 (41.00)   40->45 20.00 45->11 21.00
//        Customer 12 : Station 14 (22.00)   14->12 22.00
//        Customer 13 : Station 14 (64.00)   14->15 36.00 15->13 28.00
//        Customer 15 : Station 14 (36.00)   14->15 36.00
//        Customer 16 : Station 7 (25.00)   7->16 25.00
//        Customer 17 : Station 7 (20.00)   7->17 20.00
//        Customer 18 : Station 14 (36.00)   14->21 16.00 21->18 20.00
//        Customer 19 : Station 14 (23.00)   14->19 23.00
//        Customer 20 : Station 14 (35.00)   14->20 35.00
//        Customer 21 : Station 14 (16.00)   14->21 16.00
//        Customer 22 : Station 28 (30.00)   28->22 30.00
//        Customer 23 : Station 28 (18.00)   28->23 18.00
//        Customer 24 : Station 25 (25.00)   25->24 25.00
//        Customer 26 : Station 25 (30.00)   25->26 30.00
//        Customer 27 : Station 28 (43.00)   28->27 43.00
//        Customer 29 : Station 25 (40.00)   25->24 25.00 24->29 15.00
//        Customer 30 : Station 25 (30.00)   25->30 30.00
//        Customer 31 : Station 25 (21.00)   25->31 21.00
//        Customer 32 : Station 7 (30.00)   7->32 30.00
//        Customer 33 : Station 40 (58.00)   40->46 28.00 46->33 30.00
//        Customer 34 : Station 28 (30.00)   28->34 30.00
//        Customer 35 : Station 28 (25.00)   28->35 25.00
//        Customer 36 : Station 40 (30.00)   40->36 30.00
//        Customer 37 : Station 25 (50.00)   25->37 50.00
//        Customer 38 : Station 25 (61.00)   25->31 21.00 31->38 40.00
//        Customer 39 : Station 40 (48.00)   40->46 28.00 46->39 20.00
//        Customer 41 : Station 40 (27.00)   40->41 27.00
//        Customer 42 : Station 28 (50.00)   28->34 30.00 34->42 20.00
//        Customer 43 : Station 40 (41.00)   40->41 27.00 41->43 14.00
//        Customer 44 : Station 28 (74.00)   28->34 30.00 34->42 20.00 42->44 24.00
//        Customer 45 : Station 40 (20.00)   40->45 20.00
//        Customer 46 : Station 40 (28.00)   40->46 28.00
//        Customer 47 : Station 40 (56.00)   40->41 27.00 41->43 14.00 43->47 15.00
//        Customer 48 : Station 40 (43.00)   40->46 28.00 46->48 15.00
//        Customer 49 : Station 40 (63.00)   40->46 28.00 46->49 35.00
