package com.example.backendsp2.service;

import com.example.backendsp2.model.Image;

import java.util.List;

public interface IImageService {
    void saveImage (List<Image> imagesList);

    List<Image> findAllImage(Long id);
}
