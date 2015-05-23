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

/**
 * The Class Song.
 */
@Entity
@Table(name = "Song")
public class Song {

	/** The artist. */
	private final String artist;

	/** The id. */
	@Id
	@GeneratedValue
	@Column(name = "SongID")
	private long id;

	/** The metadata properties. */
	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "Song_Metadata")
	private Map<String, String> metadataProperties;

	/** The path. */
	private String path;

	/** The title. */
	private final String title;

	/**
	 * Instantiates a new song.
	 */
	public Song() {
		super();
		this.artist = "";
		this.title = "";
		this.metadataProperties = new HashMap<String, String>();
	}

	/**
	 * Instantiates a new song.
	 *
	 * @param artist
	 *            the artist
	 * @param title
	 *            the title
	 * @param path
	 *            the path
	 */
	public Song(String artist, String title, String path) {
		super();
		this.metadataProperties = new HashMap<String, String>();
		this.artist = artist;
		this.path = path;
		this.title = title;
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

	/**
	 * Gets the artist.
	 *
	 * @return the artist
	 */
	public String getArtist() {
		return artist;
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
	 * Gets the metadata properties.
	 *
	 * @return the metadata properties
	 */
	public Map<String, String> getMetadataProperties() {
		return metadataProperties;
	}

	/**
	 * Gets the path.
	 *
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
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
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
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
	 * Sets the path.
	 *
	 * @param path
	 *            the new path
	 */
	public void setPath(String path) {
		this.path = path;
	}

}
