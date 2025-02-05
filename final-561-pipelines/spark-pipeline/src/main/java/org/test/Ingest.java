package org.test;

/*-
 * #%L
 * Test Project::Pipelines::Spark Pipeline
 * %%
 * Copyright (C) 2021 Booz Allen
 * %%
 * All Rights Reserved. You may not copy, reproduce, distribute, publish, display,
 * execute, modify, create derivative works of, transmit, sell or offer for resale,
 * or in any way exploit any part of this solution without Booz Allen Hamilton's
 * express written permission.
 * #L%
 */


import jakarta.enterprise.context.ApplicationScoped;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.SaveMode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;


/**
 * Performs the business logic for Ingest.
 *
 * Because this class is {@link ApplicationScoped}, exactly one managed singleton instance will exist
 * in any deployment.
 *
 * GENERATED STUB CODE - PLEASE ***DO*** MODIFY
 *
 * Originally generated from: templates/data-delivery-spark/synchronous.processor.impl.java.vm
 */
@ApplicationScoped
public class Ingest extends IngestBase {

    private static final Logger logger = LoggerFactory.getLogger(Ingest.class);

    public Ingest(){
        super("synchronous",getDataActionDescriptiveLabel());
    }

    /**
    * Provides a descriptive label for the action that can be used for logging (e.g., provenance details).
    *
    * @return descriptive label
    */
    private static String getDataActionDescriptiveLabel(){
        // TODO: replace with descriptive label
        return"Ingest";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void executeStepImpl() {
        Dataset<String> dataset = sparkSession.createDataset(List.of("one", "two", "three"), Encoders.STRING());
        dataset.write().format("hive").mode(SaveMode.Append).saveAsTable("htab");
        dataset.write().format("parquet").mode(SaveMode.Append).saveAsTable("ptab");

    }


}
