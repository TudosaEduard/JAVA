package laborator8;

import java.sql.Connection;
import java.sql.SQLException;

import laborator8.compulsory.DBConnection;
import laborator8.compulsory.tables.AlbumsDAO;
import laborator8.compulsory.tables.ArtistsDAO;
import laborator8.compulsory.tables.GenresDAO;
import laborator8.compulsory.tables.StoreAlbumsDAO;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws SQLException {
        App app = new App();
        app.compulsory();
    }

    public void compulsory() throws SQLException {
        DBConnection.createConnection();
        Connection connection = DBConnection.getConnection();

        var artists = new ArtistsDAO(connection);
        if(artists.tableExists()){
            artists.dropTable();
        }
        artists.createTable();
        artists.insertArtist("Pink Floyd");
        artists.insertArtist("Michael Jackson");
        connection.commit();

        var genres = new GenresDAO(connection);
        var albums = new AlbumsDAO(connection);
        var storeAlbums = new StoreAlbumsDAO(connection);

        if(albums.tableExists() && genres.tableExists()){
            storeAlbums.dropTable();
        }

        if(genres.tableExists()){
            genres.dropTable();
        }

        genres.createTable();
        genres.insertGenre("Rock");
        genres.insertGenre("Pop");
        connection.commit();

        if(albums.tableExists()){
            albums.dropTable();
        }

        albums.createTable();
        albums.insertAlbum("The Wall", 1979, "Rock", "Pink Floyd");
        albums.insertAlbum("Thriller", 1982, "Pop", "Michael Jackson");
        connection.commit();

        storeAlbums.createTable();
        storeAlbums.insertGenreAlbums(albums.findByTitle("The Wall").intValue(), genres.findByName("Rock").intValue());
        storeAlbums.insertGenreAlbums(albums.findByTitle("Thriller").intValue(), genres.findByName("Pop").intValue());
        connection.commit();

        connection.close();
    }
}
