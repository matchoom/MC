package ph.service;

import java.util.List;

public interface QnABoardService {
	
	void QnABoardInsert(BoardVO boardVO);
	
	List<BoardVO> qnABoardList(BoardVO boardVo) throws Exception;
	
	BoardVO selectQnABoard(Integer boardNo) throws Exception;
}
