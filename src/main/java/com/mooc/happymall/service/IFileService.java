package com.mooc.happymall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by qm
 */
public interface IFileService {

    String upload(MultipartFile file, String path);
}
