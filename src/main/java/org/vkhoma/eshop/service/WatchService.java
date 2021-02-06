package org.vkhoma.eshop.service;

import org.vkhoma.eshop.domain.Watch;

import java.util.List;

public interface WatchService {

    List<Watch> list();

    Watch getOne(Long id);

    Watch create(Watch watch);

    Watch update(Watch watch);

    void delete(Watch watch);

}
