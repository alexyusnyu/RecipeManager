package com.aldrin.foodfam.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OptimisticLocking;


import java.io.Serializable;
import java.util.Date;
import org.springframework.data.jpa.repository.Temporal;


@Setter
@Getter
@DynamicUpdate
@MappedSuperclass
@OptimisticLocking
public class Base implements Serializable {

}
