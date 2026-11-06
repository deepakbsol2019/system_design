package com.batch.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.batch.entity.MovieDtls;

public interface UploadMoviesRepo extends JpaRepository<MovieDtls, Integer> {

}
