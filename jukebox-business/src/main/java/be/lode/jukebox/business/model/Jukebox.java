package be.lode.jukebox.business.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import be.lode.jukebox.business.model.enums.Role;

@Entity
@Table(name = "Jukebox")
public class Jukebox {
	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "Jukebox_AccountRoles")
	@Enumerated(EnumType.STRING)
	private Map<Account, Role> accountRoles;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Playlist currentPlaylist;
	@Id
	@GeneratedValue
	@Column(name = "JukeboxID")
	private long id;
	private boolean looped;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Playlist mandatoryPlaylist;
	private String name;
	@Transient
	private Random rand;
	private boolean random;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "Jukebox_SavedPlaylists")
	@OrderBy("name")
	private SortedSet<Playlist> savedPlaylists;

	public Jukebox() {
		super();
		constructor();
	}

	public Jukebox(Account account) {
		super();
		constructor();
		this.addAccountRole(account, Role.Administrator);
	}

	public Jukebox(String name, Account account) {
		super();
		constructor();
		this.name = name;
		this.addAccountRole(account, Role.Administrator);
	}

	public void addAccountRole(Account account, Role role) {
		if (this.accountRoles.containsKey(account))
			accountRoles.replace(account, role);
		else
			accountRoles.put(account, role);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jukebox other = (Jukebox) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Map<Account, Role> getAccountRoles() {
		return accountRoles;
	}

	public Playlist getCurrentPlaylist() {
		return currentPlaylist;
	}

	public long getId() {
		return id;
	}

	public Playlist getMandatoryPlaylist() {
		return mandatoryPlaylist;
	}

	public String getName() {
		return name;
	}

	public SongContainer getNextSong(int currentSongInt) {
		if (mandatoryPlaylist != null
				&& mandatoryPlaylist.getSongs().size() > 0) {
			SongContainer sc = new SongContainer(mandatoryPlaylist.getSongs()
					.get(0), 0, true);
			return sc;
		} else if (random) {
			// TODO 700 random not current
			// TODO 800 templist => random looped
			int size = currentPlaylist.getSongs().size() - 1;

			int randomNum = rand.nextInt((size - 0) + 1) + 0;

			SongContainer sc = new SongContainer(currentPlaylist.getSongs()
					.get(randomNum), randomNum, false);
			return sc;
		} else {
			// currentSongInt
			int size = currentPlaylist.getSongs().size() - 1;
			if (size == currentSongInt) {
				if (looped) {

					SongContainer sc = new SongContainer(currentPlaylist
							.getSongs().get(0), 0, false);
					return sc;
				} else {
					return null;
				}
			} else {

				int i = currentSongInt + 1;
				SongContainer sc = new SongContainer(currentPlaylist.getSongs()
						.get(i), i, false);
				return sc;
			}
		}
	}

	public SongContainer getPreviousSong(int currentSongInt) {

		if (mandatoryPlaylist != null
				&& mandatoryPlaylist.getSongs().size() > 0) {
			SongContainer sc = new SongContainer(mandatoryPlaylist.getSongs()
					.get(0), 0, true);
			return sc;
		} else if (random) {
			// TODO 700 random not current
			// TODO 800 templist => random looped
			int size = currentPlaylist.getSongs().size() - 1;

			int randomNum = rand.nextInt((size - 0) + 1) + 0;

			SongContainer sc = new SongContainer(currentPlaylist.getSongs()
					.get(randomNum), randomNum, false);
			return sc;
		} else {
			// currentSongInt
			int size = currentPlaylist.getSongs().size() - 1;
			if (0 == currentSongInt) {
				if (looped) {
					SongContainer sc = new SongContainer(currentPlaylist
							.getSongs().get(size), size, false);
					return sc;
				} else {
					return null;
				}
			} else {
				int i = currentSongInt - 1;
				SongContainer sc = new SongContainer(currentPlaylist.getSongs()
						.get(i), i, false);
				return sc;
			}
		}
	}

	public SortedSet<Playlist> getSavedPlaylists() {
		return savedPlaylists;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	public boolean isLooped() {
		return looped;
	}

	public boolean isRandom() {
		return random;
	}

	public void removePlaylist(Playlist pl) {
		Playlist removePlaylist = null;
		for (Playlist playlist : savedPlaylists) {
			if (playlist.getName().equals(pl.getName()))
				removePlaylist = playlist;
		}
		if (removePlaylist != null) {
			savedPlaylists.remove(removePlaylist);
		}

	}

	public void setAccountRoles(Map<Account, Role> accountRoles) {
		this.accountRoles = accountRoles;
	}

	public void setCurrentPlaylist(Playlist currentPlaylist) {
		this.currentPlaylist = currentPlaylist;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setLooped(boolean looped) {
		this.looped = looped;
	}

	public void setMandatoryPlaylist(Playlist mandatoryPlaylist) {
		this.mandatoryPlaylist = mandatoryPlaylist;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRandom(boolean random) {
		this.random = random;
	}

	public void setSavedPlaylists(SortedSet<Playlist> savedPlaylists) {
		this.savedPlaylists = savedPlaylists;
	}

	private void constructor() {
		this.accountRoles = new HashMap<Account, Role>();
		this.savedPlaylists = new TreeSet<Playlist>();
		this.name = "Unnamed jukebox";
		this.looped = false;
		this.random = false;
		this.rand = new Random();
		this.mandatoryPlaylist = new Playlist("mandatory");
		this.currentPlaylist = new Playlist("Unsaved playlist");
	}

	public void removeMandatorySong(Song song, int order) {
		if (mandatoryPlaylist != null
				&& mandatoryPlaylist.getSongs().size() > 0) {
			if(mandatoryPlaylist.getSongs().get(order).equals(song))
			{
				mandatoryPlaylist.removeSong(order);
			}
		}
	}
}
