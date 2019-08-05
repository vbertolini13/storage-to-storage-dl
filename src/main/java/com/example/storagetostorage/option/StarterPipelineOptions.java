package com.example.storagetostorage.option;

import org.apache.beam.sdk.options.Default;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;

public interface StarterPipelineOptions extends PipelineOptions {
    
    @Description("Input file on storage gcp")
    @Default.String("gs://dataflow-inputs/input_fifa.csv")
    String getInputFile();
    void setInputFile(String value);

    @Description("Output best file on storage gcp")
    @Default.String("gs://dataflow-inputs/output_best_fifa.csv")
    String getOutputBestFile();
    void setOutputBestFile(String value);
    
    @Description("Id project.")
    @Default.String("civil-medley-236513")
    String getProjectId();
    void setProjectId(String value);

}
