package com.manager.subscription.services;

import com.manager.subscription.dtos.request.ShareholderRequest;
import com.manager.subscription.models.Shareholder;
import com.manager.subscription.repositorys.ShareholderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShareholderService {

    private final ShareholderRepository repository;

    public ShareholderService(ShareholderRepository repository) {
        this.repository = repository;

    }

    public Shareholder addShareholder(ShareholderRequest request) {
        Shareholder shareholder = new Shareholder();
        shareholder.setName(request.getName());
        shareholder.setTelephone(request.getTelephone());
        return repository.save(shareholder);
    }

    public Shareholder getShareholder(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public List<Shareholder> getAllShareholders() {
        return repository.findAll();
    }

    public void updateShareholder(Integer id, ShareholderRequest request) {
        Optional<Shareholder> shareholder = repository.findById(id);
        shareholder.get().setName(request.getName());
        shareholder.get().setTelephone(request.getTelephone());
        repository.save(shareholder.get());
    }

    public void deleteShareholder(Integer id) {
        repository.deleteById(id);
    }
}
