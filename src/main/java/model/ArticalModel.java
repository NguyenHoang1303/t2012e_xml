package model;

import entity.Artical;
import util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ArticalModel {

    public void insertArticle(Artical article) {
        try {
            Connection cnn = ConnectionHelper.getConnection();
            if (cnn == null) {
                System.err.println("can not open connect database");
                return;
            }
            PreparedStatement pp = cnn.prepareStatement("insert into articles (title, description, pubDate, link) values (?, ?, ?, ?)");
            pp.setString(1, article.getTitle());
            pp.setString(2, article.getDescription());
            pp.setString(3, article.getPubDate());
            pp.setString(4, article.getLink());
            pp.execute();
            System.out.println(article.toString());
            System.out.println("Success!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Fail!");
        }
    }

}
