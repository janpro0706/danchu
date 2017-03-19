package com.danchu.momuck.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.danchu.momuck.vo.Review;

@Service
public interface ReviewService {

	public Review submitReview(Review review);

	public int updateReview(Review review);

	public int deleteReview(int seq);

	public List<Review> selectReviewList(int foodSeq);
	
	public Review selectReview(int seq);

}
