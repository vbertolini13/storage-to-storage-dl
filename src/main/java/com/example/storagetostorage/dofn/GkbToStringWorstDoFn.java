package com.example.storagetostorage.dofn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.values.KV;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GkbToStringWorstDoFn extends  DoFn<List<KV<String,Long>>, String> {

    private static final long serialVersionUID = 78471626844184217L;

    @ProcessElement
	public void processElement(ProcessContext c) {
		List<KV<String, Long>> sorted = new ArrayList<>(c.element());
		Collections.sort(sorted, new KV.OrderByValue<>());
		
		StringBuffer sb = new StringBuffer();
		for (KV<String, Long> kv : c.element()) {
			log.info(kv.getKey() + "," + kv.getValue() + '\n');
			sb.append(kv.getKey() + "," + kv.getValue() + '\n');
		}
		c.output(sb.toString());
	}


}
