package BasicsProject.Project1;

import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
    	Thread t = new Thread(new Redis_Thread1("Threa1", null),null);
    	t.start() ;
    	
    	Thread t2 = new Thread(new Runnable()
    	{

			public void run() {
				
				//JedisPool r1 =  RedisHandler.getInstance();
				//Jedis j1 =  r1.getResource();
				
				RedisHandler r1 =  new RedisHandler(null) ;

				r1.LPush("TestList", "Rab3"); 
				r1.LPush("TestList", "Rab2"); 
				r1.LPush("TestList", "Rab1"); 
				
				System.out.println("--------------------------- Thread2 ");
				System.out.println("Here List to check :");
			   
			    List<String> list = r1.lrange("TestList", 0 ,2); 
			    
			    for(int i = 0; i<list.size(); i++) { 
			         System.out.println("Stored string in redis: "+list.get(i)); 
			    } 
				
			}
    		
    	});

    	t2.start();
    	
    	//Thread t3 = new Thread(() -> {
    		
    	//});
    	

    	/*Redis_Thread1 t1 = new Redis_Thread1("Threa1") ;
    	t1.start();	
    	
    	Redis_Thread1 t2 = new Redis_Thread1("Threa2") ;
    	t2.start();	
    	
    	Redis_Thread1 t3 = new Redis_Thread1("Threa3") ;
    	t3.start();	*/
    }
}
