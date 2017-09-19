package BasicsProject.Project1;

import redis.clients.jedis.JedisPool;

public class ThreadFactory {
	
	 public Thread GetThread(String ThreadType,String ThreadName,JedisPool jedPOOL){
		 
	      try {
			if(ThreadType == null){
			     return null;
			  }if(ThreadType.equalsIgnoreCase("Redis_Thread1")){
			     return  new Thread(new Redis_Thread1(ThreadName,jedPOOL));
			     
			  } else if(ThreadType.equalsIgnoreCase("Redis_Thread2")){
				  return  new Thread(new Redis_Thread2(ThreadName,jedPOOL));
			  }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

}
}