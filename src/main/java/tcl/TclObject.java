package tcl;

public class TclObject implements TclElement{
	private String name;
	private TclElement value;
	
	public TclObject(String name,TclElement value){
		this.name = name;
		this.value = value;
	}
	
	public String toString(){
		return new StringBuilder().append("{")
				.append(name)
				.append(" ")
				.append(value.toString())
				.append("}")
				.toString();
	}

	public boolean isTclObject() {
		return true;
	}

	public boolean isTclArray() {
		return false;
	}

	public boolean isTclPrimitive() {
		return false;
	}

	public TclObject getAsTclObject() {
		return this;
	}

	public TclArray getAsTclArray() {
		return null;
	}

	public TclPrimitive getAsTclPrimitive() {
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TclElement getValue() {
		return value;
	}

	public void setValue(TclElement value) {
		this.value = value;
	}
	
}
