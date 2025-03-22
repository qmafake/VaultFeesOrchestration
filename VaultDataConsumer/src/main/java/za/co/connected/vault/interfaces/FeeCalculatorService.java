package za.co.connected.vault.interfaces;

import za.co.connected.vault.model.VaultData;

import java.math.BigDecimal;

public interface FeeCalculatorService {

    public abstract BigDecimal calculateFee(VaultData vaultData);


}
