package com.example.MedicalStore.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.springframework.data.annotation.Transient;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="store_type")
@Getter
@Setter
//@Transactional
public class StoreType implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "store_type_id")
	@TableGenerator(name="tableKeyGenerator")
	private long id;
	
	
//	@javax.persistence.Transient
	@Column(name="type_name")
	private String typeName;

//	@javax.persistence.Transient
	@OneToMany(targetEntity = MedicalStore.class, mappedBy = "storeName")
	List<MedicalStore> store;

	
	
	public StoreType() {
		super();
	}
	
	

	public StoreType(long id, String typeName, List<MedicalStore> store) {
		super();
		this.id = id;
		this.typeName = typeName;
		this.store = store;
	}
	
	
	public StoreType(long id, String typeName) {
		super();
		this.id = id;
		this.typeName = typeName;
	
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getTypeName() {
		return typeName;
	}



	public void setTypeName(String typeName) {
		typeName = typeName;
	}
	
	
	
}
