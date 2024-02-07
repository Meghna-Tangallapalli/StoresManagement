package com.storesmgt.api.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.storesmgt.api.Vo.PostVo;
import com.storesmgt.api.Vo.StoreVo;
import com.storesmgt.api.config.Config;
import com.storesmgt.api.model.StoreEntity;
import com.storesmgt.api.repository.StoreRepository;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreRepository storeRepository;

	@Autowired
	private Config config;
	
	@Autowired
	private RestTemplate restTemplate;

	// save
	@Override
	public StoreVo saveStore(StoreVo storeVo) {

		// Vo to Entity
		StoreEntity storeEntity = new StoreEntity();
		storeEntity.setId(storeVo.getId());
		storeEntity.setStoreName(storeVo.getStoreName());
		storeEntity.setPhoneNumber(storeVo.getPhoneNumber());
		storeEntity.setProduct(storeVo.getProduct());
		storeEntity.setLocation(storeVo.getLocation());

		// save to db
		StoreEntity save = storeRepository.save(storeEntity);

		// entity to vo
		StoreVo storeVo1 = new StoreVo();
		storeVo1.setId(save.getId());
		storeVo1.setStoreName(save.getStoreName());
		storeVo1.setPhoneNumber(save.getPhoneNumber());
		storeVo1.setProduct(save.getProduct());
		storeVo1.setLocation(save.getLocation());

		return storeVo1;
	}

	// get list
	@Override
	public List<StoreEntity> getStores() throws URISyntaxException {
		/*Long value = 3L;
		PostVo postFromPostService = getPostFromPostService(value);
		System.out.println(postFromPostService.getTitle());*/
		return storeRepository.findAll();

	}

	// update
	@Override
	public StoreVo updateStore(StoreVo storeVo) {
		Optional<StoreEntity> storeOptional = storeRepository.findById(storeVo.getId());
		StoreEntity storeEntity = storeOptional.get();
		if (storeOptional.isPresent()) {
			storeEntity.setId(storeVo.getId());
			storeEntity.setStoreName(storeVo.getStoreName());
			storeEntity.setPhoneNumber(storeVo.getPhoneNumber());
			storeEntity.setProduct(storeVo.getProduct());
			storeEntity.setLocation(storeVo.getLocation());

			StoreEntity save = storeRepository.save(storeEntity);

			StoreVo storeVo2 = new StoreVo();
			storeVo2.setId(save.getId());
			storeVo2.setStoreName(save.getStoreName());
			storeVo2.setPhoneNumber(save.getPhoneNumber());
			storeVo2.setProduct(save.getProduct());
			storeVo2.setLocation(save.getLocation());

			return storeVo2;
		} else {
			throw new RuntimeException("details not found for the id" + storeVo.getId());
		}
	}

	// delete
	@Override
	public String deleteStore(Long id) {
		Optional<StoreEntity> storeEntity = storeRepository.findById(id);
		if (storeEntity.isPresent()) {
			storeRepository.delete(storeEntity.get());
		}
		return "bank deleted";
	}

	private PostVo getPostFromPostService(Long id) throws URISyntaxException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<?> entity = new HttpEntity<Long>(headers);
		URI uri = null;

		uri = UriComponentsBuilder.fromUri(new URI(config.getGetPostDetails() + "?id=" + id)).build().encode()
				.toUri();

		ResponseEntity<PostVo> getPostDetails1 = restTemplate.exchange(uri, HttpMethod.GET, entity,
				PostVo.class);
		PostVo postVo = getPostDetails1.getBody();
		return postVo;
	}

}
