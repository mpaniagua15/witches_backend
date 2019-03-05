package com.obligatoriop4.app.models.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import com.obligatoriop4.app.models.entity.Common;
import com.obligatoriop4.app.models.entity.Supreme;
import com.obligatoriop4.app.models.entity.Witch;

public interface IWitchService {

	Page<Witch> findAll(int page, int pageSize, Sort sort, Optional<Integer> witchId, Optional<String> witchName);
	
	Witch findById(int id);
	
	Supreme saveSupreme(Supreme witch);

	Common saveCommon(Common witch);
	
	void delete(int id);
}
