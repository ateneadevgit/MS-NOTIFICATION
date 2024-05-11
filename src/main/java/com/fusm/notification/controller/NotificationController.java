package com.fusm.notification.controller;

import com.fusm.notification.model.NotificationRequest;
import com.fusm.notification.service.INotificationService;
import com.fusm.notification.util.AppRoutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

/**
 * Clase que expone los servicios relacionadas con las notificaciones del sistema
 * ITSense Inc - Andrea Gómez
 */

@RestController
@RequestMapping(value = AppRoutes.NOTIFICATION_ROUTE)
public class NotificationController {

    @Autowired
    private INotificationService notificationService;


    /**
     * Envia notificaciones via correo electrónico
     * @param notificationRequest Modelo que contiene la información para enviar el correo
     * @return OK
     * @throws MessagingException
     */
    @PostMapping
    public ResponseEntity<String> sendNotification(
            @RequestBody NotificationRequest notificationRequest
            ) throws MessagingException {
        notificationService.sendNotification(notificationRequest);
        return ResponseEntity.ok(HttpStatus.OK.getReasonPhrase());
    }

}
