package com.dkyou.chap04.repository;

import com.dkyou.chap04.entity.Guestbook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestbookRepository extends JpaRepository<Guestbook,Long> {
}
