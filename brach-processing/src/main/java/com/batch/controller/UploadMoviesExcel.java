package com.batch.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.batch.service.UploadMoviExcelService;

@RestController
@RequestMapping("/api")
public class UploadMoviesExcel {

	
	private final String movieFilePath;
	private final UploadMoviExcelService uploadMoviExcelService;
	public UploadMoviesExcel(@Value("${movie.path.csv}") String movieFilePath,UploadMoviExcelService uploadMoviExcelService) {
		this.movieFilePath=movieFilePath;
		this.uploadMoviExcelService=uploadMoviExcelService;
	}
	@PostMapping("/upload-movie-csv")
	public ResponseEntity<String> uploadMoviesDetails() throws IOException{
		System.out.println("file path ::"+movieFilePath);
		return ResponseEntity.ok(this.uploadMoviExcelService.readAndUploadData(movieFilePath));
	}
}
