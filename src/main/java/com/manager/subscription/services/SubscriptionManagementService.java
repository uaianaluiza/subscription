package com.manager.subscription.services;

import com.manager.subscription.models.Shareholder;
import com.manager.subscription.models.Subscription;
import com.manager.subscription.repositorys.ShareholderRepository;
import com.manager.subscription.repositorys.SubscriptionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SubscriptionManagementService {

    private final ShareholderService shareholderService;
    private final SubscriptionService subscriptionService;
    private final SubscriptionRepository subscriptionRepository;
    private final ShareholderRepository shareholderRepository;

    public SubscriptionManagementService(ShareholderService shareholderService, SubscriptionService subscriptionService, SubscriptionRepository subscriptionRepository, ShareholderRepository shareholderRepository) {
        this.shareholderService = shareholderService;
        this.subscriptionService = subscriptionService;
        this.subscriptionRepository = subscriptionRepository;
        this.shareholderRepository = shareholderRepository;
    }

    @Transactional
    public void addShareholderToSubscription(Integer subscriptionId, Integer shareholderId) {
        addSubscription(subscriptionId, shareholderId);
        addShareholder(subscriptionId, shareholderId);
    }


    public void addShareholder(Integer subscriptionId, Integer shareholderId) {
        Subscription subscription = subscriptionService.getSubscription(subscriptionId).orElse(null);
        assert subscription != null;

        if(subscription.getNumberOfShareholders() < subscription.getMaximumNumberOfShareholders()) {
            Shareholder shareholder = shareholderService.getShareholder(shareholderId);
            subscription.getShareholders().add(shareholder);
            subscription.setNumberOfShareholders(subscription.getNumberOfShareholders() + 1);
            subscriptionRepository.save(subscription);
        }else
            System.out.println("Essa assinatura já tem o número máximo de shareholders");
    }

    public void addSubscription(Integer subscriptionId, Integer shareholderId) {
        Shareholder shareholder = shareholderService.getShareholder(shareholderId);
        Optional<Subscription> subscription = subscriptionService.getSubscription(subscriptionId);
        if (subscription.isPresent() && subscription.get().getNumberOfShareholders() < subscription.get().getMaximumNumberOfShareholders()) {
            shareholder.getSubscriptions().add(subscription.get());
            shareholderRepository.save(shareholder);
        }
    }
}
