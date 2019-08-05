package com.example.storagetostorage.transform;

import java.util.List;

import org.apache.beam.sdk.transforms.PTransform;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PCollection;

import com.example.storagetostorage.dofn.GkbToStringBestDoFn;

public class GkbToStringBestTransform extends PTransform<PCollection<List<KV<String,Long>>>, PCollection<String>>{

    /**
     * 
     */
    private static final long serialVersionUID = 32857647873620144L;

    @Override
    public PCollection<String> expand(PCollection<List<KV<String,Long>>> input) {
        return input.apply(ParDo.of(new GkbToStringBestDoFn()));
    }
}
