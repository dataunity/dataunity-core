package dataunity.dataTable;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;

/***
 * Data Unity DataTable namespace
 * @author normal
 *
 */
public class DataTable {
	protected static final String uri ="http://dataunity.org/ns/datatable#";

    /** returns the URI for this schema
     * @return the URI for this schema
     */
    public static String getURI() {
          return uri;
    }

    private static Model m = ModelFactory.createDefaultModel();
    
    // DataTable Resources
    public static final Property fieldRef = m.createProperty(uri, "fieldRef");

}
