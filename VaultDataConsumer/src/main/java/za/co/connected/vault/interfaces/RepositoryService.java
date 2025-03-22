package za.co.connected.vault.interfaces;

import za.co.connected.vault.model.VaultData;

import java.math.BigDecimal;

public interface RepositoryService {

    public abstract void createRecord(VaultData vaultData);

    public abstract void getRecord(int id);


}
