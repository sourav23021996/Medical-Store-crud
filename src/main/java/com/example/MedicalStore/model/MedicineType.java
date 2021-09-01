package com.example.MedicalStore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="medicine_type")
@Getter
@Setter
@NoArgsConstructor
public class MedicineType {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "medicine_type_id")
	@TableGenerator(name="tableKeyGenerator")
	private long id;
	
	
	
	@Column(name="medicine_type_name")
	private String medTypeName;
	
	
	@Column(name="description")
	private String description;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getMedTypeName() {
		return medTypeName;
	}


	public void setMedTypeName(String medTypeName) {
		this.medTypeName = medTypeName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
}
