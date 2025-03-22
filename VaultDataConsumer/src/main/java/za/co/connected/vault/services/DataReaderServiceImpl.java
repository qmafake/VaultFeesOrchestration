package za.co.connected.vault.services;

import org.springframework.stereotype.Service;
import za.co.connected.vault.interfaces.DataReaderService;
import za.co.connected.vault.model.VaultData;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class DataReaderServiceImpl implements DataReaderService {

    private static final Map<String, VaultData> vaultDataHashMap;

    static {
        vaultDataHashMap = new HashMap<>();

        VaultData vaultLanga = new VaultData();
        vaultLanga.setId("1");
        vaultLanga.setName("G4S_SAFE_MODEL_XRZ");
        vaultLanga.setDescription("LANGA G4S Series 5 Safe");
        vaultLanga.setBalance(new BigDecimal("5000.00"));
        vaultDataHashMap.put(vaultLanga.getId(), vaultLanga);

        VaultData vaultDelft = new VaultData();
        vaultDelft.setId("2");
        vaultDelft.setName("GS4_SAFE_MODEL_ABC");
        vaultDelft.setDescription("DELFT G4S Series 5 Safe");
        vaultDelft.setBalance(new BigDecimal("3500.50"));
        vaultDataHashMap.put(vaultDelft.getId(), vaultDelft);
    }


    @Override
    public Collection<VaultData> readData(VaultData vaultData) {

        return vaultDataHashMap.values();

    }
}
