import java.util.HashMap;
import java.util.Map;

/**
 * 
 */

/**
 * @author Sanjeev
 *
 */
public class LambdaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<String,Integer> nameAgeMap=new HashMap<String,Integer>();
		
		nameAgeMap.put("John", 25);
		nameAgeMap.put("Poll", 35);
		nameAgeMap.put("Duke", 21);
		
		//Integer nameSize=nameAgeMap.computeIfAbsent("John", s-> s.length());
		nameAgeMap.forEach((k,v)->{ if (k.startsWith("j"))
                                     v=45;
                                   });		

	}

}
