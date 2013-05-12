package jstorer.namemediaproject;

import java.io.File;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import jstorer.namemediaproject.entities.Domain;
import jstorer.namemediaproject.entities.DomainList;

public class NameMediaProject {

	public static void main(String[] args) {
		NameMediaProject app = new NameMediaProject();

		if (true) {
			// Pure JAXB XML parser, only useful for smaller files
			app.processXMLFile();
		} else {
			// JAXB + STax XML parser, processes in chunks for larger files
			app.processXMLFileInChunks();
		}
	}

	// ---------------------- Main Logic Below ---------------------
	// ---------------------- Private Statics ----------------------

	private static final String xmlFile = "testData.xml";
	private static final String persistenceUnit = "nameMediaProject";
	private EntityManager entityManager = null;

	// -------------------------- Methods --------------------------

	public NameMediaProject() {
		initializeEntityManager();
	}

	/**
	 * Process an XML file using purely JAXB. This will load the entire file
	 * into memory and is, as such, dangerous depending on the size of the XML
	 * file being loaded.
	 * 
	 * Loops through the root element <code>DomainList</code> to insert records
	 * into the MySQL database
	 */
	protected void processXMLFile() {
		try {
			// Fetch and parse the XML file
			File file = new File(xmlFile);
			JAXBContext context = JAXBContext.newInstance(DomainList.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			DomainList domainList = (DomainList) unmarshaller.unmarshal(file);

			// Loop through the contents to insert to database
			for (Domain domain : domainList.getDomainList()) {
				System.out.println("Domain Name / Price / Status: "
						+ domain.getName() + " / " + domain.getPrice() + " / "
						+ domain.getStatus());
				insertRecordToDatabase(domain);
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (Exception io) {
			io.printStackTrace();
		}
	}

	/**
	 * Process an XML file using a combination of JAXB and STax. This will be
	 * slower than the pure JAXB implementation, but doesn't have the danger of
	 * running out of memory.
	 * 
	 * Loops through the root element <code>DomainList</code> to insert records
	 * into the MySQL database
	 */
	protected void processXMLFileInChunks() {

	}

	protected void insertRecordToDatabase(Domain domain) throws Exception {
		entityManager.getTransaction().begin();
		entityManager.persist(domain);
		entityManager.getTransaction().commit();
	}

	private void initializeEntityManager() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(persistenceUnit);
		entityManager = emf.createEntityManager();
	}
}
