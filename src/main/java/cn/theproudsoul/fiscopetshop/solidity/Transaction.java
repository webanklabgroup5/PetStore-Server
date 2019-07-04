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
public class Transaction extends Contract {
    public static final String BINARY = "60806040526110066000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555034801561005257600080fd5b5033600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550612257806100a36000396000f3006080604052600436106100c5576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680630ae80dd5146100ca57806334a18dda146100f75780636c2f629b1461016a57806379fa913f146101cd57806383d93a1c146102365780639b01a452146102a9578063bca926af1461035e578063c5c8cfbf14610375578063ca267f28146103e1578063d39f70bc1461040c578063e75b8b2314610423578063e76637ce146105b0578063fe9e0f621461061c575b600080fd5b3480156100d657600080fd5b506100f56004803603810190808035906020019092919050505061068f565b005b34801561010357600080fd5b50610168600480360381019080803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919291929080359060200190929190505050610b02565b005b34801561017657600080fd5b506101cb600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610c73565b005b3480156101d957600080fd5b50610234600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610dc0565b005b34801561024257600080fd5b506102a760048036038101908080359060200190929190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610f28565b005b3480156102b557600080fd5b5061035c600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803563ffffffff16906020019092919080359060200190929190803590602001908201803590602001919091929391929390505050611061565b005b34801561036a57600080fd5b506103736114d9565b005b34801561038157600080fd5b5061038a611582565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b838110156103cd5780820151818401526020810190506103b2565b505050509050019250505060405180910390f35b3480156103ed57600080fd5b506103f66116fe565b6040518082815260200191505060405180910390f35b34801561041857600080fd5b506104216117d2565b005b34801561042f57600080fd5b5061044e60048036038101908080359060200190929190505050611877565b604051808873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018681526020018581526020018481526020018060200180602001838103835285818151815260200191508051906020019080838360005b838110156105085780820151818401526020810190506104ed565b50505050905090810190601f1680156105355780820380516001836020036101000a031916815260200191505b50838103825284818151815260200191508051906020019080838360005b8381101561056e578082015181840152602081019050610553565b50505050905090810190601f16801561059b5780820380516001836020036101000a031916815260200191505b50995050505050505050505060405180910390f35b3480156105bc57600080fd5b506105c5611af8565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b838110156106085780820151818401526020810190506105ed565b505050509050019250505060405180910390f35b34801561062857600080fd5b5061068d60048036038101908080359060200190929190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050611cab565b005b60008060008033600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614151561075b576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f726571756972652061646d696e207065726d697373696f6e210000000000000081525060200191505060405180910390fd5b60018681548110151561076a57fe5b906000526020600020906007020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1694506001868154811015156107ad57fe5b906000526020600020906007020160010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1693506001868154811015156107f057fe5b906000526020600020906007020160030154925060018681548110151561081357fe5b9060005260206000209060070201600201549150600660009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663f31281d7600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff168688876040518563ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828152602001945050505050600060405180830381600087803b15801561097657600080fd5b505af115801561098a573d6000803e3d6000fd5b50505050600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663a5b668dc83600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16876040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808481526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019350505050600060405180830381600087803b158015610aa957600080fd5b505af1158015610abd573d6000803e3d6000fd5b505050506015600187815481101515610ad257fe5b90600052602060002090600702016004018190555060046000815480929190600190039190505550505050505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16630553904e3084846040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200180602001838152602001828103825284818151815260200191508051906020019080838360005b83811015610be5578082015181840152602081019050610bca565b50505050905090810190601f168015610c125780820380516001836020036101000a031916815260200191505b50945050505050602060405180830381600087803b158015610c3357600080fd5b505af1158015610c47573d6000803e3d6000fd5b505050506040513d6020811015610c5d57600080fd5b8101908080519060200190929190505050505050565b33600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff16141515610d39576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f726571756972652061646d696e207065726d697373696f6e210000000000000081525060200191505060405180910390fd5b82600560006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555081600660006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166311e3f2af30836040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200180602001828103825283818151815260200191508051906020019080838360005b83811015610e9c578082015181840152602081019050610e81565b50505050905090810190601f168015610ec95780820380516001836020036101000a031916815260200191505b509350505050602060405180830381600087803b158015610ee957600080fd5b505af1158015610efd573d6000803e3d6000fd5b505050506040513d6020811015610f1357600080fd5b81019080805190602001909291905050505050565b33600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff16141515610fee576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f726571756972652061646d696e207065726d697373696f6e210000000000000081525060200191505060405180910390fd5b81600184815481101515610ffe57fe5b90600052602060002090600702016006019080519060200190611022929190612106565b50601460018481548110151561103457fe5b90600052602060002090600702016004018190555060046000815480929190600190039190505550505050565b86600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff16141515611127576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f726571756972652061646d696e207065726d697373696f6e210000000000000081525060200191505060405180910390fd5b600660009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663f31281d7898989896040518563ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018263ffffffff168152602001945050505050600060405180830381600087803b15801561125a57600080fd5b505af115801561126e573d6000803e3d6000fd5b50505050600160e0604051908101604052808973ffffffffffffffffffffffffffffffffffffffff1681526020018873ffffffffffffffffffffffffffffffffffffffff1681526020018681526020018763ffffffff1681526020016000815260200185858080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050815260200160206040519081016040528060008152508152509080600181540180825580915050906001820390600052602060002090600702016000909192909190915060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060208201518160010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060408201518160020155606082015181600301556080820151816004015560a0820151816005019080519060200190611410929190612186565b5060c082015181600601908051906020019061142d929190612186565b50505050600260008873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008154809291906001019190505550600260008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600081548092919060010191905055505050505050505050565b611540606060405190810160405280602181526020017f726571756573744172626974726174696f6e2875696e743235362c7374696e6781526020017f29000000000000000000000000000000000000000000000000000000000000008152506001610b02565b6115806040805190810160405280601f81526020017f64656e794172626974726174696f6e2875696e743235362c737472696e6729008152506001610b02565b565b60608060008033600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614151561164e576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f726571756972652061646d696e207065726d697373696f6e210000000000000081525060200191505060405180910390fd5b60045460405190808252806020026020018201604052801561167f5781602001602082028038833980820191505090505b50935060009250600091505b6001805490508210156116f45760006001838154811015156116a957fe5b90600052602060002090600702016004015411156116e7578184848151811015156116d057fe5b906020019060200201818152505082806001019350505b818060010192505061168b565b8394505050505090565b600033600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff161415156117c6576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f726571756972652061646d696e207065726d697373696f6e210000000000000081525060200191505060405180910390fd5b60018054905091505090565b611837606060405190810160405280602281526020017f726571756573744172626974726174696f6e2875696e743235362c737472696e81526020017f6729000000000000000000000000000000000000000000000000000000000000815250610dc0565b6118756040805190810160405280601f81526020017f64656e794172626974726174696f6e2875696e743235362c737472696e672900815250610dc0565b565b600080600080600060608060018881548110151561189157fe5b906000526020600020906007020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff166001898154811015156118d257fe5b906000526020600020906007020160010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1660018a81548110151561191357fe5b90600052602060002090600702016002015460018b81548110151561193457fe5b90600052602060002090600702016003015460018c81548110151561195557fe5b90600052602060002090600702016004015460018d81548110151561197657fe5b906000526020600020906007020160050160018e81548110151561199657fe5b9060005260206000209060070201600601818054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015611a3c5780601f10611a1157610100808354040283529160200191611a3c565b820191906000526020600020905b815481529060010190602001808311611a1f57829003601f168201915b50505050509150808054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015611ad85780601f10611aad57610100808354040283529160200191611ad8565b820191906000526020600020905b815481529060010190602001808311611abb57829003601f168201915b505050505090509650965096509650965096509650919395979092949650565b606080600080600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054604051908082528060200260200182016040528015611b6c5781602001602082028038833980820191505090505b50925060009150600090505b600180549050811015611ca2573373ffffffffffffffffffffffffffffffffffffffff16600182815481101515611bab57fe5b906000526020600020906007020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161480611c6a57503373ffffffffffffffffffffffffffffffffffffffff16600182815481101515611c2057fe5b906000526020600020906007020160010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16145b15611c9557808383815181101515611c7e57fe5b906020019060200201818152505081806001019250505b8080600101915050611b78565b82935050505090565b600182815481101515611cba57fe5b906000526020600020906007020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515611db4576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260238152602001807f6f6e6c792062757965722063616e20726571756573742041726269747261746981526020017f6f6e21000000000000000000000000000000000000000000000000000000000081525060400191505060405180910390fd5b600182815481101515611dc357fe5b906000526020600020906007020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16636cd2c922600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16600186815481101515611e7b57fe5b9060005260206000209060070201600201546040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050602060405180830381600087803b158015611f1257600080fd5b505af1158015611f26573d6000803e3d6000fd5b505050506040513d6020811015611f3c57600080fd5b810190808051906020019092919050505073ffffffffffffffffffffffffffffffffffffffff16141515611fd8576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601b8152602001807f70657420646f6573206e6f742062656c6f6e6720746f20796f7521000000000081525060200191505060405180910390fd5b6000600183815481101515611fe957fe5b906000526020600020906007020160040154141515612096576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260338152602001807f6265696e672061726269747261746564206f72206172626974726174696f6e2081526020017f68617665206265656e2070726f6365737365640000000000000000000000000081525060400191505060405180910390fd5b806001838154811015156120a657fe5b906000526020600020906007020160060190805190602001906120ca929190612106565b50600180838154811015156120db57fe5b9060005260206000209060070201600401819055506004600081548092919060010191905055505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061214757805160ff1916838001178555612175565b82800160010185558215612175579182015b82811115612174578251825591602001919060010190612159565b5b5090506121829190612206565b5090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106121c757805160ff19168380011785556121f5565b828001600101855582156121f5579182015b828111156121f45782518255916020019190600101906121d9565b5b5090506122029190612206565b5090565b61222891905b8082111561222457600081600090555060010161220c565b5090565b905600a165627a7a723058208dfe4b40d5cba6f4cffcfa88808a2f1973f8fcd7dedb80116c679854e44c53a40029";

