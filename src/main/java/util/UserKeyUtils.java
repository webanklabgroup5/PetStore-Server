package util;

import lombok.extern.slf4j.Slf4j;
import org.fisco.bcos.web3j.crypto.ECKeyPair;
import org.fisco.bcos.web3j.crypto.Keys;
import org.fisco.bcos.web3j.utils.Numeric;

@Slf4j
public class UserKeyUtils {

    static final int PUBLIC_KEY_SIZE = 64;
    static final int PUBLIC_KEY_LENGTH_IN_HEX = PUBLIC_KEY_SIZE << 1;

    private String publicKey;
    private String privateKey;
    private String address;

    public UserKeyUtils() {
        try {
            ECKeyPair keyPair = Keys.createEcKeyPair();
            this.publicKey = Numeric.toHexStringWithPrefixZeroPadded(keyPair.getPublicKey(), PUBLIC_KEY_LENGTH_IN_HEX);
            this.privateKey = Numeric.toHexStringNoPrefix(keyPair.getPrivateKey());
            this.address = "0x" + Keys.getAddress(publicKey);

            log.info("public key: {}", publicKey);
            log.info("private key: {}", privateKey);
            log.info("address: {}", address);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void createUserKey() {
//        try {
//            ECKeyPair keyPair = Keys.createEcKeyPair();
//            String publicKey = Numeric.toHexStringWithPrefixZeroPadded(keyPair.getPublicKey(), PUBLIC_KEY_LENGTH_IN_HEX);
//            String privateKey = Numeric.toHexStringNoPrefix(keyPair.getPrivateKey());
//            String address = "0x" + Keys.getAddress(publicKey);
//
//            log.info("public key: {}", publicKey);
//            log.info("private key: {}", privateKey);
//            log.info("address: {}", address);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}