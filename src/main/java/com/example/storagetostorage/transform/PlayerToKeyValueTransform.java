package com.example.storagetostorage.transform;

import org.apache.beam.sdk.transforms.PTransform;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PCollection;

import com.example.storagetostorage.dofn.PlayerToKeyValueDoFn;
import com.example.storagetostorage.domain.Player;



public class PlayerToKeyValueTransform extends PTransform<PCollection<Player>,PCollection<KV<String,Player>>>{

    /**
     * 
     */
    private static final long serialVersionUID = 32857647873620144L;

    @Override
	public PCollection<KV<String, Player>> expand(PCollection<Player> input) {
		return input.apply(ParDo.of(new PlayerToKeyValueDoFn()));
	}
}