    public static final String ABI = "[{\"constant\":false,\"inputs\":[{\"name\":\"_recordId\",\"type\":\"uint256\"}],\"name\":\"approveArbitration\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"functionName\",\"type\":\"string\"},{\"name\":\"criticalSize\",\"type\":\"uint256\"}],\"name\":\"registerParallelFunction\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_petContract\",\"type\":\"address\"},{\"name\":\"_accountContract\",\"type\":\"address\"}],\"name\":\"setPetAndAccntContAddr\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"functionName\",\"type\":\"string\"}],\"name\":\"unregisterParallelFunction\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_recordId\",\"type\":\"uint256\"},{\"name\":\"_reason\",\"type\":\"string\"}],\"name\":\"denyArbitration\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_sender\",\"type\":\"address\"},{\"name\":\"_buyer\",\"type\":\"address\"},{\"name\":\"_seller\",\"type\":\"address\"},{\"name\":\"_price\",\"type\":\"uint32\"},{\"name\":\"_petId\",\"type\":\"uint256\"},{\"name\":\"_time\",\"type\":\"string\"}],\"name\":\"makePurchase\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[],\"name\":\"enableParallel\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getAllArbitrations\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256[]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getRecordCount\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[],\"name\":\"disableParallel\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_recordId\",\"type\":\"uint256\"}],\"name\":\"getRecordById\",\"outputs\":[{\"name\":\"buyer\",\"type\":\"address\"},{\"name\":\"seller\",\"type\":\"address\"},{\"name\":\"petId\",\"type\":\"uint256\"},{\"name\":\"price\",\"type\":\"uint256\"},{\"name\":\"status\",\"type\":\"uint256\"},{\"name\":\"time\",\"type\":\"string\"},{\"name\":\"reason\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getMyRecords\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256[]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_recordId\",\"type\":\"uint256\"},{\"name\":\"_reason\",\"type\":\"string\"}],\"name\":\"requestArbitration\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"inputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"}]";

