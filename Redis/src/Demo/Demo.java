package Demo;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class Demo {

	public static void main(String[] args) {
		Jedis jredis = new Jedis("localhost");
		jredis.set("sun", "sunming");
		jredis.set("sun", "sunzhen");
		
		System.out.println("���ӳɹ�");
		System.out.println("������������--��"+jredis.ping());
//		System.out.println("��������"+ jredis.get("sun"));
		jredis.lpush("site-list", "Runoob");
		jredis.lpush("site-list", "Google");
		jredis.lpush("site-list", "Taobao");
//		System.out.println("��������"+ jredis.get("a"));
		List<String> list = jredis.lrange("site-list", 0, 5);
		/*for( String item : list){
			System.out.println("�����--"+item);
		}*/
		for(int i =0;i<list.size();i++){
//			System.out.println(list.get(i));
		}
		Set<String> keys = jredis.keys("*");
		Iterator<String> it = keys.iterator();
		while(it.hasNext()){
			 String key = it.next();   
	         System.out.println("�����"+key);   
		}
		
	}
}
