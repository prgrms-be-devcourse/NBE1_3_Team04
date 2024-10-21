package com.grepp.nbe1_3_team04.global.repository;

import java.util.Optional;

public interface CustomGlobalRepository<T> {
    Optional<T> findActiveById(Long id);
}
