package com.dy.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUpload {
	String fullpath;

	public String uploadImage(String path, MultipartFile file) {
		String originalFilename = file.getOriginalFilename();
		String randomImageName = UUID.randomUUID().toString();
 
		String randomImageNameWithExtention = randomImageName
				.concat(originalFilename.substring(originalFilename.lastIndexOf(".")));

		 fullpath = path+File.separator + randomImageNameWithExtention;

		File folderFile = new File(path);

		if (!folderFile.exists()) {
			folderFile.mkdirs();
		}
		
		try {
			Files.copy(file.getInputStream(), Paths.get(fullpath));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return randomImageNameWithExtention;
	}

}
