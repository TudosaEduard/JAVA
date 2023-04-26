package laborator8.compulsory.tables;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class AlbumsDAO {

    Connection connection;

    public AlbumsDAO(Connection connection){
        try{
            this.connection = connection;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error creating AlbumsDAO!");
        }
    }

    public void createTable(){
        try(Statement statement = connection.createStatement()){
            
                String querry = "CREATE TABLE IF NOT EXISTS albums(" +
                                "id INT NOT NULL AUTO_INCREMENT," +
                                "title VARCHAR(100) NOT NULL," +
                                "release_year INT NOT NULL," +
                                "genre VARCHAR(100) NOT NULL," +
                                "artist VARCHAR(100) NOT NULL," +
                                "PRIMARY KEY (id))";
                statement.executeUpdate(querry);

        } catch (Exception e) {
            //e.printStackTrace();
            e.getMessage();
            System.out.println("Error creating table!");
        }   
    }

    public Boolean tableExists(){
        try(Statement statement = connection.createStatement()){
            
                String querry = "SELECT * FROM albums";
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
            
                String querry = "DROP TABLE IF EXISTS albums";
                statement.executeUpdate(querry);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error dropping table!");
        }
    }

    public void printTable(){
        try(Statement statement = connection.createStatement()){
            
                String querry = "SELECT * FROM albums";
                ResultSet resultSet = statement.executeQuery(querry);
                while(resultSet.next()){
                    System.out.println(resultSet.getInt("id") + " " + resultSet.getString("title") + " " + resultSet.getInt("release_year") + " " + resultSet.getString("genre") + " " + resultSet.getString("artist"));
                }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error printing table!");
        }
    }

    public void insertAlbum(String title, int release_year, String genre, String artist){
        try(Statement statement = connection.createStatement()){
            
                String querry = "INSERT INTO albums(title, release_year, genre, artist) VALUES('" + title + "', " + release_year + ", '" + genre + "', '" + artist + "')";
                statement.executeUpdate(querry);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error inserting album!");
        }
    }

    public void deleteAlbum(int id){
        try(Statement statement = connection.createStatement()){
            
                String querry = "DELETE FROM albums WHERE id = " + id;
                statement.executeUpdate(querry);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error deleting album!");
        }
    }

    public void updateAlbum(int id, String title, int artist_id, int release_year, String genre){
        try(Statement statement = connection.createStatement()){
            
                String querry = "UPDATE albums SET title = '" + title + "', artist_id = " + artist_id + 
                ", release_year = " + release_year + 
                ", genre = '" + genre + "' WHERE id = " + id;
                statement.executeUpdate(querry);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error updating album!");
        }
    }

    public Integer findByTitle(String title){
        try(Statement statement = connection.createStatement()){
            
                String querry = "SELECT * FROM albums WHERE title = '" + title + "'";
                ResultSet resultSet = statement.executeQuery(querry);
                if(resultSet.next()){
                    return resultSet.getInt("id");
                }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error finding album!");
        }
        return null;
    }

    public String findById(int id){
        try(Statement statement = connection.createStatement()){
            
                String querry = "SELECT * FROM albums WHERE id = " + id;
                ResultSet resultSet = statement.executeQuery(querry);
                if(resultSet.next()){
                    return resultSet.getString("title");
                }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error finding album!");
        }
        return null;
    }
}
