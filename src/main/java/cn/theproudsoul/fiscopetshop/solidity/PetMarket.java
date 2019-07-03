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
    public static final String BINARY = "60806040526110066000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600060045534801561005757600080fd5b5033600560006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506122dc806100a86000396000f3006080604052600436106100e6576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806326225abf146100eb57806334a18dda146101585780633548d59c146101cb57806338cc483114610238578063546dbc711461028f57806358c395a3146102fb57806368651f601461033e57806379fa913f146103695780638f859878146103d257806397fd3a6414610455578063a36c730614610482578063a5f44cdb146104ee578063bca926af14610561578063cb92050914610578578063d39f70bc1461078f578063dee50c2c146107a6575b600080fd5b3480156100f757600080fd5b50610116600480360381019080803590602001909291905050506108ef565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561016457600080fd5b506101c9600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001909291905050506109f1565b005b3480156101d757600080fd5b50610236600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610b62565b005b34801561024457600080fd5b5061024d610d50565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561029b57600080fd5b506102a4610d58565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b838110156102e75780820151818401526020810190506102cc565b505050509050019250505060405180910390f35b34801561030757600080fd5b5061033c600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610e17565b005b34801561034a57600080fd5b50610353610f20565b6040518082815260200191505060405180910390f35b34801561037557600080fd5b506103d0600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610fef565b005b3480156103de57600080fd5b5061045360048036038101908080359060200190929190803563ffffffff169060200190929190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050611157565b005b34801561046157600080fd5b506104806004803603810190808035906020019092919050505061138e565b005b34801561048e57600080fd5b5061049761152a565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b838110156104da5780820151818401526020810190506104bf565b505050509050019250505060405180910390f35b3480156104fa57600080fd5b5061055f60048036038101908080359060200190929190803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919291929050505061165a565b005b34801561056d57600080fd5b506105766119eb565b005b34801561058457600080fd5b506105a360048036038101908080359060200190929190505050611ad4565b60405180881515151581526020018761ffff1661ffff1681526020018663ffffffff1663ffffffff16815260200180602001806020018060200180602001858103855289818151815260200191508051906020019080838360005b838110156106195780820151818401526020810190506105fe565b50505050905090810190601f1680156106465780820380516001836020036101000a031916815260200191505b50858103845288818151815260200191508051906020019080838360005b8381101561067f578082015181840152602081019050610664565b50505050905090810190601f1680156106ac5780820380516001836020036101000a031916815260200191505b50858103835287818151815260200191508051906020019080838360005b838110156106e55780820151818401526020810190506106ca565b50505050905090810190601f1680156107125780820380516001836020036101000a031916815260200191505b50858103825286818151815260200191508051906020019080838360005b8381101561074b578082015181840152602081019050610730565b50505050905090810190601f1680156107785780820380516001836020036101000a031916815260200191505b509b50505050505050505050505060405180910390f35b34801561079b57600080fd5b506107a4611e76565b005b3480156107b257600080fd5b506108ed600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803561ffff169060200190929190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050611f59565b005b6000600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156109b6576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f726571756972652061646d696e207065726d697373696f6e210000000000000081525060200191505060405180910390fd5b6002600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050919050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16630553904e3084846040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200180602001838152602001828103825284818151815260200191508051906020019080838360005b83811015610ad4578082015181840152602081019050610ab9565b50505050905090810190601f168015610b015780820380516001836020036101000a031916815260200191505b50945050505050602060405180830381600087803b158015610b2257600080fd5b505af1158015610b36573d6000803e3d6000fd5b505050506040513d6020811015610b4c57600080fd5b8101908080519060200190929190505050505050565b600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff16141515610c27576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f726571756972652061646d696e207065726d697373696f6e210000000000000081525060200191505060405180910390fd5b600360006002600085815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000815480929190600190039190505550600360008273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008154809291906001019190505550806002600084815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550505050565b600033905090565b606080600080600454604051908082528060200260200182016040528015610d8f5781602001602082028038833980820191505090505b50925060009150600090505b600180549050811015610e0e57600181815481101515610db757fe5b906000526020600020906006020160000160009054906101000a900460ff1615610e0157808383815181101515610dea57fe5b906020019060200201818152505081806001019250505b8080600101915050610d9b565b82935050505090565b600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610edc576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f726571756972652061646d696e207065726d697373696f6e210000000000000081525060200191505060405180910390fd5b80600660006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b6000600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610fe7576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f726571756972652061646d696e207065726d697373696f6e210000000000000081525060200191505060405180910390fd5b600454905090565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166311e3f2af30836040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200180602001828103825283818151815260200191508051906020019080838360005b838110156110cb5780820151818401526020810190506110b0565b50505050905090810190601f1680156110f85780820380516001836020036101000a031916815260200191505b509350505050602060405180830381600087803b15801561111857600080fd5b505af115801561112c573d6000803e3d6000fd5b505050506040513d602081101561114257600080fd5b81019080805190602001909291905050505050565b3373ffffffffffffffffffffffffffffffffffffffff16611177846108ef565b73ffffffffffffffffffffffffffffffffffffffff16141515611202576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601d8152602001807f7265717569726520706574206f776e6572207065726d697373696f6e2100000081525060200191505060405180910390fd5b60018381548110151561121157fe5b906000526020600020906006020160000160009054906101000a900460ff161515156112cb576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252602b8152602001807f70657420697320666f722073616c652120706c6561736520707574206f66662081526020017f73616c652066697273742e00000000000000000000000000000000000000000081525060400191505060405180910390fd5b816001848154811015156112db57fe5b906000526020600020906006020160000160036101000a81548163ffffffff021916908363ffffffff1602179055506001808481548110151561131a57fe5b906000526020600020906006020160000160006101000a81548160ff0219169083151502179055508060018481548110151561135257fe5b9060005260206000209060060201600501908051906020019061137692919061218b565b50600460008154809291906001019190505550505050565b3373ffffffffffffffffffffffffffffffffffffffff166113ae826108ef565b73ffffffffffffffffffffffffffffffffffffffff16141515611439576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601d8152602001807f7265717569726520706574206f776e6572207065726d697373696f6e2100000081525060200191505060405180910390fd5b60018181548110151561144857fe5b906000526020600020906006020160000160009054906101000a900460ff1615156114db576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260158152602001807f706574206e6f7420666f722073616c65206e6f7721000000000000000000000081525060200191505060405180910390fd5b60006001828154811015156114ec57fe5b906000526020600020906006020160000160006101000a81548160ff0219169083151502179055506004600081548092919060019003919050555050565b606080600080600360003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205460405190808252806020026020018201604052801561159e5781602001602082028038833980820191505090505b50925060009150600090505b600180549050811015611651573373ffffffffffffffffffffffffffffffffffffffff166002600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614156116445780838381518110151561162d57fe5b906020019060200201818152505081806001019250505b80806001019150506115aa565b82935050505090565b6000803391506002600085815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050600660009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663e408ada1600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16848460018981548110151561170857fe5b906000526020600020906006020160000160039054906101000a900463ffffffff1689896040518763ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018463ffffffff16815260200183815260200180602001828103825283818151815260200191508051906020019080838360005b8381101561183f578082015181840152602081019050611824565b50505050905090810190601f16801561186c5780820380516001836020036101000a031916815260200191505b50975050505050505050600060405180830381600087803b15801561189057600080fd5b505af11580156118a4573d6000803e3d6000fd5b50505050816002600086815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600360008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008154809291906001019190505550600360008273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600081548092919060019003919050555060006001858154811015156119aa57fe5b906000526020600020906006020160000160006101000a81548160ff0219169083151502179055506004600081548092919060019003919050555050505050565b611a2b6040805190810160405280601f81526020017f73656c6c5065742875696e743235362c75696e743235362c737472696e67290081525060016109f1565b611a6b6040805190810160405280601081526020017f6f666653616c652875696e74323536290000000000000000000000000000000081525060016109f1565b611ad2606060405190810160405280602881526020017f6368616e67654f776e6572736869702875696e743235362c616464726573732c81526020017f616464726573732900000000000000000000000000000000000000000000000081525060026109f1565b565b6000806000606080606080600188815481101515611aee57fe5b906000526020600020906006020160000160009054906101000a900460ff16600189815481101515611b1c57fe5b906000526020600020906006020160000160019054906101000a900461ffff1660018a815481101515611b4b57fe5b906000526020600020906006020160000160039054906101000a900463ffffffff1660018b815481101515611b7c57fe5b906000526020600020906006020160010160018c815481101515611b9c57fe5b906000526020600020906006020160020160018d815481101515611bbc57fe5b906000526020600020906006020160030160018e815481101515611bdc57fe5b9060005260206000209060060201600501838054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015611c825780601f10611c5757610100808354040283529160200191611c82565b820191906000526020600020905b815481529060010190602001808311611c6557829003601f168201915b50505050509350828054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015611d1e5780601f10611cf357610100808354040283529160200191611d1e565b820191906000526020600020905b815481529060010190602001808311611d0157829003601f168201915b50505050509250818054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015611dba5780601f10611d8f57610100808354040283529160200191611dba565b820191906000526020600020905b815481529060010190602001808311611d9d57829003601f168201915b50505050509150808054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015611e565780601f10611e2b57610100808354040283529160200191611e56565b820191906000526020600020905b815481529060010190602001808311611e3957829003601f168201915b505050505090509650965096509650965096509650919395979092949650565b611eb46040805190810160405280601f81526020017f73656c6c5065742875696e743235362c75696e743235362c737472696e672900815250610fef565b611ef26040805190810160405280601081526020017f6f666653616c652875696e743235362900000000000000000000000000000000815250610fef565b611f57606060405190810160405280602881526020017f6368616e67654f776e6572736869702875696e743235362c616464726573732c81526020017f6164647265737329000000000000000000000000000000000000000000000000815250610fef565b565b6000600180610100604051908101604052806000151581526020018861ffff168152602001600063ffffffff16815260200189815260200187815260200186815260200185815260200160206040519081016040528060008152508152509080600181540180825580915050906001820390600052602060002090600602016000909192909190915060008201518160000160006101000a81548160ff02191690831515021790555060208201518160000160016101000a81548161ffff021916908361ffff16021790555060408201518160000160036101000a81548163ffffffff021916908363ffffffff160217905550606082015181600101908051906020019061206892919061220b565b50608082015181600201908051906020019061208592919061220b565b5060a08201518160030190805190602001906120a292919061220b565b5060c08201518160040190805190602001906120bf92919061220b565b5060e08201518160050190805190602001906120dc92919061220b565b505050039050336002600083815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600360003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008154809291906001019190505550505050505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106121cc57805160ff19168380011785556121fa565b828001600101855582156121fa579182015b828111156121f95782518255916020019190600101906121de565b5b509050612207919061228b565b5090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061224c57805160ff191683800117855561227a565b8280016001018555821561227a579182015b8281111561227957825182559160200191906001019061225e565b5b509050612287919061228b565b5090565b6122ad91905b808211156122a9576000816000905550600101612291565b5090565b905600a165627a7a72305820dfb00f5b048aa491e798daac26feb53ce668f0267a35b8c4d110956c72223a190029";

    public static final String ABI = "[{\"constant\":true,\"inputs\":[{\"name\":\"_petId\",\"type\":\"uint256\"}],\"name\":\"petOwner\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"functionName\",\"type\":\"string\"},{\"name\":\"criticalSize\",\"type\":\"uint256\"}],\"name\":\"registerParallelFunction\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_sender\",\"type\":\"address\"},{\"name\":\"_petId\",\"type\":\"uint256\"},{\"name\":\"_newOwner\",\"type\":\"address\"}],\"name\":\"changeOwnership\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getAddress\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getPetsForSale\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256[]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_transactionContract\",\"type\":\"address\"}],\"name\":\"setTranContAddr\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getSalingPetCounts\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"functionName\",\"type\":\"string\"}],\"name\":\"unregisterParallelFunction\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_petId\",\"type\":\"uint256\"},{\"name\":\"_price\",\"type\":\"uint32\"},{\"name\":\"_time\",\"type\":\"string\"}],\"name\":\"sellPet\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_petId\",\"type\":\"uint256\"}],\"name\":\"offSale\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getMyPets\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256[]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_petId\",\"type\":\"uint256\"},{\"name\":\"_time\",\"type\":\"string\"}],\"name\":\"buyPet\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[],\"name\":\"enableParallel\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_petId\",\"type\":\"uint256\"}],\"name\":\"getPetById\",\"outputs\":[{\"name\":\"selling\",\"type\":\"bool\"},{\"name\":\"species\",\"type\":\"uint16\"},{\"name\":\"price\",\"type\":\"uint32\"},{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"bday\",\"type\":\"string\"},{\"name\":\"disc\",\"type\":\"string\"},{\"name\":\"time\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[],\"name\":\"disableParallel\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_name\",\"type\":\"string\"},{\"name\":\"_species\",\"type\":\"uint16\"},{\"name\":\"_bday\",\"type\":\"string\"},{\"name\":\"_disc\",\"type\":\"string\"},{\"name\":\"_picUrl\",\"type\":\"string\"}],\"name\":\"newPet\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"inputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"}]";

    public static final String FUNC_PETOWNER = "petOwner";

    public static final String FUNC_REGISTERPARALLELFUNCTION = "registerParallelFunction";

    public static final String FUNC_CHANGEOWNERSHIP = "changeOwnership";

    public static final String FUNC_GETADDRESS = "getAddress";

    public static final String FUNC_GETPETSFORSALE = "getPetsForSale";

    public static final String FUNC_SETTRANCONTADDR = "setTranContAddr";

    public static final String FUNC_GETSALINGPETCOUNTS = "getSalingPetCounts";

    public static final String FUNC_UNREGISTERPARALLELFUNCTION = "unregisterParallelFunction";

    public static final String FUNC_SELLPET = "sellPet";

    public static final String FUNC_OFFSALE = "offSale";

    public static final String FUNC_GETMYPETS = "getMyPets";

    public static final String FUNC_BUYPET = "buyPet";

    public static final String FUNC_ENABLEPARALLEL = "enableParallel";

    public static final String FUNC_GETPETBYID = "getPetById";

    public static final String FUNC_DISABLEPARALLEL = "disableParallel";

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

    public RemoteCall<String> petOwner(BigInteger _petId) {
        final Function function = new Function(FUNC_PETOWNER, 
                Arrays.<Type>asList(new Uint256(_petId)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
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

    public String changeOwnershipSeq(String _sender, BigInteger _petId, String _newOwner) {
        final Function function = new Function(
                FUNC_CHANGEOWNERSHIP, 
                Arrays.<Type>asList(new Address(_sender),
                new Uint256(_petId),
                new Address(_newOwner)),
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

    public String setTranContAddrSeq(String _transactionContract) {
        final Function function = new Function(
                FUNC_SETTRANCONTADDR, 
                Arrays.<Type>asList(new Address(_transactionContract)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<BigInteger> getSalingPetCounts() {
        final Function function = new Function(FUNC_GETSALINGPETCOUNTS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
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

    public RemoteCall<TransactionReceipt> sellPet(BigInteger _petId, BigInteger _price, String _time) {
        final Function function = new Function(
                FUNC_SELLPET, 
                Arrays.<Type>asList(new Uint256(_petId),
                new Uint32(_price),
                new Utf8String(_time)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void sellPet(BigInteger _petId, BigInteger _price, String _time, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SELLPET, 
                Arrays.<Type>asList(new Uint256(_petId),
                new Uint32(_price),
                new Utf8String(_time)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String sellPetSeq(BigInteger _petId, BigInteger _price, String _time) {
        final Function function = new Function(
                FUNC_SELLPET, 
                Arrays.<Type>asList(new Uint256(_petId),
                new Uint32(_price),
                new Utf8String(_time)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
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

    public String offSaleSeq(BigInteger _petId) {
        final Function function = new Function(
                FUNC_OFFSALE, 
                Arrays.<Type>asList(new Uint256(_petId)),
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
                Arrays.<Type>asList(new Uint256(_petId),
                new Utf8String(_time)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void buyPet(BigInteger _petId, String _time, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_BUYPET, 
                Arrays.<Type>asList(new Uint256(_petId),
                new Utf8String(_time)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String buyPetSeq(BigInteger _petId, String _time) {
        final Function function = new Function(
                FUNC_BUYPET, 
                Arrays.<Type>asList(new Uint256(_petId),
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

    public String newPetSeq(String _name, BigInteger _species, String _bday, String _disc, String _picUrl) {
        final Function function = new Function(
                FUNC_NEWPET, 
                Arrays.<Type>asList(new Utf8String(_name),
                new Uint16(_species),
                new Utf8String(_bday),
                new Utf8String(_disc),
                new Utf8String(_picUrl)),
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
