package s4.spring.td2.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Organization {

	public List<Groupe> getGroupes() {
		return groupes;
	}


	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String domain;
	private String aliases;
	private String ville;
	

	@OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
	// All --> tt ce qui est fait sur la classe pere sera repercute sur la classe
	// enfant/ le groupe et tt les organization qu il y a dedans
	private List<Groupe> groupes;
	
	
	
	public Organization() { // ne pas oublier d'instancier sinon null pointer exception
		groupes = new ArrayList<>();
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getAliases() {
		return aliases;
	}

	public void setAliases(String aliases) {
		this.aliases = aliases;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String toString() {
		return name + " at " + ville;
	}
}
