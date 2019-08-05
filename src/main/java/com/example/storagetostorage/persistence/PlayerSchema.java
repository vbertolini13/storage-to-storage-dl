package com.example.storagetostorage.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.api.services.bigquery.model.TableFieldSchema;
import com.google.api.services.bigquery.model.TableSchema;

public class PlayerSchema implements Serializable{

    /**
	 *
	 */
	private static final long serialVersionUID = -1784113519468859296L;

	public static TableSchema getTableSchema() {
        List<TableFieldSchema> fields = new ArrayList<>();
        fields.add(new TableFieldSchema().setName("ID").setType("INTEGER"));
        fields.add(new TableFieldSchema().setName("NAME").setType("STRING"));
        fields.add(new TableFieldSchema().setName("AGE").setType("INTEGER"));
        fields.add(new TableFieldSchema().setName("URL_PHOTO").setType("STRING"));
        fields.add(new TableFieldSchema().setName("NATIONALITY").setType("STRING"));
        fields.add(new TableFieldSchema().setName("OVERALL").setType("INTEGER"));
        fields.add(new TableFieldSchema().setName("CLUB").setType("STRING"));
        fields.add(new TableFieldSchema().setName("PRICE").setType("STRING"));
        return new TableSchema().setFields(fields);
    }

}
