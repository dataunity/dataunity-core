package dataunity.qb;

public class Dimension {
	private String range = "";
	private String label = "";
	
	public Dimension(String label, String range) {
		setLabel(label);
		setRange(range);
	}
	
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}	
}
