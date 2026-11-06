package com.batch.service;

import java.io.IOException;

public interface UploadMoviExcelService {

	String readAndUploadData(String movieFilePath) throws IOException;

}
