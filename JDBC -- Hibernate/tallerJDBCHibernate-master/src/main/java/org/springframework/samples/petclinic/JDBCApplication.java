package org.springframework.samples.petclinic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.springframework.samples.petclinic.owner.Owner;

public class JDBCApplication {

	public static void main(String[] args) {
		System.out.println("-------- Test de conexión con MySQL ------------");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("No encuentro el driver en el Classpath");
			e.printStackTrace();
			return;
		}

		System.out.println("Driver instalado y funcionando");
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/petclinic","root", "root");
			if (connection != null)
				System.out.println("Conexión establecida");
			
			//-----------------------------------------------------------------------
			//listar(connection);
			//crear(connection);
			//modificar(connection);
			reto(connection);
			
			
			
			
		    
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		} finally {
			try {
				if(statement != null)
					connection.close();
			} catch (SQLException se) {
		    	  
		    }
		    try {
		        if(connection != null)
		            connection.close();
		    } catch (SQLException se) {
		         	se.printStackTrace();
		    }
		}
		
		

	}
	
	public static void listar(Connection connection) {
		Statement statement = null;
		
		System.out.println("consulta: ");
		try {
			statement = connection.createStatement();
			String consulta = "SELECT * FROM owners";			
			
			ResultSet res = statement.executeQuery(consulta);
			while(res.next()) {
				int id = res.getInt("id");
				String city = res.getString("city");
				
				System.out.println("ID: "+id);
				System.out.println("City: "+city);
			}
			res.close();
			
		} catch (SQLException e) {
			System.out.println("Query Error");
			e.printStackTrace();
		}
	}
	public static void crear(Connection connection) {
		Statement statement = null;
		String crear = null;
		
		
		try {
			statement = connection.createStatement();
			
			System.out.println("Insertar un OWNER: ");
			//creo owner
			crear = "INSERT INTO owners (first_name, last_name, address, city, telephone) VALUES ('paco3','garcia','sevilla','sevilla',111111111)";			
			statement.executeUpdate(crear);
			
			System.out.println("busca el OWNER: ");
			int id_owner = 0;
			String consultaOwner = "SELECT * FROM owners WHERE first_name LIKE 'paco3'";			
			ResultSet resOwner = statement.executeQuery(consultaOwner);
			while(resOwner.next()) {
				id_owner = resOwner.getInt("id");
				System.out.println("OWNER: "+id_owner);
			}
			
			
			//creo type
			System.out.println("inserta un tipo: ");
			crear = "INSERT INTO types (name) VALUES ('tipo_paco')";			
			statement.executeUpdate(crear);
			
			System.out.println("busca un tipo: ");
			int id_type = 0;
			String consultaType = "SELECT * FROM types WHERE name LIKE 'tipo_pepe'";			
			ResultSet resType = statement.executeQuery(consultaType);
			while(resType.next()) {
				id_type = resType.getInt("id");
				System.out.println("type: "+id_type);
			}
			
			
			//creo pets
			System.out.println("crea pets:  ");
			crear = "INSERT INTO pets (name, birth_date, type_id, owner_id) VALUES ('fran', '2000-01-01', "+id_type+","+id_owner+")";			
			statement.executeUpdate(crear);
			

			
		} catch (SQLException e) {
			System.out.println("crear Error");
			e.printStackTrace();
		}
	}
	public static void listaParametros(Connection connection) {
		PreparedStatement preparedStatement = null;
		int id = 2235;
	
		try {
			System.out.println("busca el OWNER: ");
			String consultaOwner = "SELECT * FROM owners  WHERE id = ?;";
			preparedStatement.setInt(2235,2);
			ResultSet resOwner = preparedStatement.executeQuery(consultaOwner);
			

			while(resOwner.next()) {
				System.out.println("OWNER: "+resOwner.getInt("id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	public static void modificar(Connection connection) {
		Statement statement = null;
		
		System.out.println("modificar: ");
		try {
			statement = connection.createStatement();
			String consulta = "UPDATE owners SET city = 'editado' WHERE id = 2235;";			
			
			statement.executeUpdate(consulta);
			
		} catch (SQLException e) {
			System.out.println("Query Error");
			e.printStackTrace();
		}
	}
	public static void reto(Connection connection) {
		Owner o = new Owner();
		o.setFirstName("nombre");
		o.setLastName("apellido");
		o.setAddress("direccion");
		o.setCity("sevilla");
		o.setTelephone("111111111");
		
			
		PreparedStatement preparedStatement = null;
	
		try {
			String crear = "INSERT INTO owners (first_name, last_name, address, city, telephone) VALUES (?,?,?,?,?)";	
			preparedStatement.setString(1, o.getFirstName());
			preparedStatement.setString(2, o.getLastName());
			preparedStatement.setString(3, o.getAddress());
			preparedStatement.setString(4, o.getCity());
			preparedStatement.setString(5, o.getTelephone());
			
			ResultSet resOwner = preparedStatement.executeQuery(crear);
			

			while(resOwner.next()) {
				System.out.println("OWNER: "+resOwner.getInt("id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
