package com.fusm.notification.service;

import com.fusm.notification.model.NotificationRequest;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public interface INotificationService {

    void sendNotification(NotificationRequest notificationRequest) throws MessagingException;

}
