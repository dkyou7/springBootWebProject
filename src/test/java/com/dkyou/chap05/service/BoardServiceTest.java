package com.dkyou.chap05.service;

import com.dkyou.chap05.dto.BoardDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Test
    public void testRegister(){

        BoardDTO dto = BoardDTO.builder()
                .title("Test..")
                .content("Content..")
                .writerEmail("user55@aaa.com")
                .build();

        Long bno = boardService.register(dto);
    }
}