package com.example.storagetostorage.transform;

import org.apache.beam.sdk.transforms.PTransform;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;

import com.example.storagetostorage.dofn.StringToPlayerDoFn;
import com.example.storagetostorage.domain.Player;



public class StringToPlayerTransform extends PTransform<PCollection<String>, PCollection<Player>>{

    /**
     * 
     */
    private static final long serialVersionUID = 32857647873620144L;

    @Override
    public PCollection<Player> expand(PCollection<String> input) {
        return input.apply(ParDo.of(new StringToPlayerDoFn()));
    }
}
