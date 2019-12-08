package saxion.nl;

import java.sql.*;
import java.util.*;
import java.util.concurrent.Executor;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        DBmanager db = DBmanager.getInstance();
        CityDAO cityDAO = CityDAO.getInstance(db);


        //tester to find all names of cities starting with a user-input string
        ArrayList<String> allCitiesOnEn = new ArrayList<>(); //creating and initializing new ArrayList which will be returned will all the city names
        System.out.println("Please enter the string for which you want to search the name."); //asking for user input of the string with which we want the cities to be searched
        Scanner searchForCity = new Scanner(System.in); //scanning entered user input
        String searchForThis = searchForCity.nextLine(); //the scanner is converted into a string



        //for some reason, starting here, I can't debug this section
        boolean userEnteredCountry = false;
        System.out.println("Please enter the country from which you want the cities to be searched. If no country is entered, all cities worldwide containing the previously entered letters will be returned");

        try (Scanner searchForCityInCountry = new Scanner(System.in)) {
            String searchInCountry;
            if (!((searchInCountry = searchForCityInCountry.nextLine()).isEmpty())) ;
            {
                userEnteredCountry = true; //if the searchInCountry string turns out not to be empty, then we set userEnteredCountry to true, meaning that the user DID enter a country
                allCitiesOnEn = cityDAO.getCityNames(searchForThis, userEnteredCountry, searchInCountry); //calling getCityNames from cityDAO, specifying that there was indeed a user input for the country to be searched
                //we are calling getCityNames with a TRUE
                System.out.println(allCitiesOnEn);
            } //make sure this is an if statement; if it is a while, it will run eternally
        }
        finally {
            if (userEnteredCountry = false) {
                allCitiesOnEn = cityDAO.getCityNames(searchForThis, false, "");
                System.out.println("Second test");
                System.out.println(allCitiesOnEn);
            }
        }
    }
}
//        String searchInCountry;
//        try
//        {
//            searchInCountry = searchForCityInCountry.toString();
//        }
//        catch(InputMismatchException ime)
//        {
//            System.out.println("yolo");
//        }
//        allCitiesOnEn = cityDAO.getCityNames(searchForThis); //setting the value of the ArrayList by calling the method getCityNames, which returns an ArrayList of all cities with the letters passed to it
//        System.out.println(allCitiesOnEn); //print out the ArrayList, containing all of those cities

        //over here, search for city names only in the country specified
        //use nextLine() and not toString()

