package com.batch.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "movie_dtls")
public class MovieDtls {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer modieId;
	@Column(name = "movie_title",nullable = false,length = 100)
	private String movieTitle;
	
	@Lob
	private String overview;
	@Column(name = "lelease_date")
	private LocalDate releaseDate;
	
	private Double popularity;
	@Column(name = "vote_average")
	private Double voteAverage;
	@Column(name = "vote_count")
	private Long voteCount;
	public Integer getModieId() {
		return modieId;
	}
	public void setModieId(Integer modieId) {
		this.modieId = modieId;
	}
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
	public MovieDtls(String movieTitle, String overview, LocalDate releaseDate, Double popularity, Double voteAverage,
			Long voteCount) {
		super();
		this.movieTitle = movieTitle;
		this.overview = overview;
		this.releaseDate = releaseDate;
		this.popularity = popularity;
		this.voteAverage = voteAverage;
		this.voteCount = voteCount;
	}
	
	
	
}
