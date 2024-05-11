package com.fusm.notification.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Builder
@Entity
@Data
@Table(name = "Notification")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Notification {

    @Id
    @Column(name = "id_notification", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer notificationId;

    @NonNull
    @Column(name = "sended_to", length = 300, nullable = false)
    private String sendedTo;

    @NonNull
    @Column(name = "sended_at", nullable = false)
    private Date sendedAt;

    @NonNull
    @Column(name = "email_subject", length = 200, nullable = false)
    private String emailSubject;

    @NonNull
    @Column(name = "email_body", length = 500, nullable = false)
    private String emailBody;

}
