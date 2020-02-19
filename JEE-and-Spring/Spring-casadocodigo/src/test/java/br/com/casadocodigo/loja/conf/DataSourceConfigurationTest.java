package br.com.casadocodigo.loja.conf;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DataSourceConfigurationTest {

	@Bean
    @Profile("test")
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://192.168.0.10/casadocodigo_test");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("fernando");
        dataSource.setPassword("110ombro");
        return dataSource;
    }

}
