package be.lode.jukebox.business.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.scribe.builder.api.Api;
import org.scribe.builder.api.FacebookApi;

/**
 * The Class OAuthApiInfo.
 */
@Entity
@Table(name = "OAuthApiInfo")
public class OAuthApiInfo {

	/** The api key. */
	private String apiKey;
	
	/** The api secret. */
	private String apiSecret;
	
	/** The example get request. */
	private String exampleGetRequest;
	
	/** The name. */
	@Id
	private String name;
	
	/** The scribe api name. */
	private String scribeApiName;

	/**
	 * Instantiates a new o auth api info.
	 */
	public OAuthApiInfo() {
	}

	/**
	 * Instantiates a new o auth api info.
	 *
	 * @param name the name
	 * @param scribeApiName the scribe api name
	 * @param apiKey the api key
	 * @param apiSecret the api secret
	 * @param exampleGetRequest the example get request
	 */
	public OAuthApiInfo(String name, String scribeApiName, String apiKey,
			String apiSecret, String exampleGetRequest) {
		super();
		this.name = name;
		this.apiKey = apiKey;
		this.apiSecret = apiSecret;
		this.exampleGetRequest = exampleGetRequest;
		this.scribeApiName = scribeApiName;
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
		OAuthApiInfo other = (OAuthApiInfo) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/**
	 * Gets the api key.
	 *
	 * @return the api key
	 */
	public String getApiKey() {
		return apiKey;
	}

	/**
	 * Gets the api secret.
	 *
	 * @return the api secret
	 */
	public String getApiSecret() {
		return apiSecret;
	}

	/**
	 * Gets the example get request.
	 *
	 * @return the example get request
	 */
	public String getExampleGetRequest() {
		return exampleGetRequest;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the scribe api.
	 *
	 * @return the scribe api
	 */
	public Class<? extends Api> getScribeApi() {
		if (this.scribeApiName.equalsIgnoreCase("facebookapi"))
			return FacebookApi.class;
		return null;
	}

	/**
	 * Gets the scribe api name.
	 *
	 * @return the scribe api name
	 */
	public String getScribeApiName() {
		return scribeApiName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/**
	 * Sets the scribe api name.
	 *
	 * @param scribeApiName            the scribeApiName to set
	 */
	public void setScribeApiName(String scribeApiName) {
		this.scribeApiName = scribeApiName;
	}

}
