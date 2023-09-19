package com.example.backendsp2.controllers;

import com.example.backendsp2.model.Image;
import com.example.backendsp2.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/image")
@CrossOrigin("*")
public class ImageController {

    @Autowired
    private IImageService iImagesService;

    @GetMapping("/list/{id}")
    public ResponseEntity<List<Image>> getAllImages(@PathVariable("id") Long id) {
        List<Image> image = iImagesService.findAllImage(id);
        return new ResponseEntity<>(image, HttpStatus.OK);
    }
}
