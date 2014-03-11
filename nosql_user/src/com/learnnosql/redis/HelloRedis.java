package com.learnnosql.redis;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class HelloRedis {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("127.0.0.1", 9999);
		jedis.set("foo", "bar");
		String value = jedis.get("foo");
		System.out.println(value);
		
		//A little more practical example.
		
		// Here our data construct is in the form of
		// a Set containing keys of different lists.
		
		jedis.sadd("NewData", "lines");
		jedis.rpush("lines", 				
				new String[]{
				"These are the lines",
				"Upon which the entire product is based",
				"Waiting to be shipped"});
		
		jedis.sadd("NewData", "fruits");
		jedis.rpush("fruits", 				
				new String[]{
				"Apple",
				"Banana",
				"Coconut",
				"Kiwi"});

		////////////Access this data
		
		
		Set<String> dataLists = jedis.smembers("NewData");
		for(String list : dataLists){
			System.out.println("For list: "+list);
			List<String> values = jedis.lrange(list, 0, -1);
			for(String valu: values){
				System.out.println("    "+valu);
			}
		}
	}

}
