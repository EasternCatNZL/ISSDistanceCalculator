package coolName.issDistance;

import java.io.IOException;

import ApiCaller.ApiCaller;
import DistanceCalculator.DistanceCalculator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        ApiCaller apiCaller = new ApiCaller();
        DistanceCalculator distanceCalculator = new DistanceCalculator(apiCaller);
        
        System.out.println("Distance from HK to ISS in km is: " + distanceCalculator.doCalculations());
    }
}
