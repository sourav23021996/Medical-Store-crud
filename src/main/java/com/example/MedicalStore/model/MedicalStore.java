package com.example.MedicalStore.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

import lombok.NoArgsConstructor;

@NamedEntityGraph(name = "storeEntityGraph", attributeNodes = {
@NamedAttributeNode("storeType")})
@Entity
@Table(name="medical_store")
@NoArgsConstructor
@Transactional
public class MedicalStore implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "medical_store_id")
	@TableGenerator(name="tableKeyGenerator")
	
	public Long id;
	

//	@Transient
	
//	@JsonIdentityReference
	@Column(name="StoreName")
	private String storeName;
	
	
	@Column(name="UserName")
	private String userName;
	
	@Column(name="Password")
	private String password;
	
	@Column(name="StoreEmailId")
	private String storeEmailId;
	
	@Column(name="MobileNumber")
	private String mobileNumber;

	
	@Column(name="Address1")
	private String addressone;
	
	
	@Column(name="Address2")
	private String addresstwo;
	
	
	@Column(name="Store_License")
	private int storeLicense;
	
	@ManyToOne(fetch=FetchType.LAZY,targetEntity = StoreType.class)
	@JoinColumn(name= "store_type_id")
//	@Transient
//	@Column(name="Store_Type_Id")
	StoreType storeType;
	
	
	@Column(name="Store_Registration")
	private String storeRegistration;

	@Transient
	@OneToMany(targetEntity = Medicine.class, mappedBy = "storeId")
	@Fetch(value = FetchMode.SUBSELECT)
	public List<Medicine> medicines=new ArrayList<Medicine>();
	
	
//	public MedicalStore() {
//		
//	}
	
	
	
public MedicalStore(Long id, String storeName, String userName, String password, String storeEmailId,
			String mobileNumber, String addressone, String addresstwo, int storeLicense, StoreType storeType,
			String storeRegistration) {
		super();
		this.id = id;
		this.storeName = storeName;
		this.userName = userName;
		this.password = password;
		this.storeEmailId = storeEmailId;
		this.mobileNumber = mobileNumber;
		this.addressone = addressone;
		this.addresstwo = addresstwo;
		this.storeLicense = storeLicense;
		this.storeType = storeType;
		this.storeRegistration = storeRegistration;
	}


public MedicalStore(Long id, String storeName) {
	super();
	this.id = id;
	this.storeName = storeName;
}

//	??FOR THYME LEAF
	
//	@OneToMany(fetch=FetchType.LAZY, mappedBy="storeName")
//	private Set<MedicalStore> medicine=new HashSet<MedicalStore>(0);
//
//	
	
	
	
	
	
	
	
	
//	jsjdhkjsagdkhgsakhdgsahgdkhgsa
	

	
	
	
	public List<Medicine> getMedicine() {
		return medicines;
	}


	public void setMedicine(List<Medicine> medicine) {
		this.medicines = medicines;
	}


	public Long getId() {
		return id;
	}


	


	public void setId(Long id) {
		this.id = id;
	}


	public String getStoreName() {
		return storeName;
	}


	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getStoreEmailId() {
		return storeEmailId;
	}


	public void setStoreEmailId(String storeEmailId) {
		this.storeEmailId = storeEmailId;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getAddressone() {
		return addressone;
	}


	public void setAddressone(String addressone) {
		this.addressone = addressone;
	}


	public String getAddresstwo() {
		return addresstwo;
	}


	public void setAddresstwo(String addresstwo) {
		this.addresstwo = addresstwo;
	}


	public int getStoreLicense() {
		return storeLicense;
	}


	public void setStoreLicense(int storeLicense) {
		this.storeLicense = storeLicense;
	}


	


	public StoreType getStoreType() {
		return storeType;
	}


	public void setStoreType(StoreType storeType) {
		this.storeType = storeType;
	}


	public String getStoreRegistration() {
		return storeRegistration;
	}


	public void setStoreRegistration(String storeRegistration) {
		this.storeRegistration = storeRegistration;
	}
	
	
}
