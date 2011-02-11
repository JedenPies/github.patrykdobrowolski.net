package pl.jedenpies.blog;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import org.springframework.core.io.UrlResource;

import pl.jedenpies.blog.dao.GenericDao;
import pl.jedenpies.blog.db.hibernate.dao.factory.HibernateDaoFactory;
import pl.jedenpies.blog.domain.Wpis;

public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String args[]) throws IOException {
//		HibernateDaoFactory f = new HibernateDaoFactory();
//		GenericDao<Wpis> wdao = f.createDao(Wpis.class);
//		wdao.create(new Wpis());
//		System.out.println("koniec" + wdao);
//		URL[] urls = new URL[]{ new URL("http://repo2.maven.org/maven2/org/springframework/spring-tx/3.0.5.RELEASE/spring-tx-3.0.5.RELEASE.jar") };
		URL[] urls = new URL[]{ new URL("file://C:/Users/Patryk/.m2/repository/org/springframework/spring-tx/3.0.5.RELEASE/spring-tx-3.0.5.RELEASE.jar") };
		URLClassLoader cl = new URLClassLoader(urls);
		InputStream obj = cl.getResourceAsStream("overview.html");
		BufferedReader r = new BufferedReader(new InputStreamReader(obj));
		while (r.ready()) {
			System.out.println(r.readLine());
		}
		System.out.println(obj);
//		Object obj = ClassLoader.getSystemResourceAsStream("file://C:/Users/Patryk/.m2/repository/org/springframework/spring-tx/3.0.5.RELEASE/spring-tx-3.0.5.RELEASE.jar");
		
		
//		Object r = cl.getResource("file://C:/Users/Patryk/.m2/repository/org/springframework/spring-tx/3.0.5.RELEASE/spring-tx-3.0.5.RELEASE.jar");
//		Object o = cl.findResource("overview.html");
////		UrlResource r = new UrlResource("C:/Users/Patryk/.m2/repository/org/springframework/spring-tx/3.0.5.RELEASE/spring-tx-3.0.5.RELEASE.jar");
		File file = new File(
		"jar:file:/C:/Users/Patryk/.m2/repository/org/springframework/spring-core/3.0.5.RELEASE/spring-core-3.0.5.RELEASE.jar!/overview.html");		
		System.out.println(file.exists());
	}
}
