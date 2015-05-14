package be.lode.jukebox.business.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Table;

@Entity
@Table(name = "Song")
public class Song {
	private final String artist;
	@Id
	@GeneratedValue
	@Column(name = "SongID")
	private long id;
	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "Song_Metadata")
	private Map<String, String> metadataProperties;
	private String path;
	private final String title;

	public Song() {
		super();
		this.artist = "";
		this.title = "";
		this.metadataProperties = new HashMap<String, String>();
	}

	public Song(String artist, String title, String path) {
		super();
		this.metadataProperties = new HashMap<String, String>();
		this.artist = artist;
		this.path = path;
		this.title = title;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Song other = (Song) obj;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	public String getArtist() {
		return artist;
	}

	public long getId() {
		return id;
	}

	public Map<String, String> getMetadataProperties() {
		return metadataProperties;
	}

	public String getPath() {
		return path;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
