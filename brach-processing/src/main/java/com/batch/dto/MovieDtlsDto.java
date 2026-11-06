package com.batch.dto;

import java.time.LocalDate;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

public class MovieDtlsDto {

	@CsvBindByName(column = "original_title",required = true)
	private String movieTitle;
	@CsvBindByName(column = "overview")
	private String overview;
	@CsvDate("yyyy-MM-dd")
	@CsvBindByName(column = "release_date")
	private LocalDate releaseDate;
	@CsvBindByName(column = "popularity")
	private Double popularity;
	@CsvBindByName(column = "vote_average")
	private Double voteAverage;
	@CsvBindByName(column = "vote_count")
	private Long voteCount;
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Double getPopularity() {
		return popularity;
	}
	public void setPopularity(Double popularity) {
		this.popularity = popularity;
	}
	public Double getVoteAverage() {
		return voteAverage;
	}
	public void setVoteAverage(Double voteAverage) {
		this.voteAverage = voteAverage;
	}
	public Long getVoteCount() {
		return voteCount;
	}
	public void setVoteCount(Long voteCount) {
		this.voteCount = voteCount;
	}
	public MovieDtlsDto(String movieTitle, String overview, LocalDate releaseDate, Double popularity,
			Double voteAverage, Long voteCount) {
		super();
		this.movieTitle = movieTitle;
		this.overview = overview;
		this.releaseDate = releaseDate;
		this.popularity = popularity;
		this.voteAverage = voteAverage;
		this.voteCount = voteCount;
	}
	public MovieDtlsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
