package com.example.basiceProjectForConversionCurrency.conversionCurrency.RestClient.Services;

import com.example.basiceProjectForConversionCurrency.conversionCurrency.RestClient.model.ResponseCurrencyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@RequiredArgsConstructor
@Service
public class CurrencyClientImp implements CurrencyClient{

    private final RestClient restClient;
    @Override
    public ResponseCurrencyDto getAllCurrency() {
        try {
            ResponseCurrencyDto responseCurrencyDto = restClient.get()
                    .retrieve()
                    .body(new ParameterizedTypeReference<ResponseCurrencyDto>() {
                    });
            return responseCurrencyDto;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
