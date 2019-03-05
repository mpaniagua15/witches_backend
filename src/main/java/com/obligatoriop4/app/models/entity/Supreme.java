package com.obligatoriop4.app.models.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Supreme")
public class Supreme extends Witch {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Date bornDate;
	private int powerAmount;
	
	public Date getBornDate() {
		return bornDate;
	}

	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}

	public int getPowerAmount() {
		return powerAmount;
	}

	public void setPowerAmount(int powerAmount) {
		this.powerAmount = powerAmount;
	}

	@Override
	public boolean isSupreme() {
		return true;
	}

	@Override
	public int getPowerPoints() {
		// TODO Auto-generated method stub
		return 0;
	}

}
