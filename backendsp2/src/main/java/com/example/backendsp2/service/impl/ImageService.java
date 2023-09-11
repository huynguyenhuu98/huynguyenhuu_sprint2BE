package com.example.backendsp2.service.impl;

import com.example.backendsp2.model.Image;
import com.example.backendsp2.repository.IImageRepository;
import com.example.backendsp2.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService implements IImageService {
    @Autowired
    private IImageRepository iImageRepository;

    @Override
    public void saveImage(List<Image> imagesList) {
        iImageRepository.saveAll(imagesList);
    }

    @Override
    public List<Image> findAllImage(Long id) {
        return iImageRepository.getAllByProductId(id);
    }
}
