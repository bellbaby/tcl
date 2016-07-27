package tcl;

public interface TclElement {
	
	public boolean isTclObject();
	public boolean isTclArray();
	public boolean isTclPrimitive();
	
	public TclObject getAsTclObject();
	public TclArray getAsTclArray();
	public TclPrimitive getAsTclPrimitive();
	
	public String toString();
}
