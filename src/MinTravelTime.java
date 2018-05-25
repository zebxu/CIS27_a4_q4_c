public class MinTravelTime {
    private IndexMinPQ<Double>[] pq;

    /**
     *
     * @param G the given graph
     * @param s the number of station
     */
    public MinTravelTime(EdgeWeightedDigraph G, int s)
    {
        pq = (IndexMinPQ<Double>[]) new IndexMinPQ[G.V()];
        for (int v = 0; v < G.V(); v++)
            pq[v] = new IndexMinPQ<Double>(s);
    }

    /**
     *
     * @param dist distance to the Customer from the Station
     * @param station Station
     * @param customer Customer
     */
    public void addStation(double dist, int station, int customer)
    {
        pq[customer].insert(station, dist);
    }

    /**
     *
     * @param v Vertex
     * @return the station closest to the Vertex
     */
    public int shortestStation(int v)
    {
        return pq[v].minIndex();
    }

    public double shortestDist(int v)
    {
        return pq[v].minKey();
    }



}
