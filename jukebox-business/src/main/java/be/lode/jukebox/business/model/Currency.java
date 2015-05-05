package be.lode.jukebox.business.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Currency")
public class Currency {
	private final String NAME;
	@Id
	private final String PAYPALCODE;

	public Currency(String payPalCode, String name) {
		super();
		PAYPALCODE = payPalCode;
		NAME = name;
	}

	public Currency() {
		super();
		PAYPALCODE = "EUR";
		NAME = "Euro";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Currency other = (Currency) obj;
		if (PAYPALCODE == null) {
			if (other.PAYPALCODE != null)
				return false;
		} else if (!PAYPALCODE.equals(other.PAYPALCODE))
			return false;
		return true;
	}

	public String getName() {
		return NAME;
	}

	public String getPayPalCode() {
		return PAYPALCODE;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((PAYPALCODE == null) ? 0 : PAYPALCODE.hashCode());
		return result;
	}

}
