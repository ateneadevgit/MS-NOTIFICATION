package com.fusm.notification.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TemplateRequest {

    private String name;
    private String subject;
    private String content;
    private String description;

}
