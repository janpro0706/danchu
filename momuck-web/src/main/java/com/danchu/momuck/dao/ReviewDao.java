package com.danchu.momuck.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.danchu.momuck.vo.Review;

@Repository
public interface ReviewDao {
	
	public Review submitReview(Review review);
	public int getRestarantSeq(int foodSeq);
	public int updateReview(Review review);
	public int deleteReview(int seq);
	public List<Review> selectReviewList(int foodSeq);
	public Review selectReview(int seq);
	
}
