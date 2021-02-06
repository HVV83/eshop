package org.vkhoma.eshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vkhoma.eshop.domain.Watch;

public interface WatchRepository extends JpaRepository<Watch, Long> {
}
