<%@page import = "java.util.ArrayList"%>
<%@page import = "com.Dalgo.ResultSearch"%>
<html>
    <body>
        <table border = 2>
            <tr>
                <th> Title </th>
                 <th> Link </th>
            </tr>
             <%
                ArrayList<ResultSearch> results =  (ArrayList<ResultSearch>) request.getAttribute("results");
                for(ResultSearch result : results){

             %>
             <tr>
                  <td> <% out.println(result.getTitle()); %> </td>
                  <td> <a href = "<% out.println(result.getLink()); %>" > <% out.println(result.getLink()); %>" </a> </td>
             </tr>

              <%
                }
              %>

        </table>
    </body>
</html>