import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * This web-spider is able to catch and display all websites in which has not been visited.
 * @author tle19
 *
 */
public class WebSpider {
	static Map<String, Boolean> result = new HashMap<String, Boolean>();
    public static void main(String[] args) {
    	/**
    	 * Try-catch the website in which starts http:
    	 */
        try {
        	String GossipCop = "http://www.gossipcop.com/";
        	result.put(GossipCop,  false);
        	String u = next();
        	while(u != null) {
            URL url = new URL(u);
            
            /**
             * Uses a reader to examine whether the pattern is displayed
             * 'Matcher' checks whether there's repeats links in the display
             */
            BufferedReader rdr = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            Pattern ptx = Pattern.compile("href=\"(http:.*?)\"");
            while ((line = rdr.readLine()) != null) {
                Matcher matcher = ptx.matcher(line);
                if (matcher.find()&& !result.containsKey(matcher.group(1))){
                	result.put(matcher.group(1), false);
                    System.out.printf("%s\n", matcher.group(1));
                }
            }
            u = next(); // Able to take the next website with link http:
        	}
        }
        catch (Exception ex) {
            System.out.printf("Oops: %s", ex.getMessage());
        }
    }
    /**
     * If the result string is false, display the website link
     * @return the key in which the unvisited website is displayed
     */
    private static String next(){
    	for (Map.Entry<String, Boolean>e: result.entrySet()) {
    		if (e.getValue() == false) {
    			result.put(e.getKey(), true);
    			return e.getKey();
    		}
    	}
    	return null;
    }
}

