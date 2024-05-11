package com.fusm.notification.repository;

import com.fusm.notification.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface INotificationRepository extends JpaRepository<Notification, Integer> {
}
