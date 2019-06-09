package coolName.issDistance;

import java.io.IOException;

import ApiCaller.ApiCaller;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        ApiCaller apiCaller = new ApiCaller();
        
        apiCaller.getJsonFromUrl("http://api.open-notify.org/iss-now.json");
    }
}
