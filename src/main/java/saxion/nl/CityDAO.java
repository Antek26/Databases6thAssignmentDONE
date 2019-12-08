package saxion.nl;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;



public class CityDAO {
    private static CityDAO uniqueInstance = null;
    private static Connection connection = null;

    private CityDAO (DBmanager db ) { //precondition dbExists
        if ((connection = db.getConnection()) == null ) //connect to the city db
            System.err.println (">>> saxion.nl.CityDAO : The database doesn't exist ...");
    }
// apply singleton design pattern to CityDao


    public static synchronized CityDAO getInstance (DBmanager db )
    {
        if (uniqueInstance == null)
        {
            uniqueInstance = new CityDAO(db);
        }
        return uniqueInstance;
    }


    public static ArrayList<String> getCityNames(String cityName, boolean userEnteredCountry, String countryName) { //I made this a static method, so that we may access it from the AppTest class without having to create an object
        ArrayList<String> cityNames = new ArrayList<String>(); //making a new ArrayList. This will be the ArrayList we will be returning, with all the cities with a given name in the database

        if (userEnteredCountry == false)
        {
            PreparedStatement preparedStatement = null;
            //PreparedStatement countryStatement = null;
            try //this exception handling is to try and establish a connection
            {
                preparedStatement = connection.prepareStatement("SELECT * FROM city WHERE name LIKE ?");
                preparedStatement.setString(1, cityName + "%"); //


                ResultSet resultSet = preparedStatement.executeQuery(); //executing the query in the databases we just connected to
                while (resultSet.next()) {
                    cityNames.add(resultSet.getString("name"));
                }
            } catch (SQLException se) {
                se.printStackTrace();
            } finally {
                try {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }// nothing we can do
            return cityNames; //returning the ArrayList filled with all cities worldwide with the user-input name
        }



        else
        {
            PreparedStatement countryStatement = null;
            //PreparedStatement countryStatement = null;
            try //this exception handling is to try and establish a connection
            {
                countryStatement = connection.prepareStatement("SELECT *  FROM city JOIN country ON country.code = city.countrycode WHERE country.name LIKE ? AND city.name LIKE ?");
                countryStatement.setString(1, countryName + "%"); //
                countryStatement.setString(2, cityName + "%");


                ResultSet resultSet = countryStatement.executeQuery(); //executing the query in the databases we just connected to
                while (resultSet.next()) {
                    cityNames.add(resultSet.getString("city.name"));
                }
            } catch (SQLException se) {
                se.printStackTrace();
            } finally {
                try {
                    if (countryStatement != null) {
                        countryStatement.close();
                    }
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }// nothing we can do
        }
            return cityNames; //return the ArrayList filled with names of cities with the user-input string, in the user-specified country
    }

}

