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
    public static final String BINARY = "6080604052600060035534801561001557600080fd5b5033600560006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550611a97806100666000396000f3006080604052600436106100af576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680633548d59c146100b457806338cc483114610121578063546dbc711461017857806358c395a3146101e457806368651f60146102275780638f8598781461025257806397fd3a64146102d5578063a36c730614610302578063a5f44cdb1461036e578063cb920509146103e1578063dee50c2c146105f8575b600080fd5b3480156100c057600080fd5b5061011f600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610741565b005b34801561012d57600080fd5b506101366108c6565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561018457600080fd5b5061018d6108ce565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b838110156101d05780820151818401526020810190506101b5565b505050509050019250505060405180910390f35b3480156101f057600080fd5b50610225600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061098d565b005b34801561023357600080fd5b5061023c610a2d565b6040518082815260200191505060405180910390f35b34801561025e57600080fd5b506102d360048036038101908080359060200190929190803563ffffffff169060200190929190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610a93565b005b3480156102e157600080fd5b5061030060048036038101908080359060200190929190505050610cfa565b005b34801561030e57600080fd5b50610317610eb1565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b8381101561035a57808201518184015260208101905061033f565b505050509050019250505060405180910390f35b34801561037a57600080fd5b506103df60048036038101908080359060200190929190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610fe1565b005b3480156103ed57600080fd5b5061040c60048036038101908080359060200190929190505050611371565b60405180881515151581526020018761ffff1661ffff1681526020018663ffffffff1663ffffffff16815260200180602001806020018060200180602001858103855289818151815260200191508051906020019080838360005b83811015610482578082015181840152602081019050610467565b50505050905090810190601f1680156104af5780820380516001836020036101000a031916815260200191505b50858103845288818151815260200191508051906020019080838360005b838110156104e85780820151818401526020810190506104cd565b50505050905090810190601f1680156105155780820380516001836020036101000a031916815260200191505b50858103835287818151815260200191508051906020019080838360005b8381101561054e578082015181840152602081019050610533565b50505050905090810190601f16801561057b5780820380516001836020036101000a031916815260200191505b50858103825286818151815260200191508051906020019080838360005b838110156105b4578082015181840152602081019050610599565b50505050905090810190601f1680156105e15780820380516001836020036101000a031916815260200191505b509b50505050505050505050505060405180910390f35b34801561060457600080fd5b5061073f600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803561ffff169060200190929190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050611713565b005b600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff1614151561079d57600080fd5b600260006001600085815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000815480929190600190039190505550600260008273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008154809291906001019190505550806001600084815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550505050565b600033905090565b6060806000806003546040519080825280602002602001820160405280156109055781602001602082028038833980820191505090505b50925060009150600090505b6000805490508110156109845760008181548110151561092d57fe5b906000526020600020906006020160000160009054906101000a900460ff16156109775780838381518110151561096057fe5b906020019060200201818152505081806001019250505b8080600101915050610911565b82935050505090565b600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156109e957600080fd5b80600460006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b6000600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610a8b57600080fd5b600354905090565b33838173ffffffffffffffffffffffffffffffffffffffff166001600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16141515610b6b576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601c8152602001807f796f752063616e206e6f742073656c6c206f746865727320706574210000000081525060200191505060405180910390fd5b600085815481101515610b7a57fe5b906000526020600020906006020160000160009054906101000a900460ff16151515610c34576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252602b8152602001807f70657420697320666f722073616c652120706c6561736520707574206f66662081526020017f73616c652066697273742e00000000000000000000000000000000000000000081525060400191505060405180910390fd5b83600086815481101515610c4457fe5b906000526020600020906006020160000160036101000a81548163ffffffff021916908363ffffffff1602179055506001600086815481101515610c8457fe5b906000526020600020906006020160000160006101000a81548160ff02191690831515021790555082600086815481101515610cbc57fe5b90600052602060002090600602016005019080519060200190610ce0929190611946565b506003600081548092919060010191905055505050505050565b33818173ffffffffffffffffffffffffffffffffffffffff166001600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16141515610dd2576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601c8152602001807f796f752063616e206e6f742073656c6c206f746865727320706574210000000081525060200191505060405180910390fd5b600083815481101515610de157fe5b906000526020600020906006020160000160009054906101000a900460ff161515610e74576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260118152602001807f706574206e6f7420666f722073616c652100000000000000000000000000000081525060200191505060405180910390fd5b60008084815481101515610e8457fe5b906000526020600020906006020160000160006101000a81548160ff021916908315150217905550505050565b606080600080600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054604051908082528060200260200182016040528015610f255781602001602082028038833980820191505090505b50925060009150600090505b600080549050811015610fd8573373ffffffffffffffffffffffffffffffffffffffff166001600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415610fcb57808383815181101515610fb457fe5b906020019060200201818152505081806001019250505b8080600101915050610f31565b82935050505090565b6000803391506001600085815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663e408ada1600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16848460008981548110151561108f57fe5b906000526020600020906006020160000160039054906101000a900463ffffffff1689896040518763ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018463ffffffff16815260200183815260200180602001828103825283818151815260200191508051906020019080838360005b838110156111c65780820151818401526020810190506111ab565b50505050905090810190601f1680156111f35780820380516001836020036101000a031916815260200191505b50975050505050505050600060405180830381600087803b15801561121757600080fd5b505af115801561122b573d6000803e3d6000fd5b50505050816001600086815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600260008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008154809291906001019190505550600260008273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008154809291906001900391905055506000808581548110151561133057fe5b906000526020600020906006020160000160006101000a81548160ff0219169083151502179055506003600081548092919060019003919050555050505050565b600080600060608060608060008881548110151561138b57fe5b906000526020600020906006020160000160009054906101000a900460ff166000898154811015156113b957fe5b906000526020600020906006020160000160019054906101000a900461ffff1660008a8154811015156113e857fe5b906000526020600020906006020160000160039054906101000a900463ffffffff1660008b81548110151561141957fe5b906000526020600020906006020160010160008c81548110151561143957fe5b906000526020600020906006020160020160008d81548110151561145957fe5b906000526020600020906006020160030160008e81548110151561147957fe5b9060005260206000209060060201600501838054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561151f5780601f106114f45761010080835404028352916020019161151f565b820191906000526020600020905b81548152906001019060200180831161150257829003601f168201915b50505050509350828054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156115bb5780601f10611590576101008083540402835291602001916115bb565b820191906000526020600020905b81548152906001019060200180831161159e57829003601f168201915b50505050509250818054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156116575780601f1061162c57610100808354040283529160200191611657565b820191906000526020600020905b81548152906001019060200180831161163a57829003601f168201915b50505050509150808054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156116f35780601f106116c8576101008083540402835291602001916116f3565b820191906000526020600020905b8154815290600101906020018083116116d657829003601f168201915b505050505090509650965096509650965096509650919395979092949650565b600060016000610100604051908101604052806000151581526020018861ffff168152602001600063ffffffff16815260200189815260200187815260200186815260200185815260200160206040519081016040528060008152508152509080600181540180825580915050906001820390600052602060002090600602016000909192909190915060008201518160000160006101000a81548160ff02191690831515021790555060208201518160000160016101000a81548161ffff021916908361ffff16021790555060408201518160000160036101000a81548163ffffffff021916908363ffffffff16021790555060608201518160010190805190602001906118239291906119c6565b5060808201518160020190805190602001906118409291906119c6565b5060a082015181600301908051906020019061185d9291906119c6565b5060c082015181600401908051906020019061187a9291906119c6565b5060e08201518160050190805190602001906118979291906119c6565b505050039050336001600083815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008154809291906001019190505550505050505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061198757805160ff19168380011785556119b5565b828001600101855582156119b5579182015b828111156119b4578251825591602001919060010190611999565b5b5090506119c29190611a46565b5090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10611a0757805160ff1916838001178555611a35565b82800160010185558215611a35579182015b82811115611a34578251825591602001919060010190611a19565b5b509050611a429190611a46565b5090565b611a6891905b80821115611a64576000816000905550600101611a4c565b5090565b905600a165627a7a723058200372b12d0c6117e4911f4fbe45fbe300ad700e34c3e4937836feab2d6c5c95230029";

    public static final String ABI = "[{\"constant\":false,\"inputs\":[{\"name\":\"_sender\",\"type\":\"address\"},{\"name\":\"_petId\",\"type\":\"uint256\"},{\"name\":\"_newOwner\",\"type\":\"address\"}],\"name\":\"changeOwnership\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getAddress\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getPetsForSale\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256[]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_transactionContract\",\"type\":\"address\"}],\"name\":\"setTranContAddr\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getSalingPetCounts\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_petId\",\"type\":\"uint256\"},{\"name\":\"_price\",\"type\":\"uint32\"},{\"name\":\"_time\",\"type\":\"string\"}],\"name\":\"sellPet\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_petId\",\"type\":\"uint256\"}],\"name\":\"offSale\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getMyPets\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256[]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_petId\",\"type\":\"uint256\"},{\"name\":\"_time\",\"type\":\"string\"}],\"name\":\"buyPet\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_petId\",\"type\":\"uint256\"}],\"name\":\"getPetById\",\"outputs\":[{\"name\":\"selling\",\"type\":\"bool\"},{\"name\":\"species\",\"type\":\"uint16\"},{\"name\":\"price\",\"type\":\"uint32\"},{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"bday\",\"type\":\"string\"},{\"name\":\"disc\",\"type\":\"string\"},{\"name\":\"time\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_name\",\"type\":\"string\"},{\"name\":\"_species\",\"type\":\"uint16\"},{\"name\":\"_bday\",\"type\":\"string\"},{\"name\":\"_disc\",\"type\":\"string\"},{\"name\":\"_picUrl\",\"type\":\"string\"}],\"name\":\"newPet\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"inputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"}]";

    public static final String FUNC_CHANGEOWNERSHIP = "changeOwnership";

    public static final String FUNC_GETADDRESS = "getAddress";

    public static final String FUNC_GETPETSFORSALE = "getPetsForSale";

    public static final String FUNC_SETTRANCONTADDR = "setTranContAddr";

    public static final String FUNC_GETSALINGPETCOUNTS = "getSalingPetCounts";

    public static final String FUNC_SELLPET = "sellPet";

    public static final String FUNC_OFFSALE = "offSale";

    public static final String FUNC_GETMYPETS = "getMyPets";

    public static final String FUNC_BUYPET = "buyPet";

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

    public RemoteCall<TransactionReceipt> changeOwnership(String _sender, BigInteger _petId, String _newOwner) {
        final Function function = new Function(
                FUNC_CHANGEOWNERSHIP, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_sender), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_petId), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(_newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void changeOwnership(String _sender, BigInteger _petId, String _newOwner, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_CHANGEOWNERSHIP, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_sender), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_petId), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(_newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String changeOwnershipSeq(String _sender, BigInteger _petId, String _newOwner) {
        final Function function = new Function(
                FUNC_CHANGEOWNERSHIP, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_sender), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_petId), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(_newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
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
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_transactionContract)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setTranContAddr(String _transactionContract, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETTRANCONTADDR, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_transactionContract)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setTranContAddrSeq(String _transactionContract) {
        final Function function = new Function(
                FUNC_SETTRANCONTADDR, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_transactionContract)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<BigInteger> getSalingPetCounts() {
        final Function function = new Function(FUNC_GETSALINGPETCOUNTS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> sellPet(BigInteger _petId, BigInteger _price, String _time) {
        final Function function = new Function(
                FUNC_SELLPET, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_petId), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint32(_price), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_time)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void sellPet(BigInteger _petId, BigInteger _price, String _time, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SELLPET, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_petId), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint32(_price), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_time)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String sellPetSeq(BigInteger _petId, BigInteger _price, String _time) {
        final Function function = new Function(
                FUNC_SELLPET, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_petId), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint32(_price), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_time)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<TransactionReceipt> offSale(BigInteger _petId) {
        final Function function = new Function(
                FUNC_OFFSALE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_petId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void offSale(BigInteger _petId, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_OFFSALE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_petId)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String offSaleSeq(BigInteger _petId) {
        final Function function = new Function(
                FUNC_OFFSALE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_petId)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
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

    public RemoteCall<TransactionReceipt> buyPet(BigInteger _petId, String _time) {
        final Function function = new Function(
                FUNC_BUYPET, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_petId), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_time)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void buyPet(BigInteger _petId, String _time, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_BUYPET, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_petId), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_time)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String buyPetSeq(BigInteger _petId, String _time) {
        final Function function = new Function(
                FUNC_BUYPET, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_petId), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_time)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<Tuple7<Boolean, BigInteger, BigInteger, String, String, String, String>> getPetById(BigInteger _petId) {
        final Function function = new Function(FUNC_GETPETBYID, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_petId)), 
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
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_name), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint16(_species), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_bday), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_disc), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_picUrl)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void newPet(String _name, BigInteger _species, String _bday, String _disc, String _picUrl, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_NEWPET, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_name), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint16(_species), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_bday), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_disc), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_picUrl)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String newPetSeq(String _name, BigInteger _species, String _bday, String _disc, String _picUrl) {
        final Function function = new Function(
                FUNC_NEWPET, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_name), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint16(_species), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_bday), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_disc), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_picUrl)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
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
