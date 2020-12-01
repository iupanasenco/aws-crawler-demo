package com.example.demo;

import com.example.demo.service.MovieCrawler;
import com.example.demo.service.domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Supplier;
import java.util.stream.Collectors;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	MovieCrawler movieCrawler;

	public static final String BASE_URL = "https://kinokrad.co/";


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	public Supplier<String> getMovieList() {
		return ()->movieCrawler.crawl(BASE_URL).stream().map(Movie::toString)
				.collect(Collectors.joining("\n"));
	}

}
