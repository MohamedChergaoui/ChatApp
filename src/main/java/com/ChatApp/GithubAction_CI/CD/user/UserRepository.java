package com.ChatApp.GithubAction_CI.CD.user;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository  extends MongoRepository<User, String>{
 List<User> findByStatus(Status status);
}
