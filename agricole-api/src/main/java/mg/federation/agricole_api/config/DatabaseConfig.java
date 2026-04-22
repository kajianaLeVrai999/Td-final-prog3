package mg.federation.agricole_api.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Bean
    public DataSource getDataSource() {
        return DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url(System.getenv("JDBC_URL") != null ? System.getenv("JDBC_URL") : "jdbc:postgresql://localhost:5432/agricole_db")
                .username(System.getenv("DB_USER") != null ? System.getenv("DB_USER") : "postgres")
                .password(System.getenv("DB_PASSWORD") != null ? System.getenv("DB_PASSWORD") : "postgres")
                .build();
    }
}