package dataunity.qb;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
/***
 * RDF Data Cube namespace
 * @author normal
 *
 */
public class QB {
	protected static final String uri ="http://purl.org/linked-data/cube#";

    /** returns the URI for this schema
     * @return the URI for this schema
     */
    public static String getURI() {
          return uri;
    }

    private static Model m = ModelFactory.createDefaultModel();
    
    // RDF Data Cube Resources
    public static final Resource DataStructureDefinition = m.createResource(uri + "DataStructureDefinition");
    public static final Resource ComponentSpecification = m.createResource(uri + "ComponentSpecification");
    public static final Property component = m.createProperty(uri, "component");
    
    public static final Resource DimensionProperty = m.createResource(uri + "DimensionProperty");
    public static final Property dimension = m.createProperty(uri, "dimension");
    
    //public static final Resource Component = m.createResource(uri + "Component");    
}
