package be.lode.jukebox.business.model;

public class SongContainer {
	private Boolean mandatory;
	private int playlistOrder;
	private Song song;

	public SongContainer(Song song, int playlistOrder, boolean mandatory) {
		this.song = song;
		this.playlistOrder = playlistOrder;
		this.mandatory = mandatory;
	}

	public Boolean getMandatory() {
		return mandatory;
	}

	public int getPlaylistOrder() {
		return playlistOrder;
	}

	public Song getSong() {
		return song;
	}

	public void setMandatory(Boolean mandatory) {
		this.mandatory = mandatory;
	}

	public void setPlaylistOrder(int playlistOrder) {
		this.playlistOrder = playlistOrder;
	}

	public void setSong(Song song) {
		this.song = song;
	}

}
