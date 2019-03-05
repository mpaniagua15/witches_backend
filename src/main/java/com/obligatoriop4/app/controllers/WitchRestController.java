package com.obligatoriop4.app.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.obligatoriop4.app.api.SortFieldWitch;
import com.obligatoriop4.app.models.entity.Common;
import com.obligatoriop4.app.models.entity.Supreme;
import com.obligatoriop4.app.models.entity.Witch;
import com.obligatoriop4.app.models.service.IWitchService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class WitchRestController {
	
	@Autowired
	private IWitchService witchService;
	
	@GetMapping("/witches")
	public Page<Witch> index(
			@RequestParam (name="page_number", defaultValue = "0") int page,
			@RequestParam (name="page_size", defaultValue = "10") int pageSize,
			@RequestParam (name="sort_by", defaultValue = "id") SortFieldWitch sort,
			@RequestParam (name="sort_direction", defaultValue = "ASC") Direction direction,
			@RequestParam (name="filter_name", required=false) Optional<String> witchName,
			@RequestParam (name="filter_id", required=false) Optional<Integer> witchId
			) {
		Sort sortBy = Sort.by(direction, sort.name());
		return witchService.findAll(page, pageSize, sortBy, witchId, witchName);
	}
	
	@GetMapping("/witches/{id}")
	public Witch show(@PathVariable int id) {
		//TODO send exception if not found exception controller advice
		return this.witchService.findById(id);
	}
	
	@PostMapping("/witches/supreme")
	@ResponseStatus(HttpStatus.CREATED)
	public Supreme createSupreme(@RequestBody Supreme supremeWitch) {
		return witchService.saveSupreme(supremeWitch);
	}
	
	@PostMapping("witches/common")
	@ResponseStatus(HttpStatus.CREATED)
	public Common createCommon(@RequestBody Common commonWitch) {
		return witchService.saveCommon(commonWitch);
	}
	
	@PutMapping("/witches/supreme")
	@ResponseStatus(HttpStatus.OK)
	public Supreme updateSupreme(@RequestBody Supreme supremeWitch) {
		return witchService.saveSupreme(supremeWitch);
		
	}
	
	@PutMapping("/witches/common")
	@ResponseStatus(HttpStatus.OK)
	public Common updateCommon(@RequestBody Common commonWitch) {
		return witchService.saveCommon(commonWitch);
		
	}
	
	@DeleteMapping("/witches/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id) {
		witchService.delete(id);
	}
}
