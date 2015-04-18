package be.lode.jukebox.business;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

public class Library {
	private String path;
	private Set<Song> songs;

	// TODO path in configuration file
	public Library() {
		super();
		this.songs = new HashSet<Song>();
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Set<Song> getSongs() {
		return songs;
	}

	public void saveSong(String path) {
		try {
			Song song = parse(path);
			if (!songs.contains(song)) {
				songs.add(song);
			}
		} catch (IOException | SAXException | TikaException e) {
			// TODO handle exception
			// ignore exception, not useful for end user
		}
	}

	private Song parse(String path) throws IOException, SAXException,
			TikaException {
		Song song = new Song(path);
		BodyContentHandler handler = new BodyContentHandler();
		Metadata metadata = new Metadata();
		FileInputStream inputstream;
		ParseContext pcontext = new ParseContext();

		inputstream = new FileInputStream(new File(path));

		Mp3Parser mp3Parser = new Mp3Parser();

		mp3Parser.parse(inputstream, handler, metadata, pcontext);

		String[] metadataNames = metadata.names();
		for (String name : metadataNames) {
			song.getMetadataProperty().put(name, metadata.get(name));
		}

		return song;

	}
}
