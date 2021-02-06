package org.vkhoma.eshop.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vkhoma.eshop.domain.Watch;
import org.vkhoma.eshop.repository.WatchRepository;
import org.vkhoma.eshop.service.WatchService;

import java.util.List;

@Service
@Slf4j
public class WatchServiceImpl implements WatchService {
    private final WatchRepository watchRepository;

    @Autowired
    public WatchServiceImpl(WatchRepository watchRepository) {
        this.watchRepository = watchRepository;
    }

    @Override
    public List<Watch> list() {
        List<Watch> foundWatches = watchRepository.findAll();
        log.info("IN list - {} watches found", foundWatches.size());
        return foundWatches;
    }

    @Override
    public Watch getOne(Long id) {
        Watch foundWatch = watchRepository.findById(id).orElse(null);
        log.info("IN getOne - watch: {} found by id: {}", foundWatch, id);
        return foundWatch;
    }

    @Override
    public Watch create(Watch watch) {
        Watch createdWatch = watchRepository.save(watch);
        log.info("IN create - watch: {} successfully created", createdWatch);
        return createdWatch;
    }

    @Override
    public Watch update(Watch watch) {
        Watch updatedWatch = watchRepository.save(watch);
        log.info("IN update - watch: {} successfully updated", updatedWatch);
        return updatedWatch;
    }

    @Override
    public void delete(Watch watch) {
        watchRepository.delete(watch);
        log.info("IN delete - watch: {} successfully deleted", watch);
    }

}
