package com.storesmgt.api.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.storesmgt.api.Vo.StoreVo;
import com.storesmgt.api.model.StoreEntity;
import com.storesmgt.api.service.StoreService;



@RestController
@RequestMapping("api/store")
public class StoreController {

	@Autowired
	private StoreService storeService;
	
	@PostMapping("/savestore")
	public StoreVo saveStore(@RequestBody StoreVo storeVo) {
		return storeService.saveStore(storeVo);
	}
	
	@GetMapping("/getstores")
	public List<StoreEntity> getStores() throws URISyntaxException{
		return storeService.getStores();
	}
	
	@PutMapping("/updatestore")
	public StoreVo updateStore(@RequestBody StoreVo storeVo) {
		return storeService.updateStore(storeVo);
	}
		
	@DeleteMapping("/deletestore")
	public String deleteStore(@RequestParam Long id) {
		return "store deleted";
	}
	
	
	
}
