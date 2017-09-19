package BasicsProject.Project1;


import redis.clients.jedis.JedisPoolConfig;
import BasicsProject.Project1.ThreadFactory;

public class ThreadFactoryDemo {
	public static void main(String[] args) {

		JedisPoolConfig JedisPoolConfig = new JedisPoolConfig();
		
		try {
			

			Thread t1 = new ThreadFactory().GetThread("Redis_Thread1",
					"Thread11",Singleton.getInstance(JedisPoolConfig, "localhost"));
			t1.start();

			Thread t2 = new ThreadFactory().GetThread("Redis_Thread2",
					"Thread22",Singleton.getInstance(JedisPoolConfig, "localhost"));
			t2.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
