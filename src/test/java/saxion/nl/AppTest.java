//package saxion.nl;
//import static org.junit.Assert.assertTrue;
//import static saxion.nl.CityDAO.*;
//
//import org.junit.Test;
//
//import java.sql.PreparedStatement;
//import java.util.*;
//
///**
// * Unit test for simple App.
// */
//public class AppTest
//{
//    /**
//     * Rigorous Test :-)
//     */
//    @Test
//    public void shouldAnswerWithTrue()
//    {
//        DBmanager db = DBmanager.getInstance();
//        CityDAO cityDAO = CityDAO.getInstance(db);
//        assertTrue( true );
//        System.out.println("test");
//
//        //tester to find all names of cities starting with 'En'
//        ArrayList<String> allCitiesOnEn = new ArrayList<>(); //making a new arrayList. This array list will contain all of the cities with the letters typed by the user.
//
//
//        Scanner searchForCity = new Scanner(System.in); //new Scanner object
//        System.out.println("Please enter the string for which you want to search the name.");
//        System.out.println("testing");
//        String searchForThis = searchForCity.toString(); //converting the scanned value to a string
//
//        Scanner searchForCityInCountry = new Scanner(System.in);
//        System.out.println("Please enter the country in which you want to search. If no country name is entered, a list of all cities with that name in the world will be returned.");
//
//
//
//
//        String searchInCountry;
//        try
//        {
//            searchInCountry = searchForCityInCountry.toString();
//        }
//        catch (InputMismatchException ime)
//        {
//            allCitiesOnEn = cityDAO.getCityNames(searchForThis); //setting the value of the ArrayList by calling the method getCityNames, which returns an ArrayList of all cities with the letters passed to it
//            System.out.println(allCitiesOnEn); //print out the ArrayList
//        }





//
//    }
//
//}
