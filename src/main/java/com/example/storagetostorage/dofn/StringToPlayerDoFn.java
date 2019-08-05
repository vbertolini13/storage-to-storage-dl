package com.example.storagetostorage.dofn;

import org.apache.beam.sdk.transforms.DoFn;

import com.example.storagetostorage.domain.Player;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringToPlayerDoFn extends DoFn<String, Player> {

    private static final long serialVersionUID = 78471626844184217L;

    @ProcessElement
    public void processElement(ProcessContext c, OutputReceiver<Player> out) {
        log.info(c.element());

		if(c.element() != null) {
			String[] splitted = c.element().split(",");
	        Player p = new Player();
	        p.setId(Integer.valueOf(splitted[1]));
	        p.setName(splitted[2]);
	        p.setAge(Integer.valueOf(splitted[3]));
	        p.setUrlPhoto(splitted[4]);
	        p.setNationality(splitted[5]);
	        p.setOverall(Integer.valueOf(splitted[7]));
	        p.setClub(splitted[9]);
	        p.setPrice(splitted[10]);
		    out.output(p);
		}
    }

}
