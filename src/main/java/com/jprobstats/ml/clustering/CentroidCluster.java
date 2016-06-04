package com.jprobstats.ml.clustering;

public class CentroidCluster<T extends Clusterable> extends Cluster<T> {
    
    private final Clusterable center;
       
    public CentroidCluster(Clusterable center) {
        super();
       this.center=center;
    }
    
    public Clusterable getCenter() {
        return center;
    }


   

}
