package data;

import java.util.ArrayList;

public class FieldNameScheme {

	private ArrayList schemeNames;
	
	public FieldNameScheme() {
		this.schemeNames = new ArrayList();
		this.schemeNames.add("Kawasaki");
	}
	
	public ArrayList getColumns(String scheme) {
		if(scheme.trim().equals("Kawasaki")) {
			return getKawasakiFields();
		}
		else {
			return null;
		}
	}
	
	public ArrayList getKawasakiFields() {
		ArrayList result = new ArrayList();
		result.add("PART NUMBER");
		result.add("DESCRIPTION");
		result.add("ADDITIONAL INFORMATION 1");
		result.add("ADDITIONAL INFORMATION 2");
		result.add("ADDITIONAL INFORMATION 3");
		result.add("DUTIES (%)");
		result.add("SELLING PRICE (RM)");
		result.add("LEAD TIME (ARO)");
		result.add("DYNAFLO DISCOUNT CODE");	
		return result;
	}
	
}
