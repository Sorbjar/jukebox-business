package be.lode.jukebox.business;

import java.util.HashMap;
import java.util.Map;

public class Song {
	private Map<String, String> metadataProperties;
	private String name;
	private String artist;
	private String path;

	public Song() {
		super();
		this.metadataProperties = new HashMap<String, String>();
	}

	public Song(String path) {
		super();
		this.metadataProperties = new HashMap<String, String>();
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Map<String, String> getMetadataProperty() {
		return metadataProperties;
	}

}
