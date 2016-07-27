package tcl;

import java.util.ArrayList;
import java.util.List;

public class Tcl {
	public static TclElement parse(String tclString){
		
		return parse(new StringBuffer(tclString),0,tclString.length()-1);
		
	}
	
	protected static TclElement parse(StringBuffer sb,int s,int e){
		System.out.println("s:"+s+" e:"+e);
		if(sb.charAt(s)!='{'){
			return new TclPrimitive(sb.substring(s, e+1));
		}
		
		List<TclElement> elementList = new ArrayList<TclElement>();
		
		int ss = -1;
		int se = -1;
		int foo = 0;
		int stype = 0;
		for(int i=s+1;i<=e;i++){
			if(sb.charAt(i)=='{'){
				if(ss==-1){
					foo = 1;
					ss =  i;
					stype = 0;
				}else{
					foo++;
				}
				
			}else if(sb.charAt(i)==' '){
				if(ss!=-1&&stype==1){
					se = i-1;
					elementList.add(parse(sb,ss,se));
					ss = -1;
					stype = -1;
				}
			}else if(sb.charAt(i)=='}'){
				if(stype==0&&foo-1==0&&ss!=-1){
					se = i;
					elementList.add(parse(sb,ss,se));
					ss = -1;
					stype = -1;
				}else if(stype==1&&ss!=-1){
					se = i-1;
					elementList.add(parse(sb,ss,se));
					ss = -1;
					stype = -1;
				}else if(foo-1<0){
					throw new RuntimeException();
				}else{
					foo--;
				}
			}else{
				if(ss==-1){
					ss = i;
					stype = 1;
				}
			}
			
		}
		if(elementList.size()>2||!elementList.get(0).isTclPrimitive()){
			return new TclArray(elementList);
		}else {
			return new TclObject(elementList.get(0).toString(),elementList.get(1));
		}
	}
	
	
	public static void main(String[] args) {
		String tclStr = "{REQ   {{BMS_ACCEPT_ID 20160713757806943} {BUSI_CODE 10516} {CITY_CODE 501} {DISTRICT_CODE 502521} {ICCID 8986011491501025489} {IMSI 460011951948842} {OP_CODE 4} {PROVINCE_CODE 50} {SERIAL_NUMBER 13111922800} {STAFF_ID QA03} {SYS_CODE 5002}}}";
		TclElement e = parse(tclStr);
		if(e.isTclObject()){
			TclObject to = e.getAsTclObject();
			System.out.println(to.getValue());;
		}
		
		System.out.println(e);
	}
}
