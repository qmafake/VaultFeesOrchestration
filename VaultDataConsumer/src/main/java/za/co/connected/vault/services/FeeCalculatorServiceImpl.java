package za.co.connected.vault.services;

import org.springframework.stereotype.Service;
import za.co.connected.vault.interfaces.FeeCalculatorService;
import za.co.connected.vault.model.VaultData;

import java.math.BigDecimal;

@Service
public class FeeCalculatorServiceImpl implements FeeCalculatorService {

    @Override
    public BigDecimal calculateFee(VaultData vaultData) {

        double fixedPercent = 0.02D; //"2% fee" //TODO: move application settings file

        return vaultData.getBalance().multiply(BigDecimal.valueOf(fixedPercent));
    }
}
