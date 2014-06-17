package wcjsstore

class Country {

	String name
	String isoCode2
	String isoCode3
	
	static transients = ['domestic']

	static constraints = {
	}

	static mapping = {
		cache true
		table "countries"
		version false
		columns {
			id column: "countries_id"
			isoCode2 column: "countries_iso_code_2"
			isoCode3 column: "countries_iso_code_3"
			name column: "countries_name"
		}
	}
	

	String toString() {
		name
	}

	boolean isDomestic() {
		return isoCode2 in ['US', 'CA', 'MX']
	}
}
