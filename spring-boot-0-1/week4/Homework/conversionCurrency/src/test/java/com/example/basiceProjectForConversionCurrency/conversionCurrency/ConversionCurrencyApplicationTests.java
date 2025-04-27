package com.example.basiceProjectForConversionCurrency.conversionCurrency;

import com.example.basiceProjectForConversionCurrency.conversionCurrency.RestClient.Services.CurrencyClient;
import com.example.basiceProjectForConversionCurrency.conversionCurrency.RestClient.model.ResponseCurrencyDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConversionCurrencyApplicationTests {

	@Autowired
	private CurrencyClient currencyClient;

	@Test
	void getCurrency(){
		ResponseCurrencyDto responseCurrencyDto=currencyClient.getAllCurrency();
		if(responseCurrencyDto!=null){
			responseCurrencyDto.getData().forEach((key,value)->{
				System.out.println(key+" : "+value);
			});

		}
	}
}
