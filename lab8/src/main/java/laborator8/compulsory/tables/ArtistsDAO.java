package laborator8.compulsory.tables;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import laborator8.compulsory.DBConnection;

public class ArtistsDAO {
    private Connection connection;

    public ArtistsDAO(Connection connection){
        try{
            this.connection = connection;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error creating ArtistsDAO!");
        }
    }

    public void createTable(){
        try(Statement statement = connection.createStatement()){
            
                String querry = "CREATE TABLE IF NOT EXISTS artists(" +
                                "id INT NOT NULL AUTO_INCREMENT," +
                                "name VARCHAR(100) NOT NULL," +
                                "PRIMARY KEY (id))";
                statement.executeUpdate(querry);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error creating table!");
        }
    }

    public Boolean tableExists(){
        try(Statement statement = connection.createStatement()){
            
                String querry = "SELECT * FROM artists";
                ResultSet resultSet = statement.executeQuery(querry);
                if(resultSet.next()){
                    return true;
                }

        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("Error finding table!");
        }
        return false;
    }

    public void dropTable(){
        try(Statement statement = connection.createStatement()){
            
                String querry = "DROP TABLE IF EXISTS artists";
                statement.executeUpdate(querry);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error dropping table!");
        }
    }

    public void printTable(){
        try(Statement statement = connection.createStatement()){
            
                String querry = "SELECT * FROM artists";
                ResultSet resultSet = statement.executeQuery(querry);
                while(resultSet.next()){
                    System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name"));
                }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error printing table!");
        }
    }

    public void insertArtist(String name){
        try(Statement statement = connection.createStatement()){

                String querry = "INSERT INTO artists(name) VALUES('" + name + "')";
                statement.executeUpdate(querry);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error inserting artist!");
        }
    }

    public void deleteArtist(int id){
        try(Statement statement = connection.createStatement()){
            
                String querry = "DELETE FROM artists WHERE id = " + id;     
                statement.executeUpdate(querry);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error deleting artist!");
        }
    }

    public void updateArtist(int id, String name){
        try(Statement statement = connection.createStatement()){
            
                String querry = "UPDATE artists SET name = '" + name + "' WHERE id = " + id;
                statement.executeUpdate(querry);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error updating artist!");
        }
    } 

    public Integer findByName(String name){
        try(Statement statement = connection.createStatement()){
            
                String querry = "SELECT id FROM artists WHERE name = '" + name + "'";
                ResultSet resultSet = statement.executeQuery(querry);
                if(resultSet.next()){
                    return resultSet.getInt("id");
                }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error finding artist!");
        }
        return null;
    }

    public String findById(int id){
        try(Statement statement = connection.createStatement()){
            
                String querry = "SELECT name FROM artists WHERE id = " + id;
                ResultSet resultSet = statement.executeQuery(querry);
                if(resultSet.next()){
                    return resultSet.getString("name");
                }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error finding artist!");
        }
        return null;
    }
}
