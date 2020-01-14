package com.fabio;

import java.time.YearMonth;

public class MonthlySalesDataPOJO {
	
	private Integer salesNumber;
	private YearMonth date;
	
	MonthlySalesDataPOJO(YearMonth date, Integer salesNumber){
		this.date = date;
		this.salesNumber = salesNumber;
	}

	public Integer getSalesNumber() {
		return salesNumber;
	}

	public void setSalesNumber(Integer salesNumber) {
		this.salesNumber = salesNumber;
	}

	public YearMonth getDate() {
		return date;
	}

	public void setDate(YearMonth date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((salesNumber == null) ? 0 : salesNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MonthlySalesDataPOJO other = (MonthlySalesDataPOJO) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (salesNumber == null) {
			if (other.salesNumber != null)
				return false;
		} else if (!salesNumber.equals(other.salesNumber))
			return false;
		return true;
	}
	
}
