package guru.springframework.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import guru.springframework.examplebeans.FakeDataSource;
import guru.springframework.examplebeans.FakeJMSBroker;

/**
 * Created by jt on 6/7/17.
 */
@Configuration

// No need
//@PropertySources(value = { @PropertySource(value = { "classpath:datasource.properties" }),
//		@PropertySource(value = { "classpath:jms.properties" }) })

public class PropertyConfig {

	@Autowired
	Environment env;

	@Value("${guru.db.username}")
	String dbUser;

	@Value("${guru.db.password}")
	String dbPassword;

	@Value("${guru.db.url}")
	String dbUrl;

	@Value("${guru.jms.username}")
	String jmsUser;

	@Value("${guru.jms.password}")
	String jmsPassword;

	@Value("${guru.jms.url}")
	String jmsUrl;

	@Bean
	public FakeDataSource fakeDataSource() {
		FakeDataSource fakeDataSource = new FakeDataSource();
		// fakeDataSource.setUser(env.getProperty("USERNAME"));
		fakeDataSource.setUser(dbUser);
		fakeDataSource.setPassword(dbPassword);
		fakeDataSource.setUrl(dbUrl);
		return fakeDataSource;
	}

	@Bean
	public FakeJMSBroker fakeJMSBroker() {
		FakeJMSBroker fakeJMSBroker = new FakeJMSBroker();
		fakeJMSBroker.setUser(jmsUser);
		fakeJMSBroker.setPassword(jmsPassword);
		fakeJMSBroker.setUrl(jmsUrl);
		return fakeJMSBroker;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		return propertySourcesPlaceholderConfigurer;
	}
}
