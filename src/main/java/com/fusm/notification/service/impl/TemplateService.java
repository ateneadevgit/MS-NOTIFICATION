package com.fusm.notification.service.impl;

import com.fusm.notification.entity.Template;
import com.fusm.notification.entity.TemplateRequest;
import com.fusm.notification.repository.ITemplateRepository;
import com.fusm.notification.service.ITemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class TemplateService implements ITemplateService {

    @Autowired
    private ITemplateRepository templateRepository;

    @Override
    public Template getTemplate(Integer templateId) {
        Optional<Template> templateOptional = templateRepository.findById(templateId);
        Template response = null;
        if (templateOptional.isPresent()) response = templateOptional.get();
        return response;
    }

    @Override
    public List<Template> getTemplates() {
        return templateRepository.findTemplatesOrdered();
    }

    @Override
    public void updateTemplate(TemplateRequest templateRequest, Integer templateId) {
        Optional<Template> templateOptional = templateRepository.findById(templateId);
        if (templateOptional.isPresent()) {
            Template template = templateOptional.get();
            template.setTemplateName(templateRequest.getName());
            template.setSubject(templateRequest.getSubject());
            template.setDescription(templateRequest.getDescription());
            template.setEmailBody(templateRequest.getContent());
            templateRepository.save(template);
        }
    }

}
