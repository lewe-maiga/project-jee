package app;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Person {
	private String idPerson;
	private String name;
	private String email;
	private String phone;
	private String password;
	private String type;
	public String getIdPerson() {
		return idPerson;
	}
	
	
	public Person(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public Person(String idPerson, String name, String email, String phone, String password, String type) {
		super();
		this.idPerson = idPerson;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.type = type;
	}
	public Person(String idPerson, String name, String email, String phone, String password) {
		super();
		this.idPerson = idPerson;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
	
	public Person(String name, String email, String phone, String password) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
	
	public Person() {
		super();
		
	}
	

	public void setIdPerson(String idPerson) {
		this.idPerson = idPerson;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	public static Person select(String id) throws SQLException {
		String query = "SELECT * FROM persons WHERE idPerson=?";
		PreparedStatement statement = BdConnection.bdConnection.prepareStatement(query);
		statement.setString(1, id);
		ResultSet result = statement.executeQuery();
		Person person = null;
		while(result.next()) {
			person = new Person(result.getString("idPerson"), result.getString("name"), result.getString("email"), result.getString("phone"), result.getString("password"), result.getString("type"));
		}
		return person;
		
		
	}
	
	public static ArrayList<Person>selectAll() throws SQLException{
		String query = "SELECT * FROM persons";
		PreparedStatement statement = BdConnection.bdConnection.prepareStatement(query);
			ArrayList<Person> persons = new ArrayList<Person>();
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				persons.add(new Person(result.getString("idPerson"), result.getString("name"), result.getString("email"), result.getString("phone"),result.getString("password"), result.getString("type")));
			}
			return persons;
	}
	
	
	public boolean authentification() throws SQLException {
		String query = "SELECT * FROM persons where email = ? and password = sha2(?, 224)";
		boolean isAuth = false;
		PreparedStatement statement = BdConnection.bdConnection.prepareStatement(query);
		
			statement.setString(1, email);
			statement.setString(2, password);
			ResultSet result = statement.executeQuery();
			Person person = null;
			while(result.next()) {
				//String idPerson, String name, String email, String phone, String password, String type
				person = new Person( result.getString("email"), result.getString("password"));
				isAuth = true;
				System.out.println(person.toString());
				
			}
		return isAuth;
		
	}
	
	
	
	public static void delete(String id) throws SQLException {
		String query = "DELETE FROM persons WHERE idPerson = ?";
		PreparedStatement statement = BdConnection.bdConnection.prepareStatement(query);
		statement.setString(1, id);
		statement.execute();
		System.out.print("Utilisateur supprime");
	}
	
	
	public static void update(Person person) throws SQLException {
		String query = "UPDATE persons SET name= ?, email = ?, phone = ?, password = sha2(?, 224) WHERE idPerson = ?";
		PreparedStatement statement = BdConnection.bdConnection.prepareStatement(query);
		statement.setString(1, person.name);
		statement.setString(2, person.email);
		statement.setString(3, person.phone);
		statement.setString(4, person.password);
		statement.setString(5, person.idPerson);
		statement.execute();
		System.out.print("Utilisateur mis à jour");
	}
	
	public static void insert(Person person) throws SQLException {
		String query = "INSERT INTO persons(name, email, phone, password) VALUES (?, ?, ?, sha2(?, 224))";
		PreparedStatement statement = BdConnection.bdConnection.prepareStatement(query);
		statement.setString(1, person.name);
		statement.setString(2, person.email);
		statement.setString(3, person.phone);
		statement.setString(4, person.password);
		statement.execute();
		System.out.print("Utilisateur crée");
	}
	
	
	
	
	@Override
	public String toString() {
		return "Person [idPerson=" + idPerson + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", password=" + password + ", type=" + type + "]";
	}
	
	
}
