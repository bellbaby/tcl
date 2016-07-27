package tcl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TclArray implements TclElement{
	
	List<TclElement> elements = new ArrayList<TclElement>();
	
	public List<TclElement> getElements() {
		return elements;
	}

	public void setElements(List<TclElement> elements) {
		this.elements = elements;
	}

	public TclArray(List<TclElement> elements){
		this.elements = elements;
	}
	
	public void add(TclElement element){
		elements.add(element);
	}
	
	public TclElement get(int i){
		return elements.get(i);
	}
	
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		Iterator<TclElement> it = elements.iterator();
		while(it.hasNext()){
			builder.append(it.next().toString());
			if(it.hasNext()){
				builder.append(" ");
			}
		}
		builder.append("}");
		
		return builder.toString();
	}

	public boolean isTclObject() {
		return false;
	}

	public boolean isTclArray() {
		return true;
	}

	public boolean isTclPrimitive() {
		return false;
	}

	public TclObject getAsTclObject() {
		return null;
	}

	public TclArray getAsTclArray() {
		return this;
	}

	public TclPrimitive getAsTclPrimitive() {
		return null;
	}
}
