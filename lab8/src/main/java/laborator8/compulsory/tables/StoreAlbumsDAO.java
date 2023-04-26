package laborator8.compulsory.tables;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import laborator8.compulsory.DBConnection;

public class StoreAlbumsDAO {
    
    Connection connection;

    public StoreAlbumsDAO(Connection connection){
        try{
            this.connection = connection;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error creating StoreAlbumsDAO!");
        }
    }

    public void createTable(){
        try(Statement statement = connection.createStatement()){
            
                String querry = "CREATE TABLE IF NOT EXISTS store_albums(" +
                                "album_id INT NOT NULL," +
                                "genre_id INT NOT NULL," +
                                "PRIMARY KEY (album_id, genre_id)," +
                                "FOREIGN KEY (album_id) REFERENCES albums(id)," +
                                "FOREIGN KEY (genre_id) REFERENCES genres(id))";

                statement.executeUpdate(querry);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error creating table!");
        }
    }

    public Boolean tableExists(){
        try(Statement statement = connection.createStatement()){
            
                String querry = "SELECT * FROM store_albums";
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
            
                String querry = "DROP TABLE IF EXISTS store_albums";
                statement.executeUpdate(querry);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error dropping table!");
        }
    }

    public void printTable(){
        try(Statement statement = connection.createStatement()){
            
                String querry = "SELECT * FROM store_albums";
                ResultSet resultSet = statement.executeQuery(querry);
                while(resultSet.next()){
                    System.out.println("Album id: " + resultSet.getInt("album_id") + " Genre id: " + resultSet.getInt("genre_id"));
                }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error printing table!");
        }
    }

    public void insertGenreAlbums(int album_id, int genre_id){
        try(Statement statement = connection.createStatement()){
            
                String querry = "INSERT INTO store_albums(album_id, genre_id) VALUES(" + album_id + ", " + genre_id + ")";
                statement.executeUpdate(querry);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error inserting data!");
        }
    }

    public void deleteGenreAlbums(int album_id, int genre_id){
        try(Statement statement = connection.createStatement()){
            
                String querry = "DELETE FROM store_albums WHERE album_id = " + album_id + " AND genre_id = " + genre_id;
                statement.executeUpdate(querry);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error deleting data!");
        }
    }

    public void updateGenreAlbums(int album_id, int genre_id, int new_album_id, int new_genre_id){
        try(Statement statement = connection.createStatement()){
            
                String querry = "UPDATE store_albums SET album_id = " + new_album_id + ", genre_id = " + new_genre_id + " WHERE album_id = " + album_id + " AND genre_id = " + genre_id;
                statement.executeUpdate(querry);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error updating data!");
        }
    }

    public void findByAlbumId(int album_id){
        try(Statement statement = connection.createStatement()){
            
                String querry = "SELECT * FROM store_albums WHERE album_id = " + album_id;
                ResultSet resultSet = statement.executeQuery(querry);
                while(resultSet.next()){
                    System.out.println("Album id: " + resultSet.getInt("album_id") + " Genre id: " + resultSet.getInt("genre_id"));
                }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error finding data!");
        }
    }

    public void findByGenreId(int genre_id){
        try(Statement statement = connection.createStatement()){
            
                String querry = "SELECT * FROM store_albums WHERE genre_id = " + genre_id;
                ResultSet resultSet = statement.executeQuery(querry);
                while(resultSet.next()){
                    System.out.println("Album id: " + resultSet.getInt("album_id") + " Genre id: " + resultSet.getInt("genre_id"));
                }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error finding data!");
        }
    }
}
