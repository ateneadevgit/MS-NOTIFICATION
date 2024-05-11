package com.fusm.notification.service.impl;

import com.fusm.notification.entity.Notification;
import com.fusm.notification.exception.GlobalExceptionHandler;
import com.fusm.notification.model.NotificationRequest;
import com.fusm.notification.repository.INotificationRepository;
import com.fusm.notification.service.INotificationService;
import com.fusm.notification.service.ITemplateService;
import com.fusm.notification.util.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

@Service
public class NotificationService implements INotificationService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private INotificationRepository notificationRepository;

    @Autowired
    private ITemplateService templateService;

    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Override
    public void sendNotification(NotificationRequest notificationRequest) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            Calendar cal = Calendar.getInstance();
            int hour = cal.get(Calendar.HOUR_OF_DAY);

            String greetingTempalte = getGreeting(Constant.NIGHT);
            if (hour >= 6 && hour < 12) greetingTempalte = getGreeting(Constant.MORNING);
            if (hour >= 12 && hour < 18) greetingTempalte = getGreeting(Constant.NOON);

            helper.setTo(notificationRequest.getSendTo());
            helper.setSubject(notificationRequest.getSubject());
            String signature = getSignature();
            helper.setText(greetingTempalte + "\n\n" + notificationRequest.getBody()+ "\n\n" + signature, true);
            mailSender.send(message);
            saveNotification(notificationRequest);
        } catch (Exception ex) {
            logger.error("Email with addressee {" + Arrays.toString(notificationRequest.getSendTo()) + "} and " +
                    "content {" + notificationRequest.getBody() + "} could not be sent");
        }
    }

    private String getSignature(){
        return templateService.getTemplate(Constant.EMAIL_SIGNATURE).getEmailBody();
    }

    private String getGreeting(Integer greetingId) {
        return templateService.getTemplate(greetingId).getEmailBody();
    }

    private void saveNotification(NotificationRequest notificationRequest) {
        notificationRepository.save(
                Notification.builder()
                        .sendedTo(String.join(",", notificationRequest.getSendTo()))
                        .sendedAt(new Date())
                        .emailSubject(notificationRequest.getSubject())
                        .emailBody(notificationRequest.getBody())
                        .build()
        );
    }

}
