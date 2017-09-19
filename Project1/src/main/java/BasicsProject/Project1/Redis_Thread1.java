package BasicsProject.Project1;

import redis.clients.jedis.JedisPool;

public class Redis_Thread1 implements Runnable {
	private String ThreadName;
	private JedisPool jedPOOL ;
	
	public Redis_Thread1(String ThrdName , JedisPool jedPOOL) {
		ThreadName = ThrdName;
		this.jedPOOL=jedPOOL;
	}

	public void run() {

		try {
			System.out.println("--------------------------- " + ThreadName);
			RedisHandler r1 = new RedisHandler(jedPOOL);
			r1.set("Test1", "Rabih");
			System.out.println(r1.get("Test1"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
