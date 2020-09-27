package com.main.JhumoShop.midelData;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name="ladycloth")
@Data
public class Sarees {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="design")
	private String design;
	@Column(name="price")
	private String price;
	@Column(name="picByte",length=1000)
	private byte[] picByte;

	
}
