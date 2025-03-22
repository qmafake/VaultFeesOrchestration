package za.co.connected.vault.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.connected.vault.model.VaultData;
import za.co.connected.vault.interfaces.DataReaderService;
import za.co.connected.vault.interfaces.FeeCalculatorService;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class VaultServicesController {

    @Autowired
    DataReaderService dataReaderService;
    @Autowired
    FeeCalculatorService feeCalculatorService;

    @RequestMapping(value = "/vault-read")
    public ResponseEntity<Object> readData() {
        return new ResponseEntity<>(dataReaderService.readData(new VaultData()), HttpStatus.OK);
    }


    @RequestMapping(value = "/vault-read-calculate-fee")
    public ResponseEntity<Object> readAndCalculateFee() {

        Collection<VaultData> vaultDataList = dataReaderService.readData(new VaultData());

        final Map<String, VaultData> vaultDataWithFeesMap = new HashMap<>();


        for (VaultData vaultData : vaultDataList){

            BigDecimal transactionFee = feeCalculatorService.calculateFee(vaultData);

            vaultData.setTranFee(transactionFee);

            vaultDataWithFeesMap.put(vaultData.getId(), vaultData);
        }

        return new ResponseEntity<>(vaultDataWithFeesMap, HttpStatus.OK);
    }

}

