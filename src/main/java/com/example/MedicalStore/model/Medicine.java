package com.example.MedicalStore.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.springframework.transaction.annotation.Transactional;

import lombok.Getter;
import lombok.Setter;

@Entity

//@NamedEntityGraph(name = "MedicineStoreEntityGraph", attributeNodes = {
//		@NamedAttributeNode("medId"), @NamedAttributeNode("storeId")},
//subgraphs = @NamedSubgraph(name = "storeEntityGraph", attributeNodes= {@NamedAttributeNode("storeType")}))

@NamedEntityGraph(
		  name = "MedicineStoreEntityGraph",
		  attributeNodes = {
		    @NamedAttributeNode("medId"),
		    @NamedAttributeNode(value = "storeId", subgraph = "storeEntityGraph"),
		  },
		  subgraphs = {
		    @NamedSubgraph(
		      name = "storeEntityGraph",
		      attributeNodes = {
		        @NamedAttributeNode("storeType")
		      }
		    )
		  }
		)
@Table(name="medicine_details")
@Getter
@Setter
//@ToString
@Transactional
public class Medicine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "medicine_detail_id")
	@TableGenerator(name="tableKeyGenerator")
	private long id;
	
	
	@Column(name="MedicineNAme")
	private String medName;
	
	
	@Column(name="MedicineDetail")
	private String medDetail;
	
	@Column(name="MedicinePrice")
	private float medPrice;
	
	@Column(name="MedicineQuantity")
	private int quantitiy;
	
	
//	@CreationTimestamp
//	@UpdateTimestamp
//	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="MedicineExpiry")
	private Date expiry;
	
	
//	@Transient
	@ManyToOne(fetch=FetchType.LAZY, targetEntity = MedicalStore.class,cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name= "medical_store_id", referencedColumnName ="medical_store_id")
//	@Column(name="Store_Id")
	private MedicalStore storeId;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name= "medicine_type_id")
//	@Column(name="Medicine_Type_Id")
	private MedicineType medId;
	
	
	

	public Medicine() {
		super();
	}
	
	
	public Medicine(MedicalStore storeId) {
		super();
		this.storeId = storeId;
	}
	
	
	public Medicine(long id, String medName, String medDetail, float medPrice, int quantitiy, Date expiry,
			MedicalStore storeId, MedicineType medId) {
		super();
		this.id = id;
		this.medName = medName;
		this.medDetail = medDetail;
		this.medPrice = medPrice;
		this.quantitiy = quantitiy;
		this.expiry = expiry;
		this.storeId = storeId;
		this.medId = medId;
	}
	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMedName() {
		return medName;
	}

	public void setMedName(String medName) {
		this.medName = medName;
	}

	public String getMedDetail() {
		return medDetail;
	}

	public void setMedDetail(String medDetail) {
		this.medDetail = medDetail;
	}

	public float getMedPrice() {
		return medPrice;
	}

	public void setMedPrice(float medPrice) {
		this.medPrice = medPrice;
	}

	public int getQuantitiy() {
		return quantitiy;
	}

	public void setQuantitiy(int quantitiy) {
		this.quantitiy = quantitiy;
	}

//	public Date getExpiry() {
//		return expiry;
//	}
//
//	public void setExpiry(Date expiry) {
//		this.expiry = expiry;
//	}

	public MedicalStore getStoreId() {
		return storeId;
	}

	

	public void setStoreId(MedicalStore storeId) {
		this.storeId = storeId;
	}

	public Date getExpiry() {
		return expiry;
	}

	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}
	
	
	public MedicineType getMedId() {
		return medId;
	}

	public void setMedId(MedicineType medId) {
		this.medId = medId;
	}

	

//	public void addAttribute(String string, Object fetchAllMedicine) {
//		// TODO Auto-generated method stub
//		
//	}
}
