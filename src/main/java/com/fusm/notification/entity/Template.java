package com.fusm.notification.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Builder
@Entity
@Data
@Table(name = "Template")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Template {

    @Id
    @Column(name = "id_template", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer templateId;

    @NonNull
    @Column(name = "template_name", length = 300, nullable = false)
    private String templateName;

    @Column(name = "description", length = 500, nullable = true)
    private String description;

    @Column(name = "subject", nullable = true)
    private String subject;

    @NonNull
    @Column(name = "email_body", length = 1000, nullable = false)
    private String emailBody;

}

