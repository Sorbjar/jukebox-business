package be.lode.jukebox.business.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Currency.
 */
@Entity
@Table(name = "Currency")
public class Currency {

	/** The name. */
	private final String NAME;

	/** The paypalcode. */
	@Id
	private final String PAYPALCODE;

	/**
	 * Instantiates a new currency. Defaults EUR, Euro
	 */
	public Currency() {
		super();
		PAYPALCODE = "EUR";
		NAME = "Euro";
	}

	/**
	 * Instantiates a new currency.
	 *
	 * @param payPalCode
	 *            the pay pal code
	 * @param name
	 *            the name
	 */
	public Currency(String payPalCode, String name) {
		super();
		PAYPALCODE = payPalCode;
		NAME = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return NAME;
	}

	/**
	 * Gets the pay pal code.
	 *
	 * @return the pay pal code
	 */
	public String getPayPalCode() {
		return PAYPALCODE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((PAYPALCODE == null) ? 0 : PAYPALCODE.hashCode());
		return result;
	}

}
