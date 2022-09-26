package ph.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ph.service.QnABoardDAO;
import ph.service.QnABoardService;
import ph.service.BoardVO;

@Service("QnAboardService")
public class QnABoardServiceImpl implements QnABoardService{
	
	@Resource(name = "QnAboardDAOMyBatis")
	private QnABoardDAO qnABoardDAO;

	@Override
	public void QnABoardInsert(BoardVO boardVO) {
		qnABoardDAO.QnABoardInsert(boardVO);
	}

	@Override
	public List<BoardVO> qnABoardList(BoardVO boardVo) throws Exception {
		return qnABoardDAO.qnABoardList(boardVo);
	}

	@Override
	public BoardVO selectQnABoard(Integer boardNo) throws Exception {
		return qnABoardDAO.selectQnABoard(boardNo);
	}

}