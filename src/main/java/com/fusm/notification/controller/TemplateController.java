package com.fusm.notification.controller;

import com.fusm.notification.entity.Template;
import com.fusm.notification.entity.TemplateRequest;
import com.fusm.notification.service.ITemplateService;
import com.fusm.notification.util.AppRoutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Clase que expone los servicios relacionados con las plantillas de las notificaciones
 * ITSense Inc - Andrea Gómez
 */

@RestController
@RequestMapping(value = AppRoutes.TEMPLATE_ROUTE)
public class TemplateController {

    @Autowired
    private ITemplateService templateService;


    /**
     * Obntiene la plantilla de la notificaicón
     * @param templateId ID de la plantilla
     * @return plantilla
     */
    @GetMapping("/{id}")
    public ResponseEntity<Template> getTemplate(
            @PathVariable("id") Integer templateId
    ) {
        return ResponseEntity.ok(templateService.getTemplate(templateId));
    }

    /**
     * Obtiene una lista de todas las plantillas
     * @return lista de plantillas
     */
    @GetMapping
    public ResponseEntity<List<Template>> getAllTemplates() {
        return ResponseEntity.ok(templateService.getTemplates());
    }

    /**
     * Actualiza la plantilla
     * @param templateId ID de la plantilla
     * @param templateRequest Modelo que contiene la información de la plantilla que se desea actualizar
     * @return OK
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> updateTemplate(
            @PathVariable("id") Integer templateId,
            @RequestBody TemplateRequest templateRequest
            ) {
        templateService.updateTemplate(templateRequest, templateId);
        return ResponseEntity.ok(HttpStatus.OK.getReasonPhrase());
    }

}
