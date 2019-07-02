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
import org.fisco.bcos.web3j.abi.datatypes.Utf8String;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint256;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple6;
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
    public static final String BINARY = "608060405234801561001057600080fd5b5033600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506115a2806100616000396000f300608060405260043610610099576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680630ae80dd51461009e57806331402a57146100cb57806339d4ac6c146100f85780636c2f629b146101255780639b01a45214610188578063c5c8cfbf1461023d578063ca267f28146102a9578063e75b8b23146102d4578063e76637ce146103f5575b600080fd5b3480156100aa57600080fd5b506100c960048036038101908080359060200190929190505050610461565b005b3480156100d757600080fd5b506100f66004803603810190808035906020019092919050505061086b565b005b34801561010457600080fd5b50610123600480360381019080803590602001909291905050506109c4565b005b34801561013157600080fd5b50610186600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610a5e565b005b34801561019457600080fd5b5061023b600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803563ffffffff16906020019092919080359060200190929190803590602001908201803590602001919091929391929390505050610b42565b005b34801561024957600080fd5b50610252610fe3565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b8381101561029557808201518184015260208101905061027a565b505050509050019250505060405180910390f35b3480156102b557600080fd5b506102be6110f5565b6040518082815260200191505060405180910390f35b3480156102e057600080fd5b506102ff6004803603810190808035906020019092919050505061115e565b604051808773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200185815260200184815260200183815260200180602001828103825283818151815260200191508051906020019080838360005b838110156103b557808201518184015260208101905061039a565b50505050905090810190601f1680156103e25780820380516001836020036101000a031916815260200191505b5097505050505050505060405180910390f35b34801561040157600080fd5b5061040a61131e565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b8381101561044d578082015181840152602081019050610432565b505050509050019250505060405180910390f35b60008060008033600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff161415156104c457600080fd5b6000868154811015156104d357fe5b906000526020600020906006020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16945060008681548110151561051657fe5b906000526020600020906006020160010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16935060008681548110151561055957fe5b906000526020600020906006020160030154925060008681548110151561057c57fe5b9060005260206000209060060201600201549150600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663f31281d7600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff168688876040518563ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828152602001945050505050600060405180830381600087803b1580156106df57600080fd5b505af11580156106f3573d6000803e3d6000fd5b50505050600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16633548d59c600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1684876040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018381526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019350505050600060405180830381600087803b15801561081257600080fd5b505af1158015610826573d6000803e3d6000fd5b50505050601560008781548110151561083b57fe5b90600052602060002090600602016004018190555060036000815480929190600190039190505550505050505050565b60008181548110151561087a57fe5b906000526020600020906006020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16148061095057506000818154811015156108ef57fe5b906000526020600020906006020160010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b151561095b57600080fd5b6000808281548110151561096b57fe5b90600052602060002090600602016004015414151561098957600080fd5b600160008281548110151561099a57fe5b90600052602060002090600602016004018190555060036000815480929190600101919050555050565b33600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff16141515610a2157600080fd5b6014600083815481101515610a3257fe5b906000526020600020906006020160040181905550600360008154809291906001900391905055505050565b33600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff16141515610abb57600080fd5b82600460006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555081600560006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550505050565b86600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff16141515610b9f57600080fd5b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168873ffffffffffffffffffffffffffffffffffffffff16141515610c64576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252600a8152602001807f6e6f742061646d696e210000000000000000000000000000000000000000000081525060200191505060405180910390fd5b600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663f31281d7898989896040518563ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018263ffffffff168152602001945050505050600060405180830381600087803b158015610d9757600080fd5b505af1158015610dab573d6000803e3d6000fd5b50505050600060c0604051908101604052808973ffffffffffffffffffffffffffffffffffffffff1681526020018873ffffffffffffffffffffffffffffffffffffffff1681526020018681526020018763ffffffff1681526020016000815260200185858080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050508152509080600181540180825580915050906001820390600052602060002090600602016000909192909190915060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060208201518160010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060408201518160020155606082015181600301556080820151816004015560a0820151816005019080519060200190610f379291906114d1565b50505050600160008873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008154809291906001019190505550600160008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600081548092919060010191905055505050505050505050565b60608060008033600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614151561104657600080fd5b6003546040519080825280602002602001820160405280156110775781602001602082028038833980820191505090505b50935060009250600091505b6000805490508210156110eb57600080838154811015156110a057fe5b90600052602060002090600602016004015411156110de578184848151811015156110c757fe5b906020019060200201818152505082806001019350505b8180600101925050611083565b8394505050505090565b6000600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561115357600080fd5b600080549050905090565b6000806000806000606060008781548110151561117757fe5b906000526020600020906006020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff166000888154811015156111b857fe5b906000526020600020906006020160010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff166000898154811015156111f957fe5b90600052602060002090600602016002015460008a81548110151561121a57fe5b90600052602060002090600602016003015460008b81548110151561123b57fe5b90600052602060002090600602016004015460008c81548110151561125c57fe5b9060005260206000209060060201600501808054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156113025780601f106112d757610100808354040283529160200191611302565b820191906000526020600020905b8154815290600101906020018083116112e557829003601f168201915b5050505050905095509550955095509550955091939550919395565b606080600080600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020546040519080825280602002602001820160405280156113925781602001602082028038833980820191505090505b50925060009150600090505b6000805490508110156114c8573373ffffffffffffffffffffffffffffffffffffffff166000828154811015156113d157fe5b906000526020600020906006020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16148061149057503373ffffffffffffffffffffffffffffffffffffffff1660008281548110151561144657fe5b906000526020600020906006020160010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16145b156114bb578083838151811015156114a457fe5b906020019060200201818152505081806001019250505b808060010191505061139e565b82935050505090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061151257805160ff1916838001178555611540565b82800160010185558215611540579182015b8281111561153f578251825591602001919060010190611524565b5b50905061154d9190611551565b5090565b61157391905b8082111561156f576000816000905550600101611557565b5090565b905600a165627a7a723058201e9f2ed8f5b09845c88c5aae9b0400de1d9964660a9f38b01c1c7b073cb1588c0029";

    public static final String ABI = "[{\"constant\":false,\"inputs\":[{\"name\":\"_recordId\",\"type\":\"uint256\"}],\"name\":\"approveArbitration\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_recordId\",\"type\":\"uint256\"}],\"name\":\"requestArbitration\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_recordId\",\"type\":\"uint256\"}],\"name\":\"denyArbitration\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_petContract\",\"type\":\"address\"},{\"name\":\"_accountContract\",\"type\":\"address\"}],\"name\":\"setPetAndAccntContAddr\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_sender\",\"type\":\"address\"},{\"name\":\"_buyer\",\"type\":\"address\"},{\"name\":\"_seller\",\"type\":\"address\"},{\"name\":\"_price\",\"type\":\"uint32\"},{\"name\":\"_petId\",\"type\":\"uint256\"},{\"name\":\"_time\",\"type\":\"string\"}],\"name\":\"makePurchase\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getAllArbitrations\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256[]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getRecordCount\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_recordId\",\"type\":\"uint256\"}],\"name\":\"getRecordById\",\"outputs\":[{\"name\":\"buyer\",\"type\":\"address\"},{\"name\":\"seller\",\"type\":\"address\"},{\"name\":\"petId\",\"type\":\"uint256\"},{\"name\":\"price\",\"type\":\"uint256\"},{\"name\":\"status\",\"type\":\"uint256\"},{\"name\":\"time\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getMyRecords\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256[]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"inputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"}]";

    public static final String FUNC_APPROVEARBITRATION = "approveArbitration";

    public static final String FUNC_REQUESTARBITRATION = "requestArbitration";

    public static final String FUNC_DENYARBITRATION = "denyArbitration";

    public static final String FUNC_SETPETANDACCNTCONTADDR = "setPetAndAccntContAddr";

    public static final String FUNC_MAKEPURCHASE = "makePurchase";

    public static final String FUNC_GETALLARBITRATIONS = "getAllArbitrations";

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
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_recordId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void approveArbitration(BigInteger _recordId, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_APPROVEARBITRATION, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_recordId)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String approveArbitrationSeq(BigInteger _recordId) {
        final Function function = new Function(
                FUNC_APPROVEARBITRATION, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_recordId)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<TransactionReceipt> requestArbitration(BigInteger _recordId) {
        final Function function = new Function(
                FUNC_REQUESTARBITRATION, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_recordId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void requestArbitration(BigInteger _recordId, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_REQUESTARBITRATION, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_recordId)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String requestArbitrationSeq(BigInteger _recordId) {
        final Function function = new Function(
                FUNC_REQUESTARBITRATION, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_recordId)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<TransactionReceipt> denyArbitration(BigInteger _recordId) {
        final Function function = new Function(
                FUNC_DENYARBITRATION, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_recordId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void denyArbitration(BigInteger _recordId, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_DENYARBITRATION, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_recordId)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String denyArbitrationSeq(BigInteger _recordId) {
        final Function function = new Function(
                FUNC_DENYARBITRATION, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_recordId)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<TransactionReceipt> setPetAndAccntContAddr(String _petContract, String _accountContract) {
        final Function function = new Function(
                FUNC_SETPETANDACCNTCONTADDR, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_petContract), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(_accountContract)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setPetAndAccntContAddr(String _petContract, String _accountContract, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETPETANDACCNTCONTADDR, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_petContract), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(_accountContract)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setPetAndAccntContAddrSeq(String _petContract, String _accountContract) {
        final Function function = new Function(
                FUNC_SETPETANDACCNTCONTADDR, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_petContract), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(_accountContract)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<TransactionReceipt> makePurchase(String _sender, String _buyer, String _seller, BigInteger _price, BigInteger _petId, String _time) {
        final Function function = new Function(
                FUNC_MAKEPURCHASE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_sender), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(_buyer), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(_seller), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint32(_price), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_petId), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_time)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void makePurchase(String _sender, String _buyer, String _seller, BigInteger _price, BigInteger _petId, String _time, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_MAKEPURCHASE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_sender), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(_buyer), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(_seller), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint32(_price), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_petId), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_time)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String makePurchaseSeq(String _sender, String _buyer, String _seller, BigInteger _price, BigInteger _petId, String _time) {
        final Function function = new Function(
                FUNC_MAKEPURCHASE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_sender), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(_buyer), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(_seller), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint32(_price), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_petId), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_time)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
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

    public RemoteCall<BigInteger> getRecordCount() {
        final Function function = new Function(FUNC_GETRECORDCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Tuple6<String, String, BigInteger, BigInteger, BigInteger, String>> getRecordById(BigInteger _recordId) {
        final Function function = new Function(FUNC_GETRECORDBYID, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_recordId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteCall<Tuple6<String, String, BigInteger, BigInteger, BigInteger, String>>(
                new Callable<Tuple6<String, String, BigInteger, BigInteger, BigInteger, String>>() {
                    @Override
                    public Tuple6<String, String, BigInteger, BigInteger, BigInteger, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple6<String, String, BigInteger, BigInteger, BigInteger, String>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (String) results.get(5).getValue());
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