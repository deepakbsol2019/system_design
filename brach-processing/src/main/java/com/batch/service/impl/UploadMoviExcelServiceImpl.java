package com.batch.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.batch.dto.MovieDtlsDto;
import com.batch.entity.MovieDtls;
import com.batch.repo.UploadMoviesRepo;
import com.batch.service.UploadMoviExcelService;
import com.batch.util.CsvFileInputStream;
import com.opencsv.bean.CsvToBeanBuilder;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
@Service
public class UploadMoviExcelServiceImpl implements UploadMoviExcelService {

	private UploadMoviesRepo uploadMoviesRepo;
	public UploadMoviExcelServiceImpl(UploadMoviesRepo uploadMoviesRepo) {
		this.uploadMoviesRepo=uploadMoviesRepo;
	}
	@Override
	@Transactional(value = TxType.REQUIRED,rollbackOn = Exception.class)
	public String readAndUploadData(String movieFilePath) throws IOException {
		//read csv and get long list
		List<MovieDtls> csvData=readCsvFile(movieFilePath);
		
		//create chunks form bulk data
		int chunckSize=50;
		List<List<MovieDtls>> movieChunks=breatBigListIntoChunks(csvData,chunckSize);
		
		//assign one chunk to one thread
		List<CompletableFuture<Void>> allEvent=execteEachChunks(movieChunks);
		//main thread wait until all chunks saved successfully.
		CompletableFuture.allOf(allEvent.toArray(new CompletableFuture<?>[0])).join();
		
		return "saved data";
	}
	
	private List<CompletableFuture<Void>> execteEachChunks(List<List<MovieDtls>> movieChunks) {
		return movieChunks.stream().map(chunk->CompletableFuture.runAsync(()->processChunkData(chunk)))
		.collect(Collectors.toList());
	}
	public void processChunkData(List<MovieDtls> movieDtls) {
		uploadMoviesRepo.saveAll(movieDtls);
	}
	private List<List<MovieDtls>> breatBigListIntoChunks(List<MovieDtls> csvData,int chunckSize) {
		int totalSize=csvData.size();
		int totalChunks=(totalSize+chunckSize-1)/chunckSize;
		List<List<MovieDtls>> chunckMovies=new ArrayList<>();
		for(int i=0;i<totalChunks;i++) {
			int start=i*chunckSize;
			int last=Math.min(totalSize, (i+1)*chunckSize);
			chunckMovies.add(csvData.subList(start, last));
		}
		return chunckMovies;
	}
	public List<MovieDtls> readCsvFile(String filePath) throws IOException{
		List<MovieDtls> movies;
		try (Reader reader = new BufferedReader(
                new InputStreamReader(CsvFileInputStream.createInputStreamFromCsv(filePath), StandardCharsets.UTF_8))) {

            List<MovieDtlsDto> rows =
                    new CsvToBeanBuilder<MovieDtlsDto>(reader)
                            .withType(MovieDtlsDto.class)
                            .withIgnoreLeadingWhiteSpace(true)
                            .withThrowExceptions(true)
                            .build()
                            .parse();

            movies = rows.stream()
                    .map(row -> new MovieDtls(
                            row.getMovieTitle().trim(),
                            row.getOverview().trim(),
                            row.getReleaseDate(),
                            row.getPopularity(),
                            row.getVoteAverage(),
                            row.getVoteCount()
                    ))
                    .toList();
		}
		return movies;

	}

	
}