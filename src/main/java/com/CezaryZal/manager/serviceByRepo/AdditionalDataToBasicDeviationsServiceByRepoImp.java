package com.CezaryZal.manager.serviceByRepo;

import com.CezaryZal.entity.AdditionalDataToBasicDeviations;
import com.CezaryZal.repository.AdditionalDataToBasicDeviationsRepoDbImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AdditionalDataToBasicDeviationsServiceByRepoImp {

    private final AdditionalDataToBasicDeviationsRepoDbImpl additionalDataRepository;

    @Autowired
    public AdditionalDataToBasicDeviationsServiceByRepoImp(AdditionalDataToBasicDeviationsRepoDbImpl additionalDataRepository) {
        this.additionalDataRepository = additionalDataRepository;
    }

    @Transactional
    public AdditionalDataToBasicDeviations getRecordBySignAndValue(String inputSign, int inputValue) {
        return additionalDataRepository.getRecord(inputSign, inputValue);
    }
}
