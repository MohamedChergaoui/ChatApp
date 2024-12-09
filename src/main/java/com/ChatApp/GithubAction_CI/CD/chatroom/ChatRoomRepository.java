package com.ChatApp.GithubAction_CI.CD.chatroom;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ChatRoomRepository extends MongoRepository<ChatRoom, String> {

    Optional<ChatRoom> findChatRoomBySenderIdAndReceipendId(String senderId, String receipendId);
}
