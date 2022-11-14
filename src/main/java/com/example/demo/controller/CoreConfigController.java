package com.example.demo.controller;

import com.example.demo.service.CoreConfigEditorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.EventRecodingLogger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/coreconfig")
public class CoreConfigController {

Logger logger = LoggerFactory.getLogger(CoreConfigController.class);
    CoreConfigEditorService coreConfigEditorService;

    CoreConfigController(CoreConfigEditorService c){
        this.coreConfigEditorService = c;
    }

    @GetMapping("/copy")
    public void CopyCoreConfig(){
//        logger.info("Got Here");
        System.out.println("COPY COMPLETE");
        try {
            this.coreConfigEditorService.testEdit();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/replace")
    public void ReplaceCoreConfig(){
        try {
            this.coreConfigEditorService.testReplaceLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

