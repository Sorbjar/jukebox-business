package be.lode.jukebox.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import be.lode.jukebox.business.enums.Role;

@Entity
@Table(name = "Jukebox")
public class Jukebox {
	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "Jukebox_AccountRoles")
	@Enumerated(EnumType.STRING)
	private Map<Account, Role> accountRoles;
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private List<Playlist> savedPlaylists;

	public List<Playlist> getSavedPlaylists() {
		return savedPlaylists;
	}

	public Jukebox() {
		super();
	}

	public Jukebox(String name, Account account) {
		super();
		this.name = name;
		this.accountRoles = new HashMap<Account, Role>();
		this.addAccountRole(account, Role.Administrator);
	}

	public Jukebox(Account account) {
		super();
		this.name = "Unnamed jukebox";
		this.accountRoles = new HashMap<Account, Role>();
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

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
