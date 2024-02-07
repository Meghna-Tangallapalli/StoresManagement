package com.storesmgt.api.Vo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name= "Store")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class StoreVo {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name= "Id")
		private Long id;
		
		@Column(name= "Store_Name")
		private String storeName;
		
		@Column(name= "Phone_Number")
		private String phoneNumber;
		
		@Column(name= "Product")
		private String product;
		
		@Column(name= "Location")
		private String location;

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

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getProduct() {
			return product;
		}

		public void setProduct(String product) {
			this.product = product;
		}
		
}
		

