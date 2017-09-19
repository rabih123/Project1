package BasicsProject.Project1;

import java.util.List;
import redis.clients.jedis.JedisPool;

public class Redis_Thread2 implements Runnable {
	private String ThreadName ;
	private JedisPool jedPOOL ;
	
	public Redis_Thread2(String ThrdName, JedisPool jedPOOL) {
		ThreadName=ThrdName;
		this.jedPOOL=jedPOOL;
	}
	
	public void run()
	{
		try {
			RedisHandler r1 =  new RedisHandler(jedPOOL) ;

			r1.LPush("TestList", "Rab3"); 
			r1.LPush("TestList", "Rab2"); 
			r1.LPush("TestList", "Rab1"); 
			
			System.out.println("--------------------------- " + ThreadName);
			System.out.println("Here List to check :");
   
			List<String> list = r1.lrange("TestList", 0 ,2); 
			
			for(int i = 0; i<list.size(); i++) { 
			     System.out.println("Stored string in redis: "+list.get(i)); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	
	}
}
