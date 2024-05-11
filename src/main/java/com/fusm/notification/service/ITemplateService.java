package com.fusm.notification.service;

import com.fusm.notification.entity.Template;
import com.fusm.notification.entity.TemplateRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITemplateService {

    Template getTemplate(Integer templateId);
    List<Template> getTemplates();
    void updateTemplate(TemplateRequest templateRequest, Integer templateId);

}
