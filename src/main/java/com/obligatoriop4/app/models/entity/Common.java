package com.obligatoriop4.app.models.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("Common")
public class Common extends Witch {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String regionOrigin;
	private boolean flyBroom;
	@OneToOne
	private Supreme supremeWitch;
	
	public String getRegionOrigin() {
		return regionOrigin;
	}

	public void setRegionOrigin(String regionOrigin) {
		this.regionOrigin = regionOrigin;
	}

	public boolean isFlyBroom() {
		return flyBroom;
	}

	public void setFlyBroom(boolean flyBroom) {
		this.flyBroom = flyBroom;
	}

	public Supreme getSupremeWitch() {
		return supremeWitch;
	}

	public void setSupremeWitch(Supreme supremeWitch) {
		this.supremeWitch = supremeWitch;
	}

	@Override
	public boolean isSupreme() {
		return false;
	}

	@Override
	public int getPowerPoints() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

}
