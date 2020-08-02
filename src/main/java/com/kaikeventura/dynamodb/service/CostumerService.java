package com.kaikeventura.dynamodb.service;

import com.kaikeventura.dynamodb.dto.CostumerDTO;
import com.kaikeventura.dynamodb.model.Costumer;

import java.util.List;

public interface CostumerService {
    Costumer saveCostumer(CostumerDTO costumerDTO);
    List<Costumer> findAllCostumers();
    List<Costumer> findByCompanyName(String companyName);
    Costumer updateCostumer(String companyDocumentNumber, CostumerDTO costumerDTO);
    Costumer disableCostumer(String companyDocumentNumber);
}
