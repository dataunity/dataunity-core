package dataunity.qb;

import java.util.Iterator;
import java.util.UUID;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.vocabulary.RDF;
import com.hp.hpl.jena.vocabulary.RDFS;

import dataunity.dataTable.DataTable;

/***
 * Serialises DataStructureDefinition
 * @author Kev Kirkland
 *
 */
public class DataStructureDefinitionSerializer {
	private String dataUnityBaseURL = null;
	
	/***
	 * Constructor
	 * @param dataUnityBaseURL The base URL of the Data Unity instance 
	 */
	public DataStructureDefinitionSerializer(String dataUnityBaseURL) {
		if (dataUnityBaseURL == null) {
			throw new NullPointerException("The dataUnityBaseURL must be a valid URL pointing to a Data Unity instance.");
		}
		this.setDataUnityBaseURL(dataUnityBaseURL);
	}
	
	private String generateUUID() {
		return UUID.randomUUID().toString();
	}
	public Model toRDF(DataStructureDefinition dsd) {
		Model model = ModelFactory.createDefaultModel();
		String dsdURLTemplate = getDataUnityBaseURL() + "/api/beta/qb/datastructdefs/{id}";
		String compSpecURLTemplate = getDataUnityBaseURL() + "/api/beta/qb/component-spec/{id}";
		String dimensionURLTemplate = getDataUnityBaseURL() + "/api/beta/qb/dimensions/{id}";
		
		String dsdURL = dsdURLTemplate.replace("{id}", generateUUID());
		Resource dsdResource = model.createResource(dsdURL);
		dsdResource.addProperty(RDF.type, QB.DataStructureDefinition);
		
		Iterator<Component> compIter = dsd.getComponent().iterator();
		while (compIter.hasNext()) {
			Component comp = compIter.next();
			ComponentSpecification compSpec = comp.getCompSpec();
			String fieldRef = compSpec.getFieldRef();
			Dimension dim = compSpec.getDim();
			String label = dim.getLabel();
			String dataType = dim.getRange();
			
			String dimensionURL = dimensionURLTemplate.replace("{id}", generateUUID());
			Resource dimResource = model.createResource(dimensionURL);
	    	dimResource.addProperty(RDF.type, QB.DimensionProperty);
	    	dimResource.addProperty(RDFS.range, model.createResource(dataType));
	    	dimResource.addLiteral(RDFS.label, label);
	    	
			String compSpecURL = compSpecURLTemplate.replace("{id}", generateUUID());
			Resource compSpecResource = model.createResource(compSpecURL);
	    	compSpecResource.addProperty(RDF.type, QB.ComponentSpecification);
	    	compSpecResource.addProperty(QB.dimension, dimResource);
	    	compSpecResource.addLiteral(DataTable.fieldRef, fieldRef);
	    	
	    	dsdResource.addProperty(QB.component, compSpecResource); 
		}
		
		return model;
	}

	private String getDataUnityBaseURL() {
		return dataUnityBaseURL;
	}

	private void setDataUnityBaseURL(String dataUnityBaseURL) {
		this.dataUnityBaseURL = dataUnityBaseURL;
	}
}
