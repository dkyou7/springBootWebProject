package com.dkyou.chap04.service;

import com.dkyou.chap04.dto.GuestbookDTO;
import com.dkyou.chap04.dto.PageRequestDTO;
import com.dkyou.chap04.dto.PageResultDTO;
import com.dkyou.chap04.entity.Guestbook;
import com.dkyou.chap04.repository.GuestbookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class GuestbookServiceImpl implements GuestbookService{

    private final GuestbookRepository repository;

    @Override
    public Long register(GuestbookDTO dto) {
        log.info("DTO-----------------------------------");
        log.info(dto);

        Guestbook entity = dtoToEntity(dto);

        log.info(entity);

        repository.save(entity);

        return entity.getGno();

    }

    @Override
    public PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO) {
        Pageable pageable = requestDTO.getPageable(Sort.by("gno").descending());

        Page<Guestbook> result = repository.findAll(pageable);

        Function<Guestbook,GuestbookDTO> fn = this::entityToDto;

        return new PageResultDTO<>(result,fn);
    }
}
