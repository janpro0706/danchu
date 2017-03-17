package com.danchu.momuck.dao;

import org.springframework.stereotype.Repository;

import com.danchu.momuck.vo.Review;

@Repository
public interface ReviewDao {
	
	public void listReview();
	public Review submitReview(Review review);
	public int getRestarantSeq(int food_seq);
	public void updateReview(Review review);
	public void deleteRevew(int seq);
	
}
