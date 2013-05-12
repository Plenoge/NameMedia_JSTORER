package jstorer.namemediaproject.entities;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "domainList")
public class DomainList {
	private ArrayList<Domain> domainList;
	
	public void setDomainList(ArrayList<Domain> domainList) {
		this.domainList = domainList;
	}

	@XmlElement(name = "domain")
	public ArrayList<Domain> getDomainList() {
		return domainList;
	}
}
