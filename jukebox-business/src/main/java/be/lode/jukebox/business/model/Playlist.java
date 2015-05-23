package be.lode.jukebox.business.model;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SortComparator;

import be.lode.jukebox.business.model.comparators.IntegerComparator;

/**
 * The Class Playlist.
 */
@Entity
@Table(name = "Playlist")
public class Playlist implements Comparable<Playlist> {

	/** The id. */
	@Id
	@GeneratedValue
	@Column(name = "PlaylistID")
	private long id;

	/** The name. */
	private String name;

	/** The songs. */
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Playlist_Song", joinColumns = { @JoinColumn(name = "PlaylistID", referencedColumnName = "PlaylistID") }, inverseJoinColumns = { @JoinColumn(name = "SongID", referencedColumnName = "SongID") })
	@SortComparator(IntegerComparator.class)
	private SortedMap<Integer, Song> songs;

	/**
	 * Instantiates a new playlist.
	 */
	public Playlist() {
		super();
		this.songs = new TreeMap<Integer, Song>();
	}

	/**
	 * Instantiates a new playlist.
	 *
	 * @param name
	 *            the name
	 */
	public Playlist(String name) {
		super();
		this.name = name;
		this.songs = new TreeMap<Integer, Song>();
	}

	/**
	 * Adds the song.
	 *
	 * @param song
	 *            the song
	 */
	public void addSong(Song song) {
		try {
			songs.put(songs.lastKey() + 1, song);
		} catch (NoSuchElementException ex) {
			songs.put(0, song);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Playlist o) {
		return this.name.compareTo(o.getName());
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
		Playlist other = (Playlist) obj;
		if (id != other.id)
			return false;
		return true;
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
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the songs.
	 *
	 * @return the songs
	 */
	public SortedMap<Integer, Song> getSongs() {
		return songs;
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
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	/**
	 * Move song.
	 *
	 * @param indexToMove
	 *            the index of the song to move
	 * @param indexDestination
	 *            the index of the destination
	 */
	public void moveSong(Integer indexToMove, Integer indexDestination) {
		if (indexToMove > indexDestination) {
			SortedMap<Integer, Song> tempMap = new TreeMap<Integer, Song>();
			for (Map.Entry<Integer, Song> entry : songs.entrySet()) {
				if (entry.getKey() >= indexDestination
						&& entry.getKey() < indexToMove) {
					tempMap.put(entry.getKey() + 1, entry.getValue());
				} else if (entry.getKey() == indexToMove) {
					tempMap.put(indexDestination, entry.getValue());
				} else {
					tempMap.put(entry.getKey(), entry.getValue());
				}
			}
			songs = tempMap;
		} else {
			SortedMap<Integer, Song> tempMap = new TreeMap<Integer, Song>();
			for (Map.Entry<Integer, Song> entry : songs.entrySet()) {
				if (entry.getKey() <= indexDestination
						&& entry.getKey() > indexToMove) {
					tempMap.put(entry.getKey() - 1, entry.getValue());
				} else if (entry.getKey() == indexToMove) {
					tempMap.put(indexDestination, entry.getValue());
				} else {
					tempMap.put(entry.getKey(), entry.getValue());
				}
			}
			songs = tempMap;
		}
	}

	/**
	 * Removes the song.
	 *
	 * @param index
	 *            the index
	 */
	public void removeSong(Integer index) {
		songs.remove(index);
		SortedMap<Integer, Song> tempMap = new TreeMap<Integer, Song>();
		for (Map.Entry<Integer, Song> entry : songs.entrySet()) {
			try {
				tempMap.put(tempMap.lastKey() + 1, entry.getValue());
			} catch (NoSuchElementException ex) {
				tempMap.put(0, entry.getValue());
			}
		}
		songs = tempMap;
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
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the songs.
	 *
	 * @param songs
	 *            the songs
	 */
	public void setSongs(SortedMap<Integer, Song> songs) {
		this.songs = songs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name;
	}
}
