package com.manager.subscription.controllers;

import com.manager.subscription.dtos.request.ShareholderRequest;
import com.manager.subscription.models.Shareholder;
import com.manager.subscription.services.ShareholderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/shareholder")
public class ShareholderController {

    private final  ShareholderService shareholderService;

    public ShareholderController(ShareholderService shareholderService) {
        this.shareholderService = shareholderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Shareholder addShareholder(@RequestBody ShareholderRequest request) {
        return shareholderService.addShareholder(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Shareholder getShareholder(@PathVariable Integer id) {
        return shareholderService.getShareholder(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Shareholder> getAllShareholders() {
        return shareholderService.getAllShareholders();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateShareholder(@PathVariable Integer id, @RequestBody ShareholderRequest request) {
        shareholderService.updateShareholder(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteShareholder(@PathVariable Integer id) {
        shareholderService.deleteShareholder(id);
    }
}
