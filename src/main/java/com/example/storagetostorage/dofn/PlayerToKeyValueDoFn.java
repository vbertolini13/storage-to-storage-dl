package com.example.storagetostorage.dofn;

import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.values.KV;

import com.example.storagetostorage.domain.Player;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PlayerToKeyValueDoFn extends DoFn<Player, KV<String, Player>> {

    private static final long serialVersionUID = 78471626844184217L;

    @ProcessElement
	public void processElement(ProcessContext c) {
    	log.info(c.element().getNationality());
		c.output(KV.of(c.element().getNationality(), c.element()));
	}

}
