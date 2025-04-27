package com.example.basiceProjectForConversionCurrency.conversionCurrency.Services;

import com.example.basiceProjectForConversionCurrency.conversionCurrency.Models.EmployeeModel;
import com.example.basiceProjectForConversionCurrency.conversionCurrency.Repository.EmployeeRepo;
import com.example.basiceProjectForConversionCurrency.conversionCurrency.RestClient.Services.CurrencyClient;
import com.example.basiceProjectForConversionCurrency.conversionCurrency.RestClient.model.ResponseCurrencyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImp implements EmployeeService{

    private final EmployeeRepo employeeRepo;

    private final CurrencyClient currencyClient;

    @Override
    public List<EmployeeModel> getAllEmployee() {
        List<EmployeeModel> employeeModelList=employeeRepo.findAll();
       return employeeModelList;
    }

    @Override
    public EmployeeModel saveEmployee(EmployeeModel employeeModel) {
        Map<String,Double> currencyMap=new HashMap<>();
        //when saveallemployee call this saveemployee one demerits if number of record save then getcurrency() also call to man time which is not good (optimize in future)
        currencyMap=getCurrency();
        currencyMap.forEach((value,key)->{
            if(value=="USD") employeeModel.setSalary_USD(employeeModel.getSalary_INR().multiply(BigDecimal.valueOf(key)));
            if(value=="EUR") employeeModel.setSalary_EUR(employeeModel.getSalary_INR().multiply(BigDecimal.valueOf(key)));
            if(value=="GBP") employeeModel.setSalary_GBP(employeeModel.getSalary_INR().multiply(BigDecimal.valueOf(key)));
        });
        EmployeeModel employeeModel1=employeeRepo.save(employeeModel);
        return employeeModel1;
    }

    @Override
    public List<EmployeeModel> saveAllEmployee(List<EmployeeModel> employeeModelList) {
        List<EmployeeModel> saveEmployeList=new ArrayList<>();
        for(EmployeeModel employeeModel:employeeModelList){
            EmployeeModel saveEmploye=saveEmployee(employeeModel);
            saveEmployeList.add(saveEmploye);
        }
        return saveEmployeList;

    }

    /** This method is used to get all currency from freecurrencyApi client   */
    @Override
    public Map<String,Double> getCurrency() {
        return  currencyClient.getAllCurrency().getData();
    }


}
