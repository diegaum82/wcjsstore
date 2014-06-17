package wcjsstore


class Address {

	static transients = ['domestic', 'fullName']

	static belongsTo = CustomerInformation

	static constraints = {
		firstName(blank:false)
		lastName(blank:false)
		company(nullable:true)
		streetAddress(blank:false)
		streetAddress2(nullable:true)
		postalCode(blank:false)
		city(blank:false)
		country()
	}

	static mapping = {
		table "address_book"
		version false
		columns {
			id column: "address_book_id"
			firstName column: "entry_firstname"
			lastName column: "entry_lastname"
			gender column: "entry_gender"
			company column: "entry_company"
			streetAddress column: "entry_street_address"
			streetAddress2 column: "entry_suburb"
			postalCode column: "entry_postcode"
			city column: "entry_city"
			zone column: "entry_zone_id"
			country column: "entry_country_id"
			customer column: "customers_id"
		}
	}


	String firstName
	String lastName
	char gender = 'M'
	String company
	String streetAddress
	String streetAddress2
	String postalCode
	String city
	Zone zone
	Country country

	CustomerInformation customer

	static Address fromCleansedAddress(def cleansedAddress) {
		def address = new Address()
		String[] names = cleansedAddress.FullName.toString().split(' ')
		address.firstName = names[0]
		address.lastName = names[1..-1].join(' ')

		address.company = cleansedAddress.Company.toString()
		address.streetAddress = cleansedAddress.Address1.toString()
		address.streetAddress2 = cleansedAddress.Address2.toString()
		address.city  = cleansedAddress.City.toString()

		def internationalPostalCode = cleansedAddress.PostalCode.toString()

		if (internationalPostalCode) {
			address.postalCode = internationalPostalCode
		} else {
			address.postalCode = cleansedAddress.ZIPCode.toString()
			if (cleansedAddress.ZIPCodeAddOn.toString()) {
				address.postalCode+= '-' + cleansedAddress.ZIPCodeAddOn.toString()
			}
		}

		address.zone = Zone.findByCode(cleansedAddress.State.toString())
		if (!address.zone) {
			address.zone = Zone.findByCode(cleansedAddress.Province.toString())
		}

		address
	}

	def getFullName() {
		"$firstName $lastName"
	}



	def beforeInsert() {
		trimAddress()
	}

	def beforeUpdate(){
		trimAddress()
	}

	def trimAddress() {

		firstName = firstName != null ? firstName.trim() : null
		lastName = lastName != null ? lastName.trim() : null

		streetAddress = streetAddress != null ? streetAddress.trim() : null
		streetAddress2 = streetAddress2 != null ? streetAddress2.trim() : null

		city = city != null ? city.trim() : null
		postalCode = postalCode != null ? postalCode.trim() : null
	}


	String toString() {
		//"${firstName} ${lastName},${company ? company : ''},${streetAddress},${streetAddress2 ? streetAddress2 : ''},${city},${zone},${postalCode}"
		def result = null
		try {
			result = [
				"${firstName} ${lastName}",
				company,
				streetAddress,
				streetAddress2,
				city,
				zone?.id == 0 ?: zone?.code,
				postalCode
			]
		} catch (Exception e) {
			result = [
				"${firstName} ${lastName}",
				company,
				streetAddress,
				streetAddress2,
				city,
				postalCode
			]
		}
		result.findAll{ w -> (w != '' && w != null) }.join(', ')
	}

	String htmlFormatted() {
		def result = null
		try {
			result = [
				"${firstName} ${lastName}",
				company,
				streetAddress,
				streetAddress2,
				"${city}, ${zone?.id == 0 ?: zone?.code} ${postalCode}"
			]
		} catch (Exception e) {
			result = [
				"${firstName} ${lastName}",
				company,
				streetAddress,
				streetAddress2,
				"${city}, ${postalCode}"
			]
		}
		result.findAll{ w -> (w != '' && w != null) }.join('<br />')
	}

	boolean isLike(Address address) {
		if (firstName != address.firstName) {return false}
		if (lastName != address.lastName) {return false}
		if (company != address.company) {return false}
		if (streetAddress != address.streetAddress) {return false}
		if (streetAddress2 != address.streetAddress2) {return false}
		if (postalCode != address.postalCode) {return false}
		if (city != address.city) {return false}
		if (zone != address.zone) {return false}
		if (country != address.country) {return false}

		return true
	}


	def correctCase() {
		firstName = StringUtils.capitalizeName(firstName)
		lastName = StringUtils.capitalizeName(lastName)
		company = StringUtils.capitalizeName(company)
		streetAddress = StringUtils.capitalizeName(streetAddress)
		streetAddress2 = StringUtils.capitalizeName(streetAddress2)
		city = StringUtils.capitalizeName(city)
	}

	def zoneList() {
		if (country) return Zone.findAllByCountry(country)

		Zone.list()
	}

	boolean isDomestic() {
		return country.domestic
	}
}
