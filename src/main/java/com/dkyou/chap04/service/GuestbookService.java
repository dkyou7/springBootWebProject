package com.dkyou.chap04.service;

import com.dkyou.chap04.dto.GuestbookDTO;
import com.dkyou.chap04.dto.PageRequestDTO;
import com.dkyou.chap04.dto.PageResultDTO;
import com.dkyou.chap04.entity.Guestbook;

public interface GuestbookService {

    Long register(GuestbookDTO dto);

    PageResultDTO<GuestbookDTO,Guestbook> getList(PageRequestDTO requestDTO);

    // 조회
    GuestbookDTO read(Long gno);

    // 삭제
    void remove(Long gno);

    // 수정
    void modify(GuestbookDTO dto);

    default Guestbook dtoToEntity(GuestbookDTO dto){
        Guestbook entity = Guestbook.builder()
                .gno(dto.getGno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();
        return entity;
    }

    default GuestbookDTO entityToDto(Guestbook entity){
        GuestbookDTO dto = GuestbookDTO.builder()
                .gno(entity.getGno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();
        return dto;
    }
}
