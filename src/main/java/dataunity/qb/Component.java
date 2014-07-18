package dataunity.qb;

public class Component {
	private ComponentSpecification compSpec = null;
	
	public Component(ComponentSpecification compSpec) {
		this.setCompSpec(compSpec);
	}

	public ComponentSpecification getCompSpec() {
		return compSpec;
	}
	public void setCompSpec(ComponentSpecification compSpec) {
		this.compSpec = compSpec;
	}
}
