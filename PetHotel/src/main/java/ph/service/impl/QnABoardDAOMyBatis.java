package ph.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import ph.service.QnABoardDAO;
import ph.service.BoardVO;

@Repository("QnAboardDAOMyBatis")
public class QnABoardDAOMyBatis extends EgovAbstractMapper implements QnABoardDAO{

	@Override
	public void QnABoardInsert(BoardVO boardVO) {
		insert("insertQnABoard",boardVO);
	}

	@Override
	public List<BoardVO> qnABoardList(BoardVO boardVo) throws Exception {
		return selectList("qnABoardList",boardVo);
	}

	@Override
	public BoardVO selectQnABoard(Integer boardNo) throws Exception {
		return selectOne("selectQnABoard",boardNo);
	}

}
