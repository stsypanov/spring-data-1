package com.luxoft.logeek.service;

import com.luxoft.logeek.entity.jira729.User;
import com.luxoft.logeek.repository.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Transactional
@SuppressWarnings("ALL")
@RequiredArgsConstructor
public class UserNotifier {
    private final UserRepository userRepository;

    public void useUsers(Dto dto, Long deletedUserId) {
        Set<Long> userIds = new HashSet<>();

        if (dto.getUser1Id() != null) {
            userIds.add(dto.getUser1Id());
        }
        if (dto.getUser2Id() != null) {
            userIds.add(dto.getUser2Id());
        }

        List<User> users = userRepository.findAll(userIds);
        users.stream()
                .filter(user -> user != null && user.getId().equals(deletedUserId))
                .filter(user -> NotificationAccessChecker.INST.allowNotification(user))
                .forEach(this::notifyUser);
    }









    private void notifyUser(User user) {
    }

    @Getter
    private static class Dto {
        private Long user1Id;
        private Long user2Id;
    }

    enum NotificationAccessChecker {
        INST;
        boolean allowNotification(User user){
            return false;
        }
    }
}
