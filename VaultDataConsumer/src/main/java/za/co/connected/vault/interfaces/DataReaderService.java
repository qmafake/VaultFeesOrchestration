package za.co.connected.vault.interfaces;

import za.co.connected.vault.model.VaultData;

import java.util.Collection;

public interface DataReaderService {

    public abstract Collection<VaultData> readData(VaultData vaultData);


}
