package data;

import com.sun.javafx.tools.resource.PackagerResource;
import maintenance.Product;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by admin on 4/27/16.
 */

public class DBConnect {

    public static void main(String[] args) {
        Product p = new Product();
        p.setCode("hello2");
        p.setDescription("updated");
        p.setPrice(12.25);
        updateProduct(p);

        ArrayList<Product> products = selectProducts();
        for (Product x : products){
            System.out.println(x.getCode() + " " + x.getDescription() + " " + x.getPrice()/100.0);
        }
    }

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3333/MusicStore", "root", "root");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return con;
        }
    }

    //This method returns null if a product isn't found.
    public static Product selectProduct(String productCode)
    {

        Connection connection = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Product " +
                "WHERE ProductCode = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, productCode);
            rs = ps.executeQuery();
            if (rs.next())
            {
                Product p = new Product();
                p.setCode(rs.getString("ProductCode"));
                p.setDescription(rs.getString("ProductDescription"));
                p.setPrice(rs.getInt("ProductPrice")/100.0);
                return p;
            }
            else
            {
                return null;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
        }
    }

    //This method will return 0 if productID isn't found.
    public static int selectProductID(Product product)
    {
        Connection connection = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT ProductID FROM Product " +
                "WHERE ProductCode = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, product.getCode());
            rs = ps.executeQuery();
            rs.next();
            int productID = rs.getInt("ProductID");
            return productID;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return 0;
        }
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            DBUtil.closeConnection(connection);
        }
    }

    //This method returns null if a product isn't found.
    public static Product selectProduct(int productID)
    {
        Connection connection = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Product " +
                "WHERE ProductID = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setInt(1, productID);
            rs = ps.executeQuery();
            if (rs.next())
            {
                Product p = new Product();
                p.setCode(rs.getString("ProductCode"));
                p.setDescription(rs.getString("ProductDescription"));
                p.setPrice(rs.getInt("ProductPrice")/100.0);
                return p;
            }
            else
            {
                return null;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            DBUtil.closeConnection(connection);
        }
    }

    //This method returns null if a product isn't found.
    public static ArrayList<Product> selectProducts()
    {
        Connection connection = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Product";
        try
        {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            ArrayList<Product> products = new ArrayList<Product>();
            while (rs.next())
            {
                Product p = new Product();
                p.setCode(rs.getString("ProductCode"));
                p.setDescription(rs.getString("ProductDescription"));
                p.setPrice(rs.getDouble("ProductPrice"));
                products.add(p);
            }
            return products;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            DBUtil.closeConnection(connection);
        }
    }

    public static boolean exists(String productCode){
        Product p = selectProduct(productCode);

        if(p != null) return true;
        return false;
    }

    public static void insertProduct(Product product){
        Connection connection = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "INSERT INTO Product " +
                "(`ProductID`, `ProductCode`, `ProductDescription`, `ProductPrice`) " +
                "VALUES (NULL, ?, ?, ?);";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, product.getCode());
            ps.setString(2, product.getDescription());
            ps.setInt(3, (int)(product.getPrice() * 100));
            ps.executeUpdate();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            DBUtil.closeConnection(connection);
        }

    }

    public static void updateProduct(Product product){
        //TODO uodateProduct()
        if(exists(product.getCode())){
            Connection connection = getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;

            String query = "UPDATE  `MusicStore`.`Product` SET  `ProductCode` =  ?," +
                    "`ProductDescription` =  ?," +
                    "`ProductPrice` =  ? WHERE  `Product`.`ProductCode` =?;";
            try {
                ps = connection.prepareStatement(query);
                ps.setString(1, product.getCode());
                ps.setString(2, product.getDescription());
                ps.setInt(3, (int)(product.getPrice() * 100));
                ps.setString(4, product.getCode());
                ps.executeUpdate();
            }catch(SQLException e)
            {
                e.printStackTrace();
            }
            finally
            {
                DBUtil.closeResultSet(rs);
                DBUtil.closePreparedStatement(ps);
                DBUtil.closeConnection(connection);
            }
        }else{
            System.out.println("Product with code: " + product.getCode() + " not found");
        }
    }

    public static void deleteProduct(Product product){
        //TODO deleteProduct()
    }


}
