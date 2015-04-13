package be.lode.jukebox.business.idClass;

import java.io.Serializable;

public class AccountId implements Serializable {
	private static final long serialVersionUID = 142584039181547667L;
	private String serviceName;
	private String serviceId;

	public AccountId() {

	}

	public AccountId(String service, String serviceId) {
		this.serviceName = service;
		this.serviceId = serviceId;
	}

	public String getService() {
		return serviceName;
	}

	public String getServiceId() {
		return serviceId;
	}

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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountId other = (AccountId) obj;
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

}
