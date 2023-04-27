package com.newlight.app.dao;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.newlight.app.dto.CommunityCommentDTO;
import com.newlight.app.dto.CommunityCommentVO;

public class CommunityCommentDAO {
	public SqlSession sqlSession;
	
	public CommunityCommentDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	public List<CommunityCommentVO> selectAll(int communityNumber){
		return sqlSession.selectList("communityComment.selectAll", communityNumber);
	}
	
	public void insert(CommunityCommentDTO communityCommentDTO) {
		sqlSession.insert("communityComment.insert", communityCommentDTO);
	}
	
	
	 public void delete(int communityNumber) {
	 sqlSession.delete("communityComment.delete", communityNumber); }
	 
	
	public void deleteComment(int commentNumber) {
		sqlSession.delete("communityComment.deleteComment", commentNumber);
	}
	
	public void update(CommunityCommentDTO communityCommentDTO) {
		sqlSession.update("communityComment.update", communityCommentDTO);	
	}
	
//	회원탈퇴 시 커뮤니티 댓글 삭제
	public void deleteMember(int memberNumber) {
		sqlSession.delete("communityComment.deleteMember", memberNumber);
	}
	
	public void commenteAllDelete(int memberNumber) {
		sqlSession.delete("communityComment.commentAllDelete", memberNumber);
	}
	
}
