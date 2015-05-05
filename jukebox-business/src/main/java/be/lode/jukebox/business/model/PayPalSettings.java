package be.lode.jukebox.business.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PayPalSettings")
public class PayPalSettings {
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.REFRESH, CascadeType.PERSIST})
	private Currency currency;
	private String email;
	@Id
	@GeneratedValue
	@Column(name = "PayPalSettingsID")
	private long id;
	private double pricePerSong;
	
	public PayPalSettings() {
		super();
		this.currency = new Currency("EUR", "Euro");
		this.email = "";
		this.pricePerSong = 0.0;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		PayPalSettings other = (PayPalSettings) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public Currency getCurrency() {
		return currency;
	}
	public String getEmail() {
		return email;
	}
	public long getId() {
		return id;
	}
	public double getPricePerSong() {
		return pricePerSong;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setPricePerSong(double pricePerSong) {
		this.pricePerSong = pricePerSong;
	}

}
