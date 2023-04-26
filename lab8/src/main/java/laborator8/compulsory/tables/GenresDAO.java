package laborator8.compulsory.tables;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import laborator8.compulsory.DBConnection;

public class GenresDAO {
    
    Connection connection;

    public GenresDAO(Connection connection){
        try{
            this.connection = connection;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error creating table!");
        }
    }

    public void createTable(){
        try(Statement statement = connection.createStatement()){
            
                String querry = "CREATE TABLE IF NOT EXISTS genres(" +
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
            
                String querry = "SELECT * FROM genres";
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
            
                String querry = "DROP TABLE IF EXISTS genres";
                statement.executeUpdate(querry);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error dropping table!");
        }
    }

    public void printTable(){
        try(Statement statement = connection.createStatement()){
            
                String querry = "SELECT * FROM genres";
                ResultSet resultSet = statement.executeQuery(querry);
                while(resultSet.next()){
                    System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name"));
                }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error printing table!");
        }
    }

    public void insertGenre(String name){
        try(Statement statement = connection.createStatement()){
            
                String querry = "INSERT INTO genres(name) VALUES('" + name + "')";
                statement.executeUpdate(querry);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error inserting genre!");
        }
    }

    public void deleteGenre(String name){
        try(Statement statement = connection.createStatement()){
            
                String querry = "DELETE FROM genres WHERE name = '" + name + "'";
                statement.executeUpdate(querry);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error deleting genre!");
        }
    }

    public void updateGenre(String name, String newName){
        try(Statement statement = connection.createStatement()){
            
                String querry = "UPDATE genres SET name = '" + newName + "' WHERE name = '" + name + "'";
                statement.executeUpdate(querry);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error updating genre!");
        }
    }

    public Integer findByName(String name){
        try(Statement statement = connection.createStatement()){
            
                String querry = "SELECT * FROM genres WHERE name = '" + name + "'";
                ResultSet resultSet = statement.executeQuery(querry);
                if(resultSet.next()){
                    return resultSet.getInt("id");
                }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error finding genre!");
        }
        return null;
    }

    public String findById(Integer id){
        try(Statement statement = connection.createStatement()){
            
                String querry = "SELECT * FROM genres WHERE id = " + id;
                ResultSet resultSet = statement.executeQuery(querry);
                if(resultSet.next()){
                    return resultSet.getString("name");
                }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error finding genre!");
        }
        return null;
    }
}
