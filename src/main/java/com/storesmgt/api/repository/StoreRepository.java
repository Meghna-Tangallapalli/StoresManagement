package com.storesmgt.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.storesmgt.api.model.StoreEntity;

@Repository
public interface StoreRepository extends JpaRepository<StoreEntity, Long>{

}
