package examples.boot.simpleboard.service.impl;

import examples.boot.simpleboard.domain.Board;
import examples.boot.simpleboard.domain.User;
import examples.boot.simpleboard.repository.BoardRepository;
import examples.boot.simpleboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    BoardRepository boardRepository;

    @Override
    @Transactional
    public Board getBoard(Long id) {
        Board board = boardRepository.getOne(id);
        board.setReadCount(board.getReadCount() + 1);
        return board;
    }

    @Override
    public Long getBoardCount() {
        return boardRepository.countAll();
    }

    @Override
    public Long getBoardCountByUserName(String userName) {
        return boardRepository.countAllByUserName(userName);
    }
}