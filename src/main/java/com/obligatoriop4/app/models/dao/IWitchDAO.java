package com.obligatoriop4.app.models.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.obligatoriop4.app.models.entity.Witch;

public interface IWitchDAO extends PagingAndSortingRepository<Witch, Integer> {
	
	 @Query(value = "select w from Witch w where w.name like %:name%")
	 Page<Witch> findByWitchName(@Param("name") String witchName, Pageable pageable);
	

}
