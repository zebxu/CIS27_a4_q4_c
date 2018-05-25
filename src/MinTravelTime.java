public class MinTravelTime {

    private IndexMinPQ<Double>[] pq; // pq[customer] Minimum Priory Queue of travel time

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
     * Insert the data for each customer
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
     * Get the nearest station
     *
     * @param v Vertex
     * @return the station closest to the Vertex
     */
    public int shortestStation(int v)
    {
        return pq[v].minIndex();
    }

    /**
     * Get the travel time from the nearest station
     *
     * @param v
     * @return
     */
    public double shortestDist(int v)
    {
        return pq[v].minKey();
    }



}
