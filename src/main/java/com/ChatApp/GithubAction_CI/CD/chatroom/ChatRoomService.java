package com.ChatApp.GithubAction_CI.CD.chatroom;

import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.Optional;
@RequiredArgsConstructor
@Service
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;
    public Optional<String > getChatRoomId(String senderId, String receipendId, boolean createIfNotExist) {
        return chatRoomRepository.findChatRoomBySenderIdAndReceipendId(senderId, receipendId)
                .map(ChatRoom::getId)
                .or(() -> {
                    if (createIfNotExist) {
                       return Optional.of(createChatRoom(senderId, receipendId));
                    }
                   return Optional.empty();
                });
    }

   private String createChatRoom(String senderId, String receipendId) {
       var chatid = String.format("%s_%s", senderId, receipendId);
        ChatRoom chatroomR= ChatRoom.builder()
                .chatId(chatid)
                .senderId(senderId)
                .receipendId(receipendId)
                .build();
       ChatRoom chatroomR2= ChatRoom.builder()
               .chatId(chatid)
               .senderId(receipendId)
               .receipendId(senderId)
               .build();
        chatRoomRepository.save(chatroomR);
        chatRoomRepository.save(chatroomR2);
        return chatid;
    }
}
