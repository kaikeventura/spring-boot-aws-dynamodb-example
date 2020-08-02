package com.kaikeventura.dynamodb.controller;

import com.kaikeventura.dynamodb.dto.CostumerDTO;
import com.kaikeventura.dynamodb.model.Costumer;
import com.kaikeventura.dynamodb.service.CostumerService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class AppController {

    private final CostumerService costumerService;

    public AppController(CostumerService costumerService) {
        this.costumerService = costumerService;
    }

    @PostMapping("costumer")
    public ResponseEntity<Costumer> newCostumer(@Valid @RequestBody CostumerDTO costumerDTO) {
        return new ResponseEntity(costumerService.saveCostumer(costumerDTO), HttpStatus.OK);
    }

    @GetMapping("costumer")
    public ResponseEntity<List<Costumer>> findCostumerByName(@Param("companyName") String companyName) {
        return ResponseEntity.ok(costumerService.findByCompanyName(companyName));
    }

    @GetMapping("costumer/all")
    public ResponseEntity<List<Costumer>> allCostumers() {
        return ResponseEntity.ok(costumerService.findAllCostumers());
    }

    @PutMapping("costumer/{companyDocumentNumber}")
    public ResponseEntity<Costumer> updateCostumer(
            @PathVariable("companyDocumentNumber") String companyDocumentNumber,
            @Valid @RequestBody CostumerDTO costumerDTO
    ) {
        return ResponseEntity.ok(costumerService.updateCostumer(companyDocumentNumber, costumerDTO));
    }

    @DeleteMapping("costumer/{companyDocumentNumber}")
    public ResponseEntity<Costumer> disableCostumer(@PathVariable("companyDocumentNumber") String companyDocumentNumber) {
        return ResponseEntity.ok(costumerService.disableCostumer(companyDocumentNumber));
    }

}
