package com.danchu.momuck.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.danchu.momuck.dao.ReviewDao;
import com.danchu.momuck.vo.Review;

@Repository
public class ReviewMapper implements ReviewDao {

	private static final Logger LOG = LoggerFactory.getLogger(ReviewMapper.class);
	private static final String NAMESPACE = "Review";

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public Review submitReview(Review review) {
		sqlSessionTemplate.insert(NAMESPACE + ".insertReview", review);
		return review;
	}

	public int updateReview(Review review) {
		return sqlSessionTemplate.update(NAMESPACE + ".updateReview", review);
	}

	public int deleteReview(int seq) {
		return sqlSessionTemplate.insert(NAMESPACE + ".deleteReview", seq);
	}

	public int getRestarantSeq(int foodSeq) {
		int rest_seq = sqlSessionTemplate.selectOne(NAMESPACE + ".selectRestSeq", foodSeq);
		return rest_seq;
	}

	public List<Review> selectReviewList(int foodSeq) {
		return sqlSessionTemplate.selectList(NAMESPACE + ".selectReview", foodSeq);
	}
}
