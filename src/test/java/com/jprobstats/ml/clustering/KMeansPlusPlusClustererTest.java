package com.jprobstats.ml.clustering;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import au.com.bytecode.opencsv.CSVReader;

public class KMeansPlusPlusClustererTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(KMeansPlusPlusClustererTest.class);

    private Collection<Clusterable> vectors = new ArrayList<Clusterable>();


    // Setup
    // ------------------------------------------------------------------------

    @Before
    public void setup() throws IOException {
        CSVReader reader = new CSVReader(new FileReader("src/test/resources/data.csv"));
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

    @Test
    public void test_cluster() {

        KMeansPlusPlusClusterer<Clusterable> kMeansClusterer = new KMeansPlusPlusClusterer<Clusterable>(2);
        List<CentroidCluster<Clusterable>> clusters = kMeansClusterer.cluster(vectors);
        LOGGER.debug(clusters.toString());
    }


}
