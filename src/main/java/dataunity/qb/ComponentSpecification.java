package dataunity.qb;

public class ComponentSpecification {
	private Dimension dim = null;
	private String fieldRef = "";
	
	public ComponentSpecification(String fieldRef, Dimension dim) {
		setFieldRef(fieldRef);
		setDim(dim);
	}
	
	public String getFieldRef() {
		return fieldRef;
	}
	public void setFieldRef(String fieldRef) {
		this.fieldRef = fieldRef;
	}
	
	public Dimension getDim() {
		return dim;
	}
	public void setDim(Dimension dim) {
		this.dim = dim;
	}
	
}
