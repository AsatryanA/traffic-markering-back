package ru.trafficmarkering.repository;

import ru.trafficmarkering.model.application.Application;

import java.util.UUID;

public interface SaverApplication {
    Application save(Application application);

    /**
     * Одним запросом, а не save() по каждому отклику — региональный сброс может задеть
     * все отклики объявления разом, и по одной вспышке (saveAndFlush) на каждый ряд смена
     * региона у объявления с сотнями откликов держала бы транзакцию непропорционально долго.
     */
    void resetRegionViewsByCampaignId(UUID campaignId);
}
