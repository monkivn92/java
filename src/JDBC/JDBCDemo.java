package JDBC;

import java.sql.*;

public class JDBCDemo
{

    public static void main(String[] args)
    {
        Connection conn = null;
        try
        {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        }
        catch (Exception ex)
        {
           System.out.println(ex);
        }
        try
        {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/pxr_lyme?" +
                            "user=root&password=vuongpv");

        }
        catch (SQLException ex)
        {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        ///////////////////////////////////////////////////////////////

        if(conn != null)
        {
            System.out.println("Connected");
            try
            {
                Statement stmt = conn.createStatement();
                String sql;
                sql = "select name, email FROM jcn25_users where id>50";
                ResultSet rs = stmt.executeQuery(sql);

                while(rs.next())
                {
                    System.out.println(rs.getString("name"));
                    System.out.println(rs.getString("email"));
                }
                //STEP 6: Clean-up environment
                rs.close();
                stmt.close();
                conn.close();
            }
            catch(SQLException e)
            {
                System.out.println(e);
            }

        }



    }

}
