# Application.properties
```
spring.jpa.hibernate.ddl-auto=<create | create-drop | update | validate | none>
```
- create – On application start-up, drop all tables managed by Hibernate, then create them from scratch.
- create-drop – On application start-up, create all tables managed by Hibernate. On shutdown, drop all of them.
- update – On application start-up, update the existing tables to match the schema Hibernate expects if necessary.
- validate – On application start-up, check that the existing tables match the schema Hibernate expects, and throw an exception if they do not match.
- none – Do not perform any automatic schema management.
# Table Relation
Creates only one foreign key column in table 1 that points to table 2

Table / Model 1
```java
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Person2 {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int id;
	String name;

	@ManyToOne
	City city;

	public Person2() { }

	public Person2(String name, City city) {
    	this.name = name;
    	this.city = city;
	}
}
```
Table / Model 2
```java
@Entity
@Data
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	public String getCityName() {
    	return cityName;
	}

	public int getId() {
    		return id;
	}

	private String cityName;

	public City() { }

	public City(String cityName) {
    	this.cityName = cityName;
	}
}
```

Person DTO
```java
@Data
public class PersonDTO {
	String personName;
	String cityName;

	public PersonDTO() {}

	public PersonDTO(String personName, String cityName) {
    	this.personName = personName;
    	this.cityName = cityName;
	}
}
```
Controller
```java
@GetMapping("/p")
List<PersonDTO> getPeople() {
	List<PersonDTO> list = new ArrayList<>();
	for(Person2 person: person2Repo.findAll())
		list.add(new PersonDTO(person.name, person.city.getCityName()));
   	return list;
}

@PostMapping("/p")
Person2 addPerson(@RequestBody Person2 person) {
	try {
		return person2Repo.save(person);
    } catch (Exception e) {
		return new Person2("PERSON NOT SAVED", new City("Ludhiana"));
    }
}
```

# Password Hashing
```java
Password hashing
@Bean
public PasswordEncoder passwordEncoder() {
	return PasswordEncoderFactories.createDelegatingPasswordEncoder();
}

@Autowired
PasswordEncoder passwordEncoder;

public UserDetails updatePassword(UserDetails user, String newPass) {
    CustomUserDetails customUserDetails = (CustomUserDetails) user;
    customUserDetails.setPassword(passwordEncoder.encode(newPass));
    userRepo.save(customUserDetails);
    return customUserDetails;
}
```

# Raw SQL
```java
// Repo 
@Query(value = "SELECT new ResultDTO(c.id, o.id, p.id, c.name, c.email, o.orderDate, p.productName, p.price) "
  + " from Customer c, CustomerOrder o ,Product p "
  + " where c.id=o.customer.id "
  + " and o.id=p.customerOrder.id "
  + " and c.id=?1 ")
List<ResultDTO> findResultDTOByCustomer(Long id);

// dto
class DTO {
	private Long customer_id;
	private Long order_id;
	private Long product_id;
	// constructor, getter, setter
}

// entity
@Entity
@IdClass(DTO.class)
public class ResultDTO {
	@Id
	private Long customer_id;
	@Id
	private Long order_id;
	@Id
	private Long product_id;
	private String customerName;
	private String customerEmail;
	private LocalDate orderDate;
	private String productName;
	private Double productPrice;
	// getters, setters, constructors etc
}
```

```java
// repo
@Query("SELECT u FROM User u WHERE u.status = 1")
Collection<User> findAllActiveUsers();

@Query(	value = "SELECT * FROM USERS u WHERE u.status = 1", nativeQuery = true)
Collection<User> findAllActiveUsersNative();
```
# Spring Security
To disable login page
`(exclude = { SecurityAutoConfiguration.class })`
