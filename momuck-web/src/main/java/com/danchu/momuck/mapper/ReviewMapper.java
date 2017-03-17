package com.danchu.momuck.mapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.danchu.momuck.vo.Review;
import com.danchu.momuck.dao.ReviewDao;

@Repository
public class ReviewMapper implements ReviewDao{

	private static final String NAMESPACE = "Review";
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void listReview() {
		// TODO Auto-generated method stub
		
	}

	public Review submitReview(Review review) {
		sqlSessionTemplate.insert(NAMESPACE + ".insertReview", review);
		return review;
	}

	public void updateReview(Review review) {
		sqlSessionTemplate.update(NAMESPACE + ".updateReview", review);
	}

	public void deleteReview(int seq) {
		sqlSessionTemplate.insert(NAMESPACE + ".deleteReview", seq);
	}

	public int getRestarantSeq(int food_seq) {
		int rest_seq = sqlSessionTemplate.selectOne(NAMESPACE + ".selectRestSeq", food_seq);
		return rest_seq;
	}
}
