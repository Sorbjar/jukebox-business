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

@Entity
@Table(name = "Playlist")
public class Playlist implements Comparable<Playlist> {
	@Id
	@GeneratedValue
	@Column(name = "PlaylistID")
	private long id;
	private String name;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Playlist_Song", joinColumns = { @JoinColumn(name = "PlaylistID", referencedColumnName = "PlaylistID") }, inverseJoinColumns = { @JoinColumn(name = "SongID", referencedColumnName = "SongID") })
	@SortComparator(IntegerComparator.class)
	private SortedMap<Integer, Song> songs;

	public Playlist() {
		super();
		this.songs = new TreeMap<Integer, Song>();
	}

	public Playlist(String name) {
		super();
		this.name = name;
		this.songs = new TreeMap<Integer, Song>();
	}

	public void addSong(Song song) {
		try {
			songs.put(songs.lastKey() + 1, song);
		} catch (NoSuchElementException ex) {
			songs.put(0, song);
		}
	}

	@Override
	public int compareTo(Playlist o) {
		return this.name.compareTo(o.getName());
	}

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

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public SortedMap<Integer, Song> getSongs() {
		return songs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

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

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSongs(SortedMap<Integer, Song> songs) {
		this.songs = songs;
	}

	@Override
	public String toString() {
		return name;
	}
}