    public static final String FUNC_APPROVEARBITRATION = "approveArbitration";

    public static final String FUNC_REGISTERPARALLELFUNCTION = "registerParallelFunction";

    public static final String FUNC_SETPETANDACCNTCONTADDR = "setPetAndAccntContAddr";

    public static final String FUNC_UNREGISTERPARALLELFUNCTION = "unregisterParallelFunction";

    public static final String FUNC_DENYARBITRATION = "denyArbitration";

    public static final String FUNC_MAKEPURCHASE = "makePurchase";

    public static final String FUNC_ENABLEPARALLEL = "enableParallel";

    public static final String FUNC_GETALLARBITRATIONS = "getAllArbitrations";

    public static final String FUNC_GETRECORDCOUNT = "getRecordCount";

    public static final String FUNC_DISABLEPARALLEL = "disableParallel";

    public static final String FUNC_GETRECORDBYID = "getRecordById";

    public static final String FUNC_GETMYRECORDS = "getMyRecords";

    public static final String FUNC_REQUESTARBITRATION = "requestArbitration";

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

    public String approveArbitrationSeq(BigInteger _recordId) {
        final Function function = new Function(
                FUNC_APPROVEARBITRATION, 
                Arrays.<Type>asList(new Uint256(_recordId)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<TransactionReceipt> registerParallelFunction(String functionName, BigInteger criticalSize) {
        final Function function = new Function(
                FUNC_REGISTERPARALLELFUNCTION, 
                Arrays.<Type>asList(new Utf8String(functionName),
                new Uint256(criticalSize)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void registerParallelFunction(String functionName, BigInteger criticalSize, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_REGISTERPARALLELFUNCTION, 
                Arrays.<Type>asList(new Utf8String(functionName),
                new Uint256(criticalSize)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String registerParallelFunctionSeq(String functionName, BigInteger criticalSize) {
        final Function function = new Function(
                FUNC_REGISTERPARALLELFUNCTION, 
                Arrays.<Type>asList(new Utf8String(functionName),
                new Uint256(criticalSize)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
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

    public String setPetAndAccntContAddrSeq(String _petContract, String _accountContract) {
        final Function function = new Function(
                FUNC_SETPETANDACCNTCONTADDR, 
                Arrays.<Type>asList(new Address(_petContract),
                new Address(_accountContract)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<TransactionReceipt> unregisterParallelFunction(String functionName) {
        final Function function = new Function(
                FUNC_UNREGISTERPARALLELFUNCTION, 
                Arrays.<Type>asList(new Utf8String(functionName)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void unregisterParallelFunction(String functionName, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_UNREGISTERPARALLELFUNCTION, 
                Arrays.<Type>asList(new Utf8String(functionName)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String unregisterParallelFunctionSeq(String functionName) {
        final Function function = new Function(
                FUNC_UNREGISTERPARALLELFUNCTION, 
                Arrays.<Type>asList(new Utf8String(functionName)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<TransactionReceipt> denyArbitration(BigInteger _recordId, String _reason) {
        final Function function = new Function(
                FUNC_DENYARBITRATION, 
                Arrays.<Type>asList(new Uint256(_recordId),
                new Utf8String(_reason)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void denyArbitration(BigInteger _recordId, String _reason, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_DENYARBITRATION, 
                Arrays.<Type>asList(new Uint256(_recordId),
                new Utf8String(_reason)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String denyArbitrationSeq(BigInteger _recordId, String _reason) {
        final Function function = new Function(
                FUNC_DENYARBITRATION, 
                Arrays.<Type>asList(new Uint256(_recordId),
                new Utf8String(_reason)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<TransactionReceipt> makePurchase(String _sender, String _buyer, String _seller, BigInteger _price, BigInteger _petId, String _time) {
        final Function function = new Function(
                FUNC_MAKEPURCHASE, 
                Arrays.<Type>asList(new Address(_sender),
                new Address(_buyer),
                new Address(_seller),
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint32(_price), 
                new Uint256(_petId),
                new Utf8String(_time)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void makePurchase(String _sender, String _buyer, String _seller, BigInteger _price, BigInteger _petId, String _time, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_MAKEPURCHASE, 
                Arrays.<Type>asList(new Address(_sender),
                new Address(_buyer),
                new Address(_seller),
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint32(_price), 
                new Uint256(_petId),
                new Utf8String(_time)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String makePurchaseSeq(String _sender, String _buyer, String _seller, BigInteger _price, BigInteger _petId, String _time) {
        final Function function = new Function(
                FUNC_MAKEPURCHASE, 
                Arrays.<Type>asList(new Address(_sender),
                new Address(_buyer),
                new Address(_seller),
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint32(_price), 
                new Uint256(_petId),
                new Utf8String(_time)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<TransactionReceipt> enableParallel() {
        final Function function = new Function(
                FUNC_ENABLEPARALLEL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void enableParallel(TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_ENABLEPARALLEL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String enableParallelSeq() {
        final Function function = new Function(
                FUNC_ENABLEPARALLEL, 
                Arrays.<Type>asList(), 
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

    public RemoteCall<TransactionReceipt> disableParallel() {
        final Function function = new Function(
                FUNC_DISABLEPARALLEL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void disableParallel(TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_DISABLEPARALLEL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String disableParallelSeq() {
        final Function function = new Function(
                FUNC_DISABLEPARALLEL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<Tuple7<String, String, BigInteger, BigInteger, BigInteger, String, String>> getRecordById(BigInteger _recordId) {
        final Function function = new Function(FUNC_GETRECORDBYID, 
                Arrays.<Type>asList(new Uint256(_recordId)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteCall<Tuple7<String, String, BigInteger, BigInteger, BigInteger, String, String>>(
                new Callable<Tuple7<String, String, BigInteger, BigInteger, BigInteger, String, String>>() {
                    @Override
                    public Tuple7<String, String, BigInteger, BigInteger, BigInteger, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple7<String, String, BigInteger, BigInteger, BigInteger, String, String>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (String) results.get(5).getValue(), 
                                (String) results.get(6).getValue());
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

    public RemoteCall<TransactionReceipt> requestArbitration(BigInteger _recordId, String _reason) {
        final Function function = new Function(
                FUNC_REQUESTARBITRATION, 
                Arrays.<Type>asList(new Uint256(_recordId),
                new Utf8String(_reason)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void requestArbitration(BigInteger _recordId, String _reason, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_REQUESTARBITRATION, 
                Arrays.<Type>asList(new Uint256(_recordId),
                new Utf8String(_reason)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String requestArbitrationSeq(BigInteger _recordId, String _reason) {
        final Function function = new Function(
                FUNC_REQUESTARBITRATION, 
                Arrays.<Type>asList(new Uint256(_recordId),
                new Utf8String(_reason)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
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
