package dataunity.qb;

import java.util.ArrayList;
import java.util.List;

public class DataStructureDefinition {
	private List<Component> component = new ArrayList<Component>();

	public List<Component> getComponent() {
		return component;
	}
	public void setComponent(List<Component> component) {
		this.component = component;
	}
}
