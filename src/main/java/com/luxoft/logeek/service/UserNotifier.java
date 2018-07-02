package com.luxoft.logeek.service;

import com.luxoft.logeek.dto.UserNotifierDto;
import com.luxoft.logeek.entity.jira729.User;
import com.luxoft.logeek.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Component
@Transactional
@RequiredArgsConstructor
public class UserNotifier {
    private final UserRepository userRepository;

    public long countUsers(UserNotifierDto dto, Long deletedUserId) {
        Set<Long> userIds = new HashSet<>();
        if (dto.user1Id != null) userIds.add(dto.user1Id);
        if (dto.user2Id != null) userIds.add(dto.user2Id);

        return userRepository.findAllById(userIds)
                .stream()
                .filter(user -> user != null && user.getId().equals(deletedUserId))
                .filter(user -> NotificationAccessChecker.INST.allowNotification(user))
                .count();
    }









    enum NotificationAccessChecker {
        INST;
        boolean allowNotification(User user){
            return true;
        }
    }
}
