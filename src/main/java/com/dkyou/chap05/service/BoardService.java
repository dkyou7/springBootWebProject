package com.dkyou.chap05.service;

import com.dkyou.chap05.dto.BoardDTO;
import com.dkyou.chap05.entity.Board;
import com.dkyou.chap05.entity.Member;

public interface BoardService {

    Long register(BoardDTO dto);

    default Board dtoToEntity(BoardDTO dto){
        Member member = Member.builder().email(dto.getWriterEmail()).build();
        return Board.builder()
                .bno(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(member)
                .build();
    }
}
