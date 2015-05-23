package be.lode.jukebox.business.model;

/**
 * The Class SongContainer.
 */
public class SongContainer {

	/** The mandatory. */
	private Boolean mandatory;

	/** The playlist order. */
	private int playlistOrder;

	/** The song. */
	private Song song;

	/**
	 * Instantiates a new song container.
	 *
	 * @param song
	 *            the song
	 * @param playlistOrder
	 *            the playlist order
	 * @param mandatory
	 *            the mandatory
	 */
	public SongContainer(Song song, int playlistOrder, boolean mandatory) {
		this.song = song;
		this.playlistOrder = playlistOrder;
		this.mandatory = mandatory;
	}

	/**
	 * Gets the mandatory.
	 *
	 * @return the mandatory
	 */
	public Boolean getMandatory() {
		return mandatory;
	}

	/**
	 * Gets the playlist order.
	 *
	 * @return the playlist order
	 */
	public int getPlaylistOrder() {
		return playlistOrder;
	}

	/**
	 * Gets the song.
	 *
	 * @return the song
	 */
	public Song getSong() {
		return song;
	}

	/**
	 * Sets the mandatory.
	 *
	 * @param mandatory
	 *            the new mandatory
	 */
	public void setMandatory(Boolean mandatory) {
		this.mandatory = mandatory;
	}

	/**
	 * Sets the playlist order.
	 *
	 * @param playlistOrder
	 *            the new playlist order
	 */
	public void setPlaylistOrder(int playlistOrder) {
		this.playlistOrder = playlistOrder;
	}

	/**
	 * Sets the song.
	 *
	 * @param song
	 *            the new song
	 */
	public void setSong(Song song) {
		this.song = song;
	}

}
