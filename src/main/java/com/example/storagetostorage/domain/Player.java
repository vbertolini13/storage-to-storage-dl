package com.example.storagetostorage.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class Player implements Serializable {

	private static final long serialVersionUID = -2016898454348556085L;

	private Integer id;
	private String name;
	private Integer age;
	private String urlPhoto;
	private String nationality;
	private Integer overall;
	private String club;
	private String price;
	
}
