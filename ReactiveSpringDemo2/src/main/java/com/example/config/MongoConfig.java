package com.example.config;

import com.mongodb.reactivestreams.client.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Value("${dbname}")
    private String dbname;
    @Value("${port}")
    private String port;

    @Override
    public MongoClient reactiveMongoClient() {
        return mongoClients.create();
    }

    @Override
    public ReactiveMongoTemplate reactiveMongoTemplate() {
        return new ReactiveMongoTemplate(reactiveMongoClient(),getDatabaseName());
    }

    @Override
    protected String getDatabaseName() {
        return dbname;
    }
}