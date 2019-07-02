package cn.theproudsoul.fiscopetshop.solidity;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Address;
import org.fisco.bcos.web3j.abi.datatypes.Bool;
import org.fisco.bcos.web3j.abi.datatypes.DynamicArray;
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.abi.datatypes.Utf8String;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint16;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint256;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint32;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple7;
import org.fisco.bcos.web3j.tx.Contract;
import org.fisco.bcos.web3j.tx.TransactionManager;
import org.fisco.bcos.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.fisco.bcos.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version none.
 */
@SuppressWarnings("unchecked")
public class PetMarket extends Contract {
    private static final String BINARY = "6080604052600060035534801561001557600080fd5b5033600560006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506118b3806100666000396000f3006080604052600436106100af576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680631dcd9503146100b45780633548d59c146100f157806338cc48311461015e578063546dbc71146101b557806358c395a31461022157806368651f601461026457806397fd3a641461028f5780639edded11146102bc578063a36c7306146102e9578063cb92050914610355578063dee50c2c1461056c575b600080fd5b3480156100c057600080fd5b506100ef60048036038101908080359060200190929190803563ffffffff1690602001909291905050506106b5565b005b3480156100fd57600080fd5b5061015c600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506108e6565b005b34801561016a57600080fd5b50610173610a6b565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156101c157600080fd5b506101ca610a73565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b8381101561020d5780820151818401526020810190506101f2565b505050509050019250505060405180910390f35b34801561022d57600080fd5b50610262600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610b32565b005b34801561027057600080fd5b50610279610bd2565b6040518082815260200191505060405180910390f35b34801561029b57600080fd5b506102ba60048036038101908080359060200190929190505050610c38565b005b3480156102c857600080fd5b506102e760048036038101908080359060200190929190505050610def565b005b3480156102f557600080fd5b506102fe611111565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b83811015610341578082015181840152602081019050610326565b505050509050019250505060405180910390f35b34801561036157600080fd5b5061038060048036038101908080359060200190929190505050611241565b60405180881515151581526020018761ffff1661ffff1681526020018663ffffffff1663ffffffff16815260200180602001806020018060200180602001858103855289818151815260200191508051906020019080838360005b838110156103f65780820151818401526020810190506103db565b50505050905090810190601f1680156104235780820380516001836020036101000a031916815260200191505b50858103845288818151815260200191508051906020019080838360005b8381101561045c578082015181840152602081019050610441565b50505050905090810190601f1680156104895780820380516001836020036101000a031916815260200191505b50858103835287818151815260200191508051906020019080838360005b838110156104c25780820151818401526020810190506104a7565b50505050905090810190601f1680156104ef5780820380516001836020036101000a031916815260200191505b50858103825286818151815260200191508051906020019080838360005b8381101561052857808201518184015260208101905061050d565b50505050905090810190601f1680156105555780820380516001836020036101000a031916815260200191505b509b50505050505050505050505060405180910390f35b34801561057857600080fd5b506106b3600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803561ffff169060200190929190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091929192905050506115e3565b005b33828173ffffffffffffffffffffffffffffffffffffffff166001600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614151561078d576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601c8152602001807f796f752063616e206e6f742073656c6c206f746865727320706574210000000081525060200191505060405180910390fd5b60008481548110151561079c57fe5b906000526020600020906005020160000160009054906101000a900460ff16151515610856576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252602b8152602001807f70657420697320666f722073616c652120706c6561736520707574206f66662081526020017f73616c652066697273742e00000000000000000000000000000000000000000081525060400191505060405180910390fd5b8260008581548110151561086657fe5b906000526020600020906005020160000160036101000a81548163ffffffff021916908363ffffffff16021790555060016000858154811015156108a657fe5b906000526020600020906005020160000160006101000a81548160ff02191690831515021790555060036000815480929190600101919050555050505050565b600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff1614151561094257600080fd5b600260006001600085815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000815480929190600190039190505550600260008273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008154809291906001019190505550806001600084815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550505050565b600033905090565b606080600080600354604051908082528060200260200182016040528015610aaa5781602001602082028038833980820191505090505b50925060009150600090505b600080549050811015610b2957600081815481101515610ad257fe5b906000526020600020906005020160000160009054906101000a900460ff1615610b1c57808383815181101515610b0557fe5b906020019060200201818152505081806001019250505b8080600101915050610ab6565b82935050505090565b600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610b8e57600080fd5b80600460006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b6000600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610c3057600080fd5b600354905090565b33818173ffffffffffffffffffffffffffffffffffffffff166001600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16141515610d10576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601c8152602001807f796f752063616e206e6f742073656c6c206f746865727320706574210000000081525060200191505060405180910390fd5b600083815481101515610d1f57fe5b906000526020600020906005020160000160009054906101000a900460ff161515610db2576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260118152602001807f706574206e6f7420666f722073616c652100000000000000000000000000000081525060200191505060405180910390fd5b60008084815481101515610dc257fe5b906000526020600020906005020160000160006101000a81548160ff021916908315150217905550505050565b6000803391506001600084815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166334c99100600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff168484600088815481101515610e9d57fe5b906000526020600020906005020160000160039054906101000a900463ffffffff16886040518663ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018363ffffffff16815260200182815260200195505050505050600060405180830381600087803b158015610fb857600080fd5b505af1158015610fcc573d6000803e3d6000fd5b50505050816001600085815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600260008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008154809291906001019190505550600260008273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000815480929190600190039190505550600080848154811015156110d157fe5b906000526020600020906005020160000160006101000a81548160ff02191690831515021790555060036000815480929190600190039190505550505050565b606080600080600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020546040519080825280602002602001820160405280156111855781602001602082028038833980820191505090505b50925060009150600090505b600080549050811015611238573373ffffffffffffffffffffffffffffffffffffffff166001600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16141561122b5780838381518110151561121457fe5b906020019060200201818152505081806001019250505b8080600101915050611191565b82935050505090565b600080600060608060608060008881548110151561125b57fe5b906000526020600020906005020160000160009054906101000a900460ff1660008981548110151561128957fe5b906000526020600020906005020160000160019054906101000a900461ffff1660008a8154811015156112b857fe5b906000526020600020906005020160000160039054906101000a900463ffffffff1660008b8154811015156112e957fe5b906000526020600020906005020160010160008c81548110151561130957fe5b906000526020600020906005020160020160008d81548110151561132957fe5b906000526020600020906005020160030160008e81548110151561134957fe5b9060005260206000209060050201600401838054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156113ef5780601f106113c4576101008083540402835291602001916113ef565b820191906000526020600020905b8154815290600101906020018083116113d257829003601f168201915b50505050509350828054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561148b5780601f106114605761010080835404028352916020019161148b565b820191906000526020600020905b81548152906001019060200180831161146e57829003601f168201915b50505050509250818054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156115275780601f106114fc57610100808354040283529160200191611527565b820191906000526020600020905b81548152906001019060200180831161150a57829003601f168201915b50505050509150808054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156115c35780601f10611598576101008083540402835291602001916115c3565b820191906000526020600020905b8154815290600101906020018083116115a657829003601f168201915b505050505090509650965096509650965096509650919395979092949650565b60006001600060e0604051908101604052806000151581526020018861ffff168152602001600063ffffffff168152602001898152602001878152602001868152602001858152509080600181540180825580915050906001820390600052602060002090600502016000909192909190915060008201518160000160006101000a81548160ff02191690831515021790555060208201518160000160016101000a81548161ffff021916908361ffff16021790555060408201518160000160036101000a81548163ffffffff021916908363ffffffff16021790555060608201518160010190805190602001906116dc9291906117e2565b5060808201518160020190805190602001906116f99291906117e2565b5060a08201518160030190805190602001906117169291906117e2565b5060c08201518160040190805190602001906117339291906117e2565b505050039050336001600083815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008154809291906001019190505550505050505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061182357805160ff1916838001178555611851565b82800160010185558215611851579182015b82811115611850578251825591602001919060010190611835565b5b50905061185e9190611862565b5090565b61188491905b80821115611880576000816000905550600101611868565b5090565b905600a165627a7a7230582058ac59aa76121b6c7817e730464bdeeb0fc9c49d27b2f1b2b4bbfdef4d16e6830029";

    public static final String FUNC_SELLPET = "sellPet";

    public static final String FUNC_CHANGEOWNERSHIP = "changeOwnership";

    public static final String FUNC_GETADDRESS = "getAddress";

    public static final String FUNC_GETPETSFORSALE = "getPetsForSale";

    public static final String FUNC_SETTRANCONTADDR = "setTranContAddr";

    public static final String FUNC_GETSALINGPETCOUNTS = "getSalingPetCounts";

    public static final String FUNC_OFFSALE = "offSale";

    public static final String FUNC_BUYPET = "buyPet";

    public static final String FUNC_GETMYPETS = "getMyPets";

    public static final String FUNC_GETPETBYID = "getPetById";

    public static final String FUNC_NEWPET = "newPet";

    @Deprecated
    protected PetMarket(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected PetMarket(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected PetMarket(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected PetMarket(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> sellPet(BigInteger _petId, BigInteger _price) {
        final Function function = new Function(
                FUNC_SELLPET, 
                Arrays.<Type>asList(new Uint256(_petId),
                new Uint32(_price)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void sellPet(BigInteger _petId, BigInteger _price, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SELLPET, 
                Arrays.<Type>asList(new Uint256(_petId),
                new Uint32(_price)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public RemoteCall<TransactionReceipt> changeOwnership(String _sender, BigInteger _petId, String _newOwner) {
        final Function function = new Function(
                FUNC_CHANGEOWNERSHIP, 
                Arrays.<Type>asList(new Address(_sender),
                new Uint256(_petId),
                new Address(_newOwner)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void changeOwnership(String _sender, BigInteger _petId, String _newOwner, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_CHANGEOWNERSHIP, 
                Arrays.<Type>asList(new Address(_sender),
                new Uint256(_petId),
                new Address(_newOwner)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public RemoteCall<String> getAddress() {
        final Function function = new Function(FUNC_GETADDRESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<List> getPetsForSale() {
        final Function function = new Function(FUNC_GETPETSFORSALE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}));
        return new RemoteCall<List>(
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteCall<TransactionReceipt> setTranContAddr(String _transactionContract) {
        final Function function = new Function(
                FUNC_SETTRANCONTADDR, 
                Arrays.<Type>asList(new Address(_transactionContract)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setTranContAddr(String _transactionContract, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETTRANCONTADDR, 
                Arrays.<Type>asList(new Address(_transactionContract)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public RemoteCall<BigInteger> getSalingPetCounts() {
        final Function function = new Function(FUNC_GETSALINGPETCOUNTS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> offSale(BigInteger _petId) {
        final Function function = new Function(
                FUNC_OFFSALE, 
                Arrays.<Type>asList(new Uint256(_petId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void offSale(BigInteger _petId, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_OFFSALE, 
                Arrays.<Type>asList(new Uint256(_petId)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public RemoteCall<TransactionReceipt> buyPet(BigInteger _petId) {
        final Function function = new Function(
                FUNC_BUYPET, 
                Arrays.<Type>asList(new Uint256(_petId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void buyPet(BigInteger _petId, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_BUYPET, 
                Arrays.<Type>asList(new Uint256(_petId)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public RemoteCall<List> getMyPets() {
        final Function function = new Function(FUNC_GETMYPETS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}));
        return new RemoteCall<List>(
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteCall<Tuple7<Boolean, BigInteger, BigInteger, String, String, String, String>> getPetById(BigInteger _petId) {
        final Function function = new Function(FUNC_GETPETBYID, 
                Arrays.<Type>asList(new Uint256(_petId)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Uint16>() {}, new TypeReference<Uint32>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteCall<Tuple7<Boolean, BigInteger, BigInteger, String, String, String, String>>(
                new Callable<Tuple7<Boolean, BigInteger, BigInteger, String, String, String, String>>() {
                    @Override
                    public Tuple7<Boolean, BigInteger, BigInteger, String, String, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple7<Boolean, BigInteger, BigInteger, String, String, String, String>(
                                (Boolean) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (String) results.get(4).getValue(), 
                                (String) results.get(5).getValue(), 
                                (String) results.get(6).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> newPet(String _name, BigInteger _species, String _bday, String _disc, String _picUrl) {
        final Function function = new Function(
                FUNC_NEWPET, 
                Arrays.<Type>asList(new Utf8String(_name),
                new Uint16(_species),
                new Utf8String(_bday),
                new Utf8String(_disc),
                new Utf8String(_picUrl)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void newPet(String _name, BigInteger _species, String _bday, String _disc, String _picUrl, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_NEWPET, 
                Arrays.<Type>asList(new Utf8String(_name),
                new Uint16(_species),
                new Utf8String(_bday),
                new Utf8String(_disc),
                new Utf8String(_picUrl)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    @Deprecated
    public static PetMarket load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new PetMarket(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static PetMarket load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new PetMarket(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static PetMarket load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new PetMarket(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static PetMarket load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new PetMarket(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<PetMarket> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(PetMarket.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<PetMarket> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(PetMarket.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<PetMarket> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(PetMarket.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<PetMarket> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(PetMarket.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}