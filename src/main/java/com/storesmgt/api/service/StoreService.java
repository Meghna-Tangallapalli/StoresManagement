package com.storesmgt.api.service;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.storesmgt.api.Vo.StoreVo;
import com.storesmgt.api.model.StoreEntity;

@Component
public interface StoreService {

	StoreVo saveStore(StoreVo storeVo);
	
	List<StoreEntity> getStores() throws URISyntaxException;
	
	StoreVo updateStore(StoreVo storeVo);
	
	String deleteStore(Long id);
	
	
}
