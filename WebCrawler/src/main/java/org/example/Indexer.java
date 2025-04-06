package org.example;

import org.jsoup.nodes.Document;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Indexer {
    static Connection connecton = null;
    Indexer(Document doc, String url) throws SQLException, ClassNotFoundException {
        String title = doc.title();
        String link = url;
        String text = doc.text();

        connecton = DB_Connection.getConnection();
        PreparedStatement prepardStatmnt = connecton.prepareStatement("Insert into pages values(?, ?, ?);");
        prepardStatmnt.setString((1), title);
        prepardStatmnt.setString((2), link);
        prepardStatmnt.setString((3), text);
        prepardStatmnt.executeUpdate();
    }

}
