package be.lode.jukebox.business.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.scribe.builder.api.Api;
import org.scribe.builder.api.FacebookApi;

@Entity
@Table(name = "OAuthApiInfo")
public class OAuthApiInfo {

	private String apiKey;
	private String apiSecret;
	private String exampleGetRequest;
	@Id
	private String name;
	private String scribeApiName;

	public OAuthApiInfo() {
	}

	public OAuthApiInfo(String name, String scribeApiName, String apiKey,
			String apiSecret, String exampleGetRequest) {
		super();
		this.name = name;
		this.apiKey = apiKey;
		this.apiSecret = apiSecret;
		this.exampleGetRequest = exampleGetRequest;
		this.scribeApiName = scribeApiName;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OAuthApiInfo other = (OAuthApiInfo) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String getApiKey() {
		return apiKey;
	}

	public String getApiSecret() {
		return apiSecret;
	}

	public String getExampleGetRequest() {
		return exampleGetRequest;
	}

	public String getName() {
		return name;
	}

	public Class<? extends Api> getScribeApi() {
		if (this.scribeApiName.equalsIgnoreCase("facebookapi"))
			return FacebookApi.class;
		return null;
	}

	public String getScribeApiName() {
		return scribeApiName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/**
	 * @param scribeApiName
	 *            the scribeApiName to set
	 */
	public void setScribeApiName(String scribeApiName) {
		this.scribeApiName = scribeApiName;
	}

}
