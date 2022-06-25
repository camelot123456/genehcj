package com.genehcj.entity;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditingEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@CreatedBy
	@Column(name = "create_by", nullable = false, length = 50, updatable = false)
	@JsonIgnore
	private String createBy;
	
	@CreatedDate
	@Column(name = "create_date", updatable = false)
	@JsonIgnore
	private Instant createDate = Instant.now();
	
	@LastModifiedBy
	@Column(name = "last_modified_by", nullable = false, length = 50, updatable = false)
	@JsonIgnore
	private String lastModifiedBy;
	
	@LastModifiedDate
	@Column(name = "last_modified_date")
	@JsonIgnore
	private Instant lastModifiedDate = Instant.now();
	
}
