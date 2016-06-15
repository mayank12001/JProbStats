package com.jprobstats.ml.clustering;

import static org.junit.Assert.assertEquals;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jprobstats.ml.exception.NullArgumentException;

import au.com.bytecode.opencsv.CSVReader;

public class KMeansPlusPlusClustererTest {

    private Collection<Clusterable> vectors = new ArrayList<Clusterable>();
    private CSVReader reader;
    private KMeansPlusPlusClusterer<Clusterable> kMeansClusterer;


    // Setup
    // ------------------------------------------------------------------------

    @Before
    public void setup() throws IOException {
        kMeansClusterer = new KMeansPlusPlusClusterer<Clusterable>(3);
        reader = new CSVReader(new FileReader("src/test/resources/data.csv"));
        List<String[]> records = reader.readAll();
        Set<double[]> data = records.stream().map(record -> {
            double[] nums = new double[record.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Double.parseDouble(record[i]);
            }
            return nums;
        }).collect(Collectors.toSet());
        data.stream().forEach(doubleArray -> {
            vectors.add(new DoublePoint(doubleArray));
        });
    }

    @After
    public void teardown() throws IOException {
        reader.close();
        kMeansClusterer = null;
    }



    // Tests
    // ------------------------------------------------------------------------

    @Test(expected = NullArgumentException.class)
    public void test_cluster_null() {
        Collection<Clusterable> vectors = null;
        List<CentroidCluster<Clusterable>> clusters = kMeansClusterer.cluster(vectors);
    }

    @Test
    public void test_cluster() {
        List<CentroidCluster<Clusterable>> clusters = kMeansClusterer.cluster(vectors);
        assertEquals(3, clusters.size());


    }


}
