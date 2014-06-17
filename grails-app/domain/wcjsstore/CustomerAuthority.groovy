package wcjsstore

import org.apache.commons.lang.builder.HashCodeBuilder

class CustomerAuthority implements Serializable {

	private static final long serialVersionUID = 1

	Customer customer
	Authority authority

	boolean equals(other) {
		if (!(other instanceof CustomerAuthority)) {
			return false
		}

		other.customer?.id == customer?.id &&
		other.authority?.id == authority?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (customer) builder.append(customer.id)
		if (authority) builder.append(authority.id)
		builder.toHashCode()
	}

	static CustomerAuthority get(long customerId, long authorityId) {
		CustomerAuthority.where {
			customer == Customer.load(customerId) &&
			authority == Authority.load(authorityId)
		}.get()
	}

	static boolean exists(long customerId, long authorityId) {
		CustomerAuthority.where {
			customer == Customer.load(customerId) &&
			authority == Authority.load(authorityId)
		}.count() > 0
	}

	static CustomerAuthority create(Customer customer, Authority authority, boolean flush = false) {
		def instance = new CustomerAuthority(customer: customer, authority: authority)
		instance.save(flush: flush, insert: true)
		instance
	}

	static boolean remove(Customer u, Authority r, boolean flush = false) {
		if (u == null || r == null) return false

		int rowCount = CustomerAuthority.where {
			customer == Customer.load(u.id) &&
			authority == Authority.load(r.id)
		}.deleteAll()

		if (flush) { CustomerAuthority.withSession { it.flush() } }

		rowCount > 0
	}

	static void removeAll(Customer u, boolean flush = false) {
		if (u == null) return

		CustomerAuthority.where {
			customer == Customer.load(u.id)
		}.deleteAll()

		if (flush) { CustomerAuthority.withSession { it.flush() } }
	}

	static void removeAll(Authority r, boolean flush = false) {
		if (r == null) return

		CustomerAuthority.where {
			authority == Authority.load(r.id)
		}.deleteAll()

		if (flush) { CustomerAuthority.withSession { it.flush() } }
	}

	static constraints = {
		authority validator: { Authority r, CustomerAuthority ur ->
			if (ur.customer == null) return
			boolean existing = false
			CustomerAuthority.withNewSession {
				existing = CustomerAuthority.exists(ur.customer.id, r.id)
			}
			if (existing) {
				return 'userRole.exists'
			}
		}
	}

	static mapping = {
		id composite: ['authority', 'customer']
		version false
	}
}
