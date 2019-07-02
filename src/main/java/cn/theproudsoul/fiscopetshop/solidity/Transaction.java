package cn.theproudsoul.fiscopetshop.solidity;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Address;
import org.fisco.bcos.web3j.abi.datatypes.DynamicArray;
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint256;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple5;
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
public class Transaction extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b5033600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506112eb806100616000396000f300608060405260043610610099576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680630ae80dd51461009e57806331402a57146100cb57806339d4ac6c146100f85780636c2f629b14610125578063c5c8cfbf14610188578063c827deb5146101f4578063ca267f2814610291578063e75b8b23146102bc578063e76637ce14610371575b600080fd5b3480156100aa57600080fd5b506100c9600480360381019080803590602001909291905050506103dd565b005b3480156100d757600080fd5b506100f6600480360381019080803590602001909291905050506107e7565b005b34801561010457600080fd5b50610123600480360381019080803590602001909291905050506108ca565b005b34801561013157600080fd5b50610186600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610964565b005b34801561019457600080fd5b5061019d610a48565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b838110156101e05780820151818401526020810190506101c5565b505050509050019250505060405180910390f35b34801561020057600080fd5b5061028f600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803563ffffffff16906020019092919080359060200190929190505050610b5a565b005b34801561029d57600080fd5b506102a6610fa4565b6040518082815260200191505060405180910390f35b3480156102c857600080fd5b506102e76004803603810190808035906020019092919050505061100d565b604051808673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018481526020018381526020018281526020019550505050505060405180910390f35b34801561037d57600080fd5b5061038661110c565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b838110156103c95780820151818401526020810190506103ae565b505050509050019250505060405180910390f35b60008060008033600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614151561044057600080fd5b60008681548110151561044f57fe5b906000526020600020906005020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16945060008681548110151561049257fe5b906000526020600020906005020160010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1693506000868154811015156104d557fe5b90600052602060002090600502016003015492506000868154811015156104f857fe5b9060005260206000209060050201600201549150600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663f31281d7600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff168688876040518563ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828152602001945050505050600060405180830381600087803b15801561065b57600080fd5b505af115801561066f573d6000803e3d6000fd5b50505050600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16633548d59c600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1684876040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018381526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019350505050600060405180830381600087803b15801561078e57600080fd5b505af11580156107a2573d6000803e3d6000fd5b5050505060156000878154811015156107b757fe5b90600052602060002090600502016004018190555060036000815480929190600190039190505550505050505050565b6000818154811015156107f657fe5b906000526020600020906005020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561086157600080fd5b6000808281548110151561087157fe5b90600052602060002090600502016004015414151561088f57600080fd5b60016000828154811015156108a057fe5b90600052602060002090600502016004018190555060036000815480929190600101919050555050565b33600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614151561092757600080fd5b601460008381548110151561093857fe5b906000526020600020906005020160040181905550600360008154809291906001900391905055505050565b33600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff161415156109c157600080fd5b82600460006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555081600560006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550505050565b60608060008033600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff16141515610aab57600080fd5b600354604051908082528060200260200182016040528015610adc5781602001602082028038833980820191505090505b50935060009250600091505b600080549050821015610b505760008083815481101515610b0557fe5b9060005260206000209060050201600401541115610b4357818484815181101515610b2c57fe5b906020019060200201818152505082806001019350505b8180600101925050610ae8565b8394505050505090565b84600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff16141515610bb757600080fd5b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168673ffffffffffffffffffffffffffffffffffffffff16141515610c7c576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252600a8152602001807f6e6f742061646d696e210000000000000000000000000000000000000000000081525060200191505060405180910390fd5b600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663f31281d7878787876040518563ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018263ffffffff168152602001945050505050600060405180830381600087803b158015610daf57600080fd5b505af1158015610dc3573d6000803e3d6000fd5b50505050600060a0604051908101604052808773ffffffffffffffffffffffffffffffffffffffff1681526020018673ffffffffffffffffffffffffffffffffffffffff1681526020018481526020018563ffffffff16815260200160008152509080600181540180825580915050906001820390600052602060002090600502016000909192909190915060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060208201518160010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550604082015181600201556060820151816003015560808201518160040155505050600160008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008154809291906001019190505550600160008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008154809291906001019190505550505050505050565b6000600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561100257600080fd5b600080549050905090565b6000806000806000808681548110151561102357fe5b906000526020600020906005020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1660008781548110151561106457fe5b906000526020600020906005020160010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff166000888154811015156110a557fe5b9060005260206000209060050201600201546000898154811015156110c657fe5b90600052602060002090600502016003015460008a8154811015156110e757fe5b9060005260206000209060050201600401549450945094509450945091939590929450565b606080600080600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020546040519080825280602002602001820160405280156111805781602001602082028038833980820191505090505b50925060009150600090505b6000805490508110156112b6573373ffffffffffffffffffffffffffffffffffffffff166000828154811015156111bf57fe5b906000526020600020906005020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16148061127e57503373ffffffffffffffffffffffffffffffffffffffff1660008281548110151561123457fe5b906000526020600020906005020160010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16145b156112a95780838381518110151561129257fe5b906020019060200201818152505081806001019250505b808060010191505061118c565b829350505050905600a165627a7a72305820688e830e454456b437c8f3f55e714474f26f76b02e5736afbc897198bf9899370029";

    public static final String FUNC_APPROVEARBITRATION = "approveArbitration";

    public static final String FUNC_REQUESTARBITRATION = "requestArbitration";

    public static final String FUNC_DENYARBITRATION = "denyArbitration";

    public static final String FUNC_SETPETANDACCNTCONTADDR = "setPetAndAccntContAddr";

    public static final String FUNC_GETALLARBITRATIONS = "getAllArbitrations";

    public static final String FUNC_MAKEPURCHASE = "makePurchase";

    public static final String FUNC_GETRECORDCOUNT = "getRecordCount";

    public static final String FUNC_GETRECORDBYID = "getRecordById";

    public static final String FUNC_GETMYRECORDS = "getMyRecords";

    @Deprecated
    protected Transaction(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Transaction(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Transaction(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Transaction(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> approveArbitration(BigInteger _recordId) {
        final Function function = new Function(
                FUNC_APPROVEARBITRATION, 
                Arrays.<Type>asList(new Uint256(_recordId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void approveArbitration(BigInteger _recordId, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_APPROVEARBITRATION, 
                Arrays.<Type>asList(new Uint256(_recordId)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public RemoteCall<TransactionReceipt> requestArbitration(BigInteger _recordId) {
        final Function function = new Function(
                FUNC_REQUESTARBITRATION, 
                Arrays.<Type>asList(new Uint256(_recordId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void requestArbitration(BigInteger _recordId, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_REQUESTARBITRATION, 
                Arrays.<Type>asList(new Uint256(_recordId)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public RemoteCall<TransactionReceipt> denyArbitration(BigInteger _recordId) {
        final Function function = new Function(
                FUNC_DENYARBITRATION, 
                Arrays.<Type>asList(new Uint256(_recordId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void denyArbitration(BigInteger _recordId, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_DENYARBITRATION, 
                Arrays.<Type>asList(new Uint256(_recordId)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public RemoteCall<TransactionReceipt> setPetAndAccntContAddr(String _petContract, String _accountContract) {
        final Function function = new Function(
                FUNC_SETPETANDACCNTCONTADDR, 
                Arrays.<Type>asList(new Address(_petContract),
                new Address(_accountContract)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setPetAndAccntContAddr(String _petContract, String _accountContract, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETPETANDACCNTCONTADDR, 
                Arrays.<Type>asList(new Address(_petContract),
                new Address(_accountContract)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public RemoteCall<List> getAllArbitrations() {
        final Function function = new Function(FUNC_GETALLARBITRATIONS, 
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

    public RemoteCall<TransactionReceipt> makePurchase(String _sender, String _buyer, String _seller, BigInteger _price, BigInteger _petId) {
        final Function function = new Function(
                FUNC_MAKEPURCHASE, 
                Arrays.<Type>asList(new Address(_sender),
                new Address(_buyer),
                new Address(_seller),
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint32(_price), 
                new Uint256(_petId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void makePurchase(String _sender, String _buyer, String _seller, BigInteger _price, BigInteger _petId, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_MAKEPURCHASE, 
                Arrays.<Type>asList(new Address(_sender),
                new Address(_buyer),
                new Address(_seller),
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint32(_price), 
                new Uint256(_petId)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public RemoteCall<BigInteger> getRecordCount() {
        final Function function = new Function(FUNC_GETRECORDCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Tuple5<String, String, BigInteger, BigInteger, BigInteger>> getRecordById(BigInteger _recordId) {
        final Function function = new Function(FUNC_GETRECORDBYID, 
                Arrays.<Type>asList(new Uint256(_recordId)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple5<String, String, BigInteger, BigInteger, BigInteger>>(
                new Callable<Tuple5<String, String, BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple5<String, String, BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<String, String, BigInteger, BigInteger, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue());
                    }
                });
    }

    public RemoteCall<List> getMyRecords() {
        final Function function = new Function(FUNC_GETMYRECORDS, 
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

    @Deprecated
    public static Transaction load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Transaction(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Transaction load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Transaction(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Transaction load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Transaction(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Transaction load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Transaction(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Transaction> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Transaction.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<Transaction> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Transaction.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Transaction> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Transaction.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Transaction> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Transaction.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
