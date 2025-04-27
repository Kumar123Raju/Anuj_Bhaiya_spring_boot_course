package com.example.ubberApp.ubberApp.Client.Imp;

import com.example.ubberApp.ubberApp.Client.CustomerClient;
import com.example.ubberApp.ubberApp.dto.CustomerDto;
import com.example.ubberApp.ubberApp.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerClientImpl implements CustomerClient {

    private final RestClient restClient;
    @Override
    public List<CustomerDto> getCustomer() {


        try{
            List<CustomerDto> customerDtoList= restClient.get()
                    .uri("api/customers")
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });
            return customerDtoList;

        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        try{
            CustomerDto customerDto= restClient.get()
                    .uri("api/customers/{id}",id)
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });
            return customerDto;

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        try {
            CustomerDto customerDto1 = restClient.post()
                    .uri("api/customers")
                    .body(customerDto)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError,(req,res)->{
                        System.out.println("Error occured"+res.getBody().readAllBytes());  //put logger for better practice
                        throw new ResourceNotFoundException("Could not create the employee");
                    })
                    .body(new ParameterizedTypeReference<CustomerDto>() {
                    });
            return customerDto1;
        }catch (Exception e){
            throw new RuntimeException(e);
        }



    }
}
