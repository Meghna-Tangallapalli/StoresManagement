package com.storesmgt.api.Vo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name ="post")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostVo {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="Title")
	private String title;
	
	@Column(name ="Description")
	private String description;
	
	@Column(name ="Content")
	private String content;
	
}
