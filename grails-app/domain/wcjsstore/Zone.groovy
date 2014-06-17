package wcjsstore

class Zone {

	Country country
	String code
	String name
	
    static constraints = {
    }

    static mapping = {
        cache true
        table "zones"
        version false
    columns {
      id column: "zone_id"
      code column: "zone_code"
      name column: "zone_name"
      country column: "zone_country_id"
     }
    }

    
	
    String toString() {
        code
    }
}
