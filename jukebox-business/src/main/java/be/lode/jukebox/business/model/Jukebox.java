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

/**
 * The Class Jukebox.
 */
@Entity
@Table(name = "Jukebox")
public class Jukebox {

	/** The account roles. */
	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "Jukebox_AccountRoles")
	@Enumerated(EnumType.STRING)
	private Map<Account, Role> accountRoles;

	/** The current playlist. */
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Playlist currentPlaylist;

	/** The id. */
	@Id
	@GeneratedValue
	@Column(name = "JukeboxID")
	private long id;

	/** The looped. */
	private boolean looped;

	/** The mandatory playlist. */
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Playlist mandatoryPlaylist;

	/** The name. */
	private String name;

	/** The pay pal settings. */
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private PayPalSettings payPalSettings;

	/** The rand. */
	@Transient
	private Random rand;

	/** The random. */
	private boolean random;

	/** The saved playlists. */
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "Jukebox_SavedPlaylists")
	@OrderBy("name")
	private SortedSet<Playlist> savedPlaylists;

	/**
	 * Instantiates a new jukebox.
	 */
	public Jukebox() {
		super();
		constructor();
	}

	/**
	 * Instantiates a new jukebox.
	 *
	 * @param account
	 *            the account
	 */
	public Jukebox(Account account) {
		super();
		constructor();
		this.addAccountRole(account, Role.Administrator);
	}

	/**
	 * Instantiates a new jukebox.
	 *
	 * @param name
	 *            the name
	 * @param account
	 *            the account
	 */
	public Jukebox(String name, Account account) {
		super();
		constructor();
		this.name = name;
		this.addAccountRole(account, Role.Administrator);
	}

	/**
	 * Adds the account role.
	 *
	 * @param account
	 *            the account
	 * @param role
	 *            the role
	 */
	public void addAccountRole(Account account, Role role) {
		if (this.accountRoles.containsKey(account))
			accountRoles.replace(account, role);
		else
			accountRoles.put(account, role);
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
		Jukebox other = (Jukebox) obj;
		if (id != other.id)
			return false;
		return true;
	}

	/**
	 * Gets the account roles.
	 *
	 * @return the account roles
	 */
	public Map<Account, Role> getAccountRoles() {
		return accountRoles;
	}

	/**
	 * Gets the current playlist.
	 *
	 * @return the current playlist
	 */
	public Playlist getCurrentPlaylist() {
		return currentPlaylist;
	}

	/**
	 * Gets the first song.
	 *
	 * @return the first song
	 */
	public SongContainer getFirstSong() {
		if (mandatoryPlaylist != null
				&& mandatoryPlaylist.getSongs().size() > 0) {
			SongContainer sc = new SongContainer(mandatoryPlaylist.getSongs()
					.get(0), 0, true);
			return sc;
		} else if (currentPlaylist.getSongs().size() > 0) {
			SongContainer sc = new SongContainer(currentPlaylist.getSongs()
					.get(0), 0, false);
			return sc;
		}
		return null;

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
	 * Gets the mandatory playlist.
	 *
	 * @return the mandatory playlist
	 */
	public Playlist getMandatoryPlaylist() {
		return mandatoryPlaylist;
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
	 * Gets the next song.
	 *
	 * @param currentSongInt
	 *            the current song int
	 * @return the next song
	 */
	public SongContainer getNextSong(int currentSongInt) {
		if (mandatoryPlaylist != null
				&& mandatoryPlaylist.getSongs().size() > 0) {
			SongContainer sc = new SongContainer(mandatoryPlaylist.getSongs()
					.get(0), 0, true);
			return sc;
		} else if (random) {
			int size = currentPlaylist.getSongs().size() - 1;

			int randomNum = currentSongInt;
			if (size > 0) {
				while (randomNum == currentSongInt)
					randomNum = rand.nextInt((size - 0) + 1) + 0;
			}

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

	/**
	 * Gets the PayPal settings.
	 *
	 * @return the PayPal settings
	 */
	public PayPalSettings getPayPalSettings() {
		return payPalSettings;
	}

	/**
	 * Gets the previous song.
	 *
	 * @param currentSongInt
	 *            the current song int
	 * @return the previous song
	 */
	public SongContainer getPreviousSong(int currentSongInt) {

		if (mandatoryPlaylist != null
				&& mandatoryPlaylist.getSongs().size() > 0) {
			SongContainer sc = new SongContainer(mandatoryPlaylist.getSongs()
					.get(0), 0, true);
			return sc;
		} else if (random) {
			int size = currentPlaylist.getSongs().size() - 1;

			int randomNum = currentSongInt;
			if (size > 0) {
				while (randomNum == currentSongInt)
					randomNum = rand.nextInt((size - 0) + 1) + 0;
			}

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

	/**
	 * Gets the saved playlists.
	 *
	 * @return the saved playlists
	 */
	public SortedSet<Playlist> getSavedPlaylists() {
		return savedPlaylists;
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
	 * Checks if is looped.
	 *
	 * @return true, if is looped
	 */
	public boolean isLooped() {
		return looped;
	}

	/**
	 * Checks if is random.
	 *
	 * @return true, if is random
	 */
	public boolean isRandom() {
		return random;
	}

	/**
	 * Removes the mandatory song.
	 *
	 * @param song
	 *            the song
	 * @param order
	 *            the order
	 */
	public void removeMandatorySong(Song song, int order) {
		if (mandatoryPlaylist != null
				&& mandatoryPlaylist.getSongs().size() > 0) {
			if (mandatoryPlaylist.getSongs().get(order).equals(song)) {
				mandatoryPlaylist.removeSong(order);
			}
		}
	}

	/**
	 * Removes the playlist.
	 *
	 * @param pl
	 *            the pl
	 */
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

	/**
	 * Sets the account roles.
	 *
	 * @param accountRoles
	 *            the account roles
	 */
	public void setAccountRoles(Map<Account, Role> accountRoles) {
		this.accountRoles = accountRoles;
	}

	/**
	 * Sets the current playlist.
	 *
	 * @param currentPlaylist
	 *            the new current playlist
	 */
	public void setCurrentPlaylist(Playlist currentPlaylist) {
		this.currentPlaylist = currentPlaylist;
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
	 * Sets the looped.
	 *
	 * @param looped
	 *            the new looped
	 */
	public void setLooped(boolean looped) {
		this.looped = looped;
	}

	/**
	 * Sets the mandatory playlist.
	 *
	 * @param mandatoryPlaylist
	 *            the new mandatory playlist
	 */
	public void setMandatoryPlaylist(Playlist mandatoryPlaylist) {
		this.mandatoryPlaylist = mandatoryPlaylist;
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
	 * Sets the PayPal settings.
	 *
	 * @param payPalSettings
	 *            the new PayPal settings
	 */
	public void setPayPalSettings(PayPalSettings payPalSettings) {
		this.payPalSettings = payPalSettings;
	}

	/**
	 * Sets the random.
	 *
	 * @param random
	 *            the new random
	 */
	public void setRandom(boolean random) {
		this.random = random;
	}

	/**
	 * Sets the saved playlists.
	 *
	 * @param savedPlaylists
	 *            the new saved playlists
	 */
	public void setSavedPlaylists(SortedSet<Playlist> savedPlaylists) {
		this.savedPlaylists = savedPlaylists;
	}

	/**
	 * Constructor.
	 */
	private void constructor() {
		this.accountRoles = new HashMap<Account, Role>();
		this.savedPlaylists = new TreeSet<Playlist>();
		this.name = "Unnamed jukebox";
		this.looped = false;
		this.random = false;
		this.rand = new Random();
		this.mandatoryPlaylist = new Playlist("mandatory");
		this.currentPlaylist = new Playlist("Unsaved playlist");
		this.payPalSettings = new PayPalSettings();
	}
}
