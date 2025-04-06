package com.Dalgo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Queue;


@WebServlet("/Search")
public class Search extends HttpServlet {

    protected void doGet(HttpServletRequest rqst, HttpServletResponse resp) throws IOException{
        String key = rqst.getParameter("keyword");
        System.out.println(key);

        //out.println(key);
        try {

            //results after running query
            Connection connection = DB_Connection.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("select pageTitle, pageLink,  (length(lower(pageText)) - length(replace(lower(pageText), '"+key.toLowerCase()+"' , ''))) / length('"+key.toLowerCase()+"') as countouccerence from pages order by countouccerence desc limit 30;");
                                                                                                           // ^ ei bracket ta na deyay amr search result olot palot hoye jacchilo
            ArrayList<ResultSearch> results = new ArrayList<ResultSearch>();
            //Queue<String> history = new Queue<>();
            // transferring values from resultSet to arrayList
            while(resultSet.next()){
                ResultSearch resultSearch = new ResultSearch();
                resultSearch.setTitle(resultSet.getString("pageTitle"));
                resultSearch.setLink(resultSet.getString("pageLink"));
                results.add(resultSearch);


            }
            // displaying results arraylist in console
            for(ResultSearch result : results){
                System.out.println(result.getTitle()+"\n"+result.getLink()+"\n");
            }
            rqst.setAttribute("results", results);
            rqst.getRequestDispatcher("search.jsp").forward(rqst,resp);
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

    }


}
