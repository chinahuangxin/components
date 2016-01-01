package gnnt.MEBS.util.spring.rmi.test;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("rmi_client.xml");

		ApplicationContext content = new ClassPathXmlApplicationContext(list
				.toArray(new String[list.size()]));

		ITest test = (ITest) content.getBean("test");
		
		System.out.println(test.test());
	}
}