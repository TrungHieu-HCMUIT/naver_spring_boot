package com.microservices.currency_calculation.controller;

import com.microservices.currency_calculation.base.BaseController;
import com.microservices.currency_calculation.controller.dto.request.CurrencyCalculationRequest;
import com.microservices.currency_calculation.service.CurrencyCalculationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class CurrencyCalculationController extends BaseController {

    private final CurrencyCalculationService currencyCalculationService;

    @GetMapping("/v1/calculate/{from}_{to}/{amount}")
    public ResponseEntity<Object> getCalculatedAmount(CurrencyCalculationRequest request) {
        return successResponse(currencyCalculationService.getCalculatedAmount(request));
    }

}
