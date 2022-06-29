package com.co.pragma.serviceclientimageclean.infraestructure.driveradapters.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MongoDataRepository extends MongoRepository<ImageEntity, String>{

}
