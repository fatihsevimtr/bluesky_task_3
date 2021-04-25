package com.bluesky.dbconfig


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.core.env.Environment
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.DriverManagerDataSource
import javax.sql.DataSource

@Configuration
//@EnableAutoConfiguration(exclude={BatchAutoConfiguration.class})
class DbConfig {
    @Autowired
    private val env:Environment = TODO()

    @Bean
    @Primary
    fun firstDataSource():DataSource {
        val dataSource = DriverManagerDataSource()
        env.getProperty("spring.datasource1.driver-class-name")?.let { dataSource.setDriverClassName(it) }
        dataSource.setUrl(env.getProperty("spring.datasource1.url"))
        dataSource.setUsername(env.getProperty("spring.datasource1.username"))
        dataSource.setPassword(env.getProperty("spring.datasource1.password"))
        return dataSource
    }
    @Bean
    fun secondDataSource():DataSource {
        val dataSource = DriverManagerDataSource()
        env.getProperty("spring.datasource2.driver-class-name")?.let { dataSource.setDriverClassName(it) }
        dataSource.setUrl(env.getProperty("spring.datasource2.url"))
        dataSource.setUsername(env.getProperty("spring.datasource2.username"))
        dataSource.setPassword(env.getProperty("spring.datasource2.password"))
        return dataSource
    }
    @Bean
    fun jdbcTemplateOne(@Qualifier("firstDataSource") ds:DataSource):JdbcTemplate {
        return JdbcTemplate(ds)
    }
    @Bean
    fun jdbcTemplateTwo(@Qualifier("secondDataSource") ds:DataSource):JdbcTemplate {
        return JdbcTemplate(ds)
    }
}