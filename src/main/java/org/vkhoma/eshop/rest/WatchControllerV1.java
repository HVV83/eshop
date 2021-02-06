package org.vkhoma.eshop.rest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.vkhoma.eshop.domain.Watch;
import org.vkhoma.eshop.service.impl.WatchServiceImpl;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/watch")
public class WatchControllerV1 {
    private final WatchServiceImpl watchService;

    @Autowired
    public WatchControllerV1(WatchServiceImpl watchService) {
        this.watchService = watchService;
    }

    @GetMapping
    public List<Watch> list(HttpServletResponse response) {
        List<Watch> watchesFromDb = watchService.list();

        if (watchesFromDb.size() == 0) {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        }
        return watchService.list();
    }

    @GetMapping(value = "{id}")
    public Watch getOne(@PathVariable Long id, HttpServletResponse response) {
        Watch watchFromDb = watchService.getOne(id);

        if (watchFromDb == null) {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        }
        return watchFromDb;
    }

    @PostMapping(produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(value = HttpStatus.CREATED)
    public Watch create(@Valid @RequestBody Watch watch) {
        return watchService.create(watch);
    }

    @PutMapping(value = "{id}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public Watch update(@Valid @RequestBody Watch watch,
                        @PathVariable("id") Watch watchFromDb) {
        BeanUtils.copyProperties(watch, watchFromDb, "id");
        return watchService.update(watchFromDb);
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void delete(@PathVariable("id") Watch watchFromDb) {
        watchService.delete(watchFromDb);
    }

}
