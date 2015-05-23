package be.lode.jukebox.business.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The Class PayPalSettings.
 */
@Entity
@Table(name = "PayPalSettings")
public class PayPalSettings {
	
	/** The currency. */
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.REFRESH, CascadeType.PERSIST})
	private Currency currency;
	
	/** The email. */
	private String email;
	
	/** The id. */
	@Id
	@GeneratedValue
	@Column(name = "PayPalSettingsID")
	private long id;
	
	/** The price per song. */
	private double pricePerSong;
	
	/**
	 * Instantiates a new PayPal settings.
	 */
	public PayPalSettings() {
		super();
		this.currency = new Currency("EUR", "Euro");
		this.email = "";
		this.pricePerSong = 0.0;
	}
	
	/* (non-Javadoc)
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
		PayPalSettings other = (PayPalSettings) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	/**
	 * Gets the currency.
	 *
	 * @return the currency
	 */
	public Currency getCurrency() {
		return currency;
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * Gets the price per song.
	 *
	 * @return the price per song
	 */
	public double getPricePerSong() {
		return pricePerSong;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	
	/**
	 * Sets the currency.
	 *
	 * @param currency the new currency
	 */
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * Sets the price per song.
	 *
	 * @param pricePerSong the new price per song
	 */
	public void setPricePerSong(double pricePerSong) {
		this.pricePerSong = pricePerSong;
	}

}
