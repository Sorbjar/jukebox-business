package be.lode.jukebox.business.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Account.
 */
@Entity
@Table(name = "Account")
public class Account {

	/** The email address. */
	private String emailAddress;

	/** The first name. */
	private String firstName;

	/** The id. */
	@Id
	@GeneratedValue
	@Column(name = "AccountID")
	private long id;

	/** The last name. */
	private String lastName;

	/** The service id. */
	private String serviceId;

	/** The service name. */
	private String serviceName;

	/**
	 * Instantiates a new account.
	 */
	public Account() {
	}

	/**
	 * Instantiates a new account.
	 *
	 * @param emailAddress
	 *            the email address
	 * @param firstName
	 *            the first name
	 * @param lastName
	 *            the last name
	 * @param serviceId
	 *            the service id
	 * @param serviceName
	 *            the service name
	 */
	public Account(String emailAddress, String firstName, String lastName,
			String serviceId, String serviceName) {
		super();
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.serviceId = serviceId;
		this.serviceName = serviceName;
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
		Account other = (Account) obj;
		if (serviceId == null) {
			if (other.serviceId != null)
				return false;
		} else if (!serviceId.equals(other.serviceId))
			return false;
		if (serviceName == null) {
			if (other.serviceName != null)
				return false;
		} else if (!serviceName.equals(other.serviceName))
			return false;
		return true;
	}

	/**
	 * Gets the email address.
	 *
	 * @return the email address
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
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
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Gets the service id.
	 *
	 * @return the service id
	 */
	public String getServiceId() {
		return serviceId;
	}

	/**
	 * Gets the service name.
	 *
	 * @return the service name
	 */
	public String getServiceName() {
		return serviceName;
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
				+ ((serviceId == null) ? 0 : serviceId.hashCode());
		result = prime * result
				+ ((serviceName == null) ? 0 : serviceName.hashCode());
		return result;
	}

	/**
	 * Sets the email address.
	 *
	 * @param emailAddress
	 *            the new email address
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName
	 *            the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName
	 *            the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Sets the service id.
	 *
	 * @param serviceId
	 *            the new service id
	 */
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	/**
	 * Sets the service name.
	 *
	 * @param serviceName
	 *            the new service name
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
}
