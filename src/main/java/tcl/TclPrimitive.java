package tcl;

public class TclPrimitive implements TclElement{
	
	
	private String value;
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public TclPrimitive(String value){
		this.value = value;
	}
	
	public String toString(){
		return value;
	}

	public boolean isTclObject() {
		return false;
	}

	public boolean isTclArray() {
		return false;
	}

	public boolean isTclPrimitive() {
		return true;
	}

	public TclObject getAsTclObject() {
		return null;
	}

	public TclArray getAsTclArray() {
		return null;
	}

	public TclPrimitive getAsTclPrimitive() {
		return this;
	}
}
