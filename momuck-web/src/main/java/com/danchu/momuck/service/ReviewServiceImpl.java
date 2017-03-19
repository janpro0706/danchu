package com.danchu.momuck.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danchu.momuck.dao.ReviewDao;
import com.danchu.momuck.vo.Review;

@Service
public class ReviewServiceImpl implements ReviewService {

	private static final Logger LOG = LoggerFactory.getLogger(ReviewServiceImpl.class);

	@Autowired
	private ReviewDao reviewDao;

	public Review submitReview(Review review) {
		// get food_restaurant_seq
		int restSeq = reviewDao.getRestarantSeq(review.getFoodSeq());
		review.setFoodRestaurantSeq(restSeq);
		return reviewDao.submitReview(review);
	}

	public int updateReview(Review review) {
		try {
			return reviewDao.updateReview(review);
		} catch (Exception e) {
			return -1;
		}
	}

	public int deleteReview(int seq) {
		try {
			return reviewDao.deleteReview(seq);
		} catch (Exception e) {
			return -1;
		}
	}

	public List<Review> selectReviewList(int foodSeq) {
		return reviewDao.selectReviewList(foodSeq);
	}

}
