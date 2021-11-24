package com.dkyou.chap2.repository;

import com.dkyou.chap2.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo,Long> {
}
