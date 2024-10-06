package org.example.cardgames.configurations;


//import com.zaxxer.hikari.HikariDataSource;
//import java.util.Map;
//import javax.sql.DataSource;
//import lombok.extern.slf4j.Slf4j;
//import org.example.cardgames.utils.Constants;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
///**
// * Database configuration
// */
//@Slf4j
//@Configuration
//@EnableJpaRepositories(basePackages = Constants.BASE_PACKAGE, entityManagerFactoryRef = "cardGamesEntityManager")
//@EntityScan(basePackages = {Constants.BASE_PACKAGE})
//@EnableTransactionManagement
public class DatasourceConfiguration {

//  private static final String SHOW_SQL = "hibernate.show_sql";
//  private static final String FORMAT_SQL = "hibernate.format_sql";
//
//
//  public DatasourceConfiguration() {
//  }
//
//  /**
//   * Entity Manager
//   *
//   * @param builder
//   * @return
//   */
//  @Bean
//  public LocalContainerEntityManagerFactoryBean cardGamesEntityManager(
//      EntityManagerFactoryBuilder builder) {
//    return builder.dataSource(cardGamesDataSource()).packages(Constants.BASE_PACKAGE)
//        .properties(Map.of(SHOW_SQL, false, FORMAT_SQL, false)).persistenceUnit("cardGames")
//        .build();
//  }
//
//  /**
//   * Data source initializer
//   *
//   * @return
//   */
//  @Bean
//  public DataSource cardGamesDataSource() {
//    HikariDataSource ds = new HikariDataSource();
//    ds.setJdbcUrl("jdbc:mysql://localhost:3306/playing_cards"); // TODO move this to config file
//    ds.setUsername("root");
//    ds.setPassword("praveen");
//    ds.setMaximumPoolSize(10);
//    ds.setConnectionTimeout(10);
//    ds.addDataSourceProperty("databaseName", "playing_cards");
//    ds.addDataSourceProperty("serverName", "localhost");
//    ds.addDataSourceProperty("portNumber", 3306);
//    return ds;
//  }
}

