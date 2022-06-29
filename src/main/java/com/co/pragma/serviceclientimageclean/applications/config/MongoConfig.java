package com.co.pragma.serviceclientimageclean.applications.config;

import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.event.CommandFailedEvent;
import com.mongodb.event.CommandListener;
import com.mongodb.event.CommandStartedEvent;
import com.mongodb.event.CommandSucceededEvent;

@Configuration
public class MongoConfig {
	
	@Value("${spring.data.mongodb.uri}")
	  private String mongoConnection;

	  @Value("${mongo.pool.max-size}")
	  private String mongoPoolMaxSize;

	  @Value("${mongo.pool.min-size}")
	  private String mongoPoolMinSize;

	  @Value("${mongo.show-log}")
	  private boolean mongoShowLog;

	  @Bean("mongoClient")
	  public MongoClient mongoClient() {
	    return MongoClients.create(
	        MongoClientSettings.builder()
	            /*
	            .applyToSocketSettings(
	                socketSettings -> {
	                  socketSettings.readTimeout(5, TimeUnit.MINUTES);
	                })
	            */
	            .addCommandListener(new MongoCommandListener())
	            .codecRegistry(getCodecRegistry())
	            .applyConnectionString(new ConnectionString(mongoConnection))
	            .applyToConnectionPoolSettings(
	                connectionPoolSettings ->
	                    connectionPoolSettings
	                        .maxSize(Integer.valueOf(mongoPoolMaxSize))
	                        .minSize(Integer.valueOf(mongoPoolMinSize)))
	            .build());
	  }

	  private CodecRegistry getCodecRegistry() {
	    return CodecRegistries.fromRegistries(
	        MongoClientSettings.getDefaultCodecRegistry(),
	        CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));
	  }

	  public class MongoCommandListener implements CommandListener {

	    @Override
	    public void commandStarted(final CommandStartedEvent event) {
	      if (mongoShowLog) {
//	        log.info(
//	            "Executing mongo command, Request = "
//	                + event.getRequestId()
//	                + " -> "
//	                + event.getCommand().toJson());
	      } else {
//	        log.info("Executing mongo command " + event.getCommandName());
	      }
	    }

	    @Override
	    public void commandSucceeded(final CommandSucceededEvent event) {
	      // Do nothing
	    }

	    @Override
	    public void commandFailed(final CommandFailedEvent event) {
//	      log.error(
//	          "Mongo command failed, Request = " + event.getRequestId() + " ->", event.getThrowable());
	    }
	  }
	
	

}
