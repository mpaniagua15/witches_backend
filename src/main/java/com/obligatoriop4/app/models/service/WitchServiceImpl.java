package com.obligatoriop4.app.models.service;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.obligatoriop4.app.models.dao.IWitchDAO;
import com.obligatoriop4.app.models.entity.Common;
import com.obligatoriop4.app.models.entity.Supreme;
import com.obligatoriop4.app.models.entity.Witch;

@Service
public class WitchServiceImpl implements IWitchService {

	@Autowired
	private IWitchDAO witchDao;
	
	@Override
	@Transactional(readOnly = true)
	public Page<Witch> findAll(int page, int pageSize, Sort sort, Optional<Integer> witchId, Optional<String> witchName) {
		
		if(witchId.isPresent()) {
			Optional<Witch> witchOpt = witchDao.findById(witchId.get());
			return witchOpt.map(w -> (Page<Witch>) new PageImpl<>(Arrays.asList(w))).orElse(Page.empty());
		}
		
		final Pageable p = PageRequest.of(page, pageSize, sort);
		
		return witchName
				.map(wn -> witchDao.findByWitchName(wn, p))
				.orElse(witchDao.findAll(p));
		
	}

	@Override
	@Transactional(readOnly = true)
	public Witch findById(int id) {
		return witchDao.findById(id).orElse(null);
	}
	
	@Override
	public void delete(int id) {
		//TODO validate if it is a Supreme, all the common references.
		witchDao.deleteById(id);
	}

	@Override
	@Transactional
	public Supreme saveSupreme(Supreme witch) {
		return witchDao.save(witch);
	}

	@Override
	@Transactional
	public Common saveCommon(Common witch) {
		//TODO validate existence of supreme.
		Supreme supremeWitch = (Supreme) this.findById(witch.getSupremeWitch().getId());
		witch.setSupremeWitch(supremeWitch);
		return witchDao.save(witch);
	}


}
