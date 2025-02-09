package com.ChatApp.GithubAction_CI.CD.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class User {
    @Id
    private String nakename;
    private String FullName;
    private Status status;

}
