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
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple4;
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
public class PetMarket extends Contract {
    public static final String BINARY = "60806040526110066000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555034801561005257600080fd5b5033600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506129fb806100a36000396000f300608060405260043610610107576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680632c71facf1461010c57806334a18dda1461023f57806338cc4831146102b2578063546dbc711461030957806358c395a31461037557806365d020d5146103b85780636cd2c9221461048157806379fa913f1461050e5780638620cc101461057757806397fd3a6414610761578063a36c73061461078e578063a5b668dc146107fa578063a5f44cdb14610867578063bca926af146108da578063bd06b552146108f1578063c1986bf014610948578063cd619f5814610973578063d39f70bc1461099e578063dee50c2c146109b5575b600080fd5b34801561011857600080fd5b5061013760048036038101908080359060200190929190505050610afe565b60405180861515151581526020018561ffff1661ffff1681526020018481526020018060200180602001838103835285818151815260200191508051906020019080838360005b8381101561019957808201518184015260208101905061017e565b50505050905090810190601f1680156101c65780820380516001836020036101000a031916815260200191505b50838103825284818151815260200191508051906020019080838360005b838110156101ff5780820151818401526020810190506101e4565b50505050905090810190601f16801561022c5780820380516001836020036101000a031916815260200191505b5097505050505050505060405180910390f35b34801561024b57600080fd5b506102b0600480360381019080803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919291929080359060200190929190505050610e8b565b005b3480156102be57600080fd5b506102c7610ffc565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561031557600080fd5b5061031e611004565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b83811015610361578082015181840152602081019050610346565b505050509050019250505060405180910390f35b34801561038157600080fd5b506103b6600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506110c8565b005b3480156103c457600080fd5b5061047f60048036038101908080359060200190929190803563ffffffff169060200190929190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091929192905050506111d1565b005b34801561048d57600080fd5b506104cc600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050611457565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561051a57600080fd5b50610575600480360381019080803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919291929050505061155a565b005b34801561058357600080fd5b506105a2600480360381019080803590602001909291905050506116c2565b6040518080602001806020018060200180602001858103855289818151815260200191508051906020019080838360005b838110156105ee5780820151818401526020810190506105d3565b50505050905090810190601f16801561061b5780820380516001836020036101000a031916815260200191505b50858103845288818151815260200191508051906020019080838360005b83811015610654578082015181840152602081019050610639565b50505050905090810190601f1680156106815780820380516001836020036101000a031916815260200191505b50858103835287818151815260200191508051906020019080838360005b838110156106ba57808201518184015260208101905061069f565b50505050905090810190601f1680156106e75780820380516001836020036101000a031916815260200191505b50858103825286818151815260200191508051906020019080838360005b83811015610720578082015181840152602081019050610705565b50505050905090810190601f16801561074d5780820380516001836020036101000a031916815260200191505b509850505050505050505060405180910390f35b34801561076d57600080fd5b5061078c60048036038101908080359060200190929190505050611b2a565b005b34801561079a57600080fd5b506107a3611da1565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b838110156107e65780820151818401526020810190506107cb565b505050509050019250505060405180910390f35b34801561080657600080fd5b5061086560048036038101908080359060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611e9a565b005b34801561087357600080fd5b506108d860048036038101908080359060200190929190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050611fb6565b005b3480156108e657600080fd5b506108ef61229b565b005b3480156108fd57600080fd5b50610932600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506123ab565b6040518082815260200191505060405180910390f35b34801561095457600080fd5b5061095d61244c565b6040518082815260200191505060405180910390f35b34801561097f57600080fd5b506109886124b7565b6040518082815260200191505060405180910390f35b3480156109aa57600080fd5b506109b3612589565b005b3480156109c157600080fd5b50610afc600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803561ffff169060200190929190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050612693565b005b6000806000606080600186815481101515610b1557fe5b906000526020600020906007020160000160009054906101000a900460ff1680610b9d57506002600087815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b80610bf55750600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b1515610c69576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601d8152602001807f6e6f206f776e6572206f722061646d696e207065726d697373696f6e2100000081525060200191505060405180910390fd5b600186815481101515610c7857fe5b906000526020600020906007020160000160009054906101000a900460ff16600187815481101515610ca657fe5b906000526020600020906007020160000160019054906101000a900461ffff16600188815481101515610cd557fe5b906000526020600020906007020160000160039054906101000a900463ffffffff16600189815481101515610d0657fe5b906000526020600020906007020160010160018a815481101515610d2657fe5b90600052602060002090600702016002018263ffffffff169250818054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610dd55780601f10610daa57610100808354040283529160200191610dd5565b820191906000526020600020905b815481529060010190602001808311610db857829003601f168201915b50505050509150808054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610e715780601f10610e4657610100808354040283529160200191610e71565b820191906000526020600020905b815481529060010190602001808311610e5457829003601f168201915b505050505090509450945094509450945091939590929450565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16630553904e3084846040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200180602001838152602001828103825284818151815260200191508051906020019080838360005b83811015610f6e578082015181840152602081019050610f53565b50505050905090810190601f168015610f9b5780820380516001836020036101000a031916815260200191505b50945050505050602060405180830381600087803b158015610fbc57600080fd5b505af1158015610fd0573d6000803e3d6000fd5b505050506040513d6020811015610fe657600080fd5b8101908080519060200190929190505050505050565b600033905090565b60608060008061101261244c565b6040519080825280602002602001820160405280156110405781602001602082028038833980820191505090505b50925060009150600090505b6001805490508110156110bf5760018181548110151561106857fe5b906000526020600020906007020160000160009054906101000a900460ff16156110b25780838381518110151561109b57fe5b906020019060200201818152505081806001019250505b808060010191505061104c565b82935050505090565b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561118d576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f726571756972652061646d696e207065726d697373696f6e210000000000000081525060200191505060405180910390fd5b80600460006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b3373ffffffffffffffffffffffffffffffffffffffff166002600086815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415156112a7576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601d8152602001807f7265717569726520706574206f776e6572207065726d697373696f6e2100000081525060200191505060405180910390fd5b6001848154811015156112b657fe5b906000526020600020906007020160000160009054906101000a900460ff16151515611370576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252602b8152602001807f70657420697320666f722073616c652120706c6561736520707574206f66662081526020017f73616c652066697273742e00000000000000000000000000000000000000000081525060400191505060405180910390fd5b8260018581548110151561138057fe5b906000526020600020906007020160000160036101000a81548163ffffffff021916908363ffffffff160217905550600180858154811015156113bf57fe5b906000526020600020906007020160000160006101000a81548160ff021916908315150217905550816001858154811015156113f757fe5b9060005260206000209060070201600501908051906020019061141b9291906128aa565b508060018581548110151561142c57fe5b906000526020600020906007020160060190805190602001906114509291906128aa565b5050505050565b6000600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff1614151561151e576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f726571756972652061646d696e207065726d697373696f6e210000000000000081525060200191505060405180910390fd5b6002600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905092915050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166311e3f2af30836040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200180602001828103825283818151815260200191508051906020019080838360005b8381101561163657808201518184015260208101905061161b565b50505050905090810190601f1680156116635780820380516001836020036101000a031916815260200191505b509350505050602060405180830381600087803b15801561168357600080fd5b505af1158015611697573d6000803e3d6000fd5b505050506040513d60208110156116ad57600080fd5b81019080805190602001909291905050505050565b6060806060806001858154811015156116d757fe5b906000526020600020906007020160000160009054906101000a900460ff168061175f57506002600086815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b806117b75750600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b151561182b576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601d8152602001807f6e6f206f776e6572206f722061646d696e207065726d697373696f6e2100000081525060200191505060405180910390fd5b60018581548110151561183a57fe5b906000526020600020906007020160030160018681548110151561185a57fe5b906000526020600020906007020160040160018781548110151561187a57fe5b906000526020600020906007020160050160018881548110151561189a57fe5b9060005260206000209060070201600601838054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156119405780601f1061191557610100808354040283529160200191611940565b820191906000526020600020905b81548152906001019060200180831161192357829003601f168201915b50505050509350828054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156119dc5780601f106119b1576101008083540402835291602001916119dc565b820191906000526020600020905b8154815290600101906020018083116119bf57829003601f168201915b50505050509250818054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015611a785780601f10611a4d57610100808354040283529160200191611a78565b820191906000526020600020905b815481529060010190602001808311611a5b57829003601f168201915b50505050509150808054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015611b145780601f10611ae957610100808354040283529160200191611b14565b820191906000526020600020905b815481529060010190602001808311611af757829003601f168201915b5050505050905093509350935093509193509193565b3373ffffffffffffffffffffffffffffffffffffffff166002600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161480611be45750600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b1515611c7e576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260268152602001807f7265717569726520706574206f776e6572206f722061646d696e207065726d6981526020017f7373696f6e21000000000000000000000000000000000000000000000000000081525060400191505060405180910390fd5b600181815481101515611c8d57fe5b906000526020600020906007020160000160009054906101000a900460ff161515611d20576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260158152602001807f706574206e6f7420666f722073616c65206e6f7721000000000000000000000081525060200191505060405180910390fd5b6000600182815481101515611d3157fe5b906000526020600020906007020160000160006101000a81548160ff0219169083151502179055506020604051908101604052806000815250600182815481101515611d7957fe5b90600052602060002090600702016006019080519060200190611d9d9291906128aa565b5050565b606080600080611db0336123ab565b604051908082528060200260200182016040528015611dde5781602001602082028038833980820191505090505b50925060009150600090505b600180549050811015611e91573373ffffffffffffffffffffffffffffffffffffffff166002600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415611e8457808383815181101515611e6d57fe5b906020019060200201818152505081806001019250505b8080600101915050611dea565b82935050505090565b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff16141515611f5f576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f726571756972652061646d696e207065726d697373696f6e210000000000000081525060200191505060405180910390fd5b806002600085815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550505050565b6000803391506002600085815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16639b01a452600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16848460018981548110151561206457fe5b906000526020600020906007020160000160039054906101000a900463ffffffff1689896040518763ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018463ffffffff1663ffffffff16815260200183815260200180602001828103825283818151815260200191508051906020019080838360005b838110156121a1578082015181840152602081019050612186565b50505050905090810190601f1680156121ce5780820380516001836020036101000a031916815260200191505b50975050505050505050600060405180830381600087803b1580156121f257600080fd5b505af1158015612206573d6000803e3d6000fd5b50505050816002600086815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600060018581548110151561226d57fe5b906000526020600020906007020160000160006101000a81548160ff02191690831515021790555050505050565b612302606060405190810160405280602681526020017f73656c6c5065742875696e743235362c75696e743235362c737472696e672c7381526020017f7472696e672900000000000000000000000000000000000000000000000000008152506001610e8b565b6123426040805190810160405280601081526020017f6f666653616c652875696e7432353629000000000000000000000000000000008152506001610e8b565b6123a9606060405190810160405280602881526020017f6368616e67654f776e6572736869702875696e743235362c616464726573732c81526020017f61646472657373290000000000000000000000000000000000000000000000008152506002610e8b565b565b6000806000809150600090505b600180549050811015612442578373ffffffffffffffffffffffffffffffffffffffff166002600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614156124355781806001019250505b80806001019150506123b8565b8192505050919050565b6000806000809150600090505b6001805490508110156124af5760018181548110151561247557fe5b906000526020600020906007020160000160009054906101000a900460ff16156124a25781806001019250505b8080600101915050612459565b819250505090565b6000600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561257e576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260188152602001807f726571756972652061646d696e207065726d697373696f6e000000000000000081525060200191505060405180910390fd5b600180549050905090565b6125ee606060405190810160405280602681526020017f73656c6c5065742875696e743235362c75696e743235362c737472696e672c7381526020017f7472696e6729000000000000000000000000000000000000000000000000000081525061155a565b61262c6040805190810160405280601081526020017f6f666653616c652875696e74323536290000000000000000000000000000000081525061155a565b612691606060405190810160405280602881526020017f6368616e67654f776e6572736869702875696e743235362c616464726573732c81526020017f616464726573732900000000000000000000000000000000000000000000000081525061155a565b565b6000600180610120604051908101604052806000151581526020018861ffff168152602001600063ffffffff1681526020018981526020018781526020018681526020018581526020016020604051908101604052806000815250815260200160206040519081016040528060008152508152509080600181540180825580915050906001820390600052602060002090600702016000909192909190915060008201518160000160006101000a81548160ff02191690831515021790555060208201518160000160016101000a81548161ffff021916908361ffff16021790555060408201518160000160036101000a81548163ffffffff021916908363ffffffff16021790555060608201518160010190805190602001906127b892919061292a565b5060808201518160020190805190602001906127d592919061292a565b5060a08201518160030190805190602001906127f292919061292a565b5060c082015181600401908051906020019061280f92919061292a565b5060e082015181600501908051906020019061282c92919061292a565b5061010082015181600601908051906020019061284a92919061292a565b505050039050336002600083815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550505050505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106128eb57805160ff1916838001178555612919565b82800160010185558215612919579182015b828111156129185782518255916020019190600101906128fd565b5b50905061292691906129aa565b5090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061296b57805160ff1916838001178555612999565b82800160010185558215612999579182015b8281111561299857825182559160200191906001019061297d565b5b5090506129a691906129aa565b5090565b6129cc91905b808211156129c85760008160009055506001016129b0565b5090565b905600a165627a7a7230582043eea38ab16813a3d2890a7ff7104069a9fc31cd696773bdc4bc8df66f9c142b0029";

    public static final String ABI = "[{\"constant\":true,\"inputs\":[{\"name\":\"_petId\",\"type\":\"uint256\"}],\"name\":\"getPetById1\",\"outputs\":[{\"name\":\"selling\",\"type\":\"bool\"},{\"name\":\"species\",\"type\":\"uint16\"},{\"name\":\"price\",\"type\":\"uint256\"},{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"bday\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"functionName\",\"type\":\"string\"},{\"name\":\"criticalSize\",\"type\":\"uint256\"}],\"name\":\"registerParallelFunction\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getAddress\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getPetsForSale\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256[]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_transactionContract\",\"type\":\"address\"}],\"name\":\"setTranContAddr\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_petId\",\"type\":\"uint256\"},{\"name\":\"_price\",\"type\":\"uint32\"},{\"name\":\"_time\",\"type\":\"string\"},{\"name\":\"_remark\",\"type\":\"string\"}],\"name\":\"sellPet\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_sender\",\"type\":\"address\"},{\"name\":\"_petId\",\"type\":\"uint256\"}],\"name\":\"petOwner\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"functionName\",\"type\":\"string\"}],\"name\":\"unregisterParallelFunction\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_petId\",\"type\":\"uint256\"}],\"name\":\"getPetById2\",\"outputs\":[{\"name\":\"disc\",\"type\":\"string\"},{\"name\":\"picUrl\",\"type\":\"string\"},{\"name\":\"time\",\"type\":\"string\"},{\"name\":\"remark\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_petId\",\"type\":\"uint256\"}],\"name\":\"offSale\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getMyPets\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256[]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_petId\",\"type\":\"uint256\"},{\"name\":\"_sender\",\"type\":\"address\"},{\"name\":\"_newOwner\",\"type\":\"address\"}],\"name\":\"changeOwnership\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_petId\",\"type\":\"uint256\"},{\"name\":\"_time\",\"type\":\"string\"}],\"name\":\"buyPet\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[],\"name\":\"enableParallel\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_owner\",\"type\":\"address\"}],\"name\":\"ownerPetCount\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"sellingPetCount\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"petCount\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[],\"name\":\"disableParallel\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_name\",\"type\":\"string\"},{\"name\":\"_species\",\"type\":\"uint16\"},{\"name\":\"_bday\",\"type\":\"string\"},{\"name\":\"_disc\",\"type\":\"string\"},{\"name\":\"_picUrl\",\"type\":\"string\"}],\"name\":\"newPet\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"inputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"}]";

    public static final String FUNC_GETPETBYID1 = "getPetById1";

    public static final String FUNC_REGISTERPARALLELFUNCTION = "registerParallelFunction";

    public static final String FUNC_GETADDRESS = "getAddress";

    public static final String FUNC_GETPETSFORSALE = "getPetsForSale";

    public static final String FUNC_SETTRANCONTADDR = "setTranContAddr";

    public static final String FUNC_SELLPET = "sellPet";

    public static final String FUNC_PETOWNER = "petOwner";

    public static final String FUNC_UNREGISTERPARALLELFUNCTION = "unregisterParallelFunction";

    public static final String FUNC_GETPETBYID2 = "getPetById2";

    public static final String FUNC_OFFSALE = "offSale";

    public static final String FUNC_GETMYPETS = "getMyPets";

    public static final String FUNC_CHANGEOWNERSHIP = "changeOwnership";

    public static final String FUNC_BUYPET = "buyPet";

    public static final String FUNC_ENABLEPARALLEL = "enableParallel";

    public static final String FUNC_OWNERPETCOUNT = "ownerPetCount";

    public static final String FUNC_SELLINGPETCOUNT = "sellingPetCount";

    public static final String FUNC_PETCOUNT = "petCount";

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

    public RemoteCall<Tuple5<Boolean, BigInteger, BigInteger, String, String>> getPetById1(BigInteger _petId) {
        final Function function = new Function(FUNC_GETPETBYID1, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_petId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Uint16>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteCall<Tuple5<Boolean, BigInteger, BigInteger, String, String>>(
                new Callable<Tuple5<Boolean, BigInteger, BigInteger, String, String>>() {
                    @Override
                    public Tuple5<Boolean, BigInteger, BigInteger, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<Boolean, BigInteger, BigInteger, String, String>(
                                (Boolean) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (String) results.get(4).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> registerParallelFunction(String functionName, BigInteger criticalSize) {
        final Function function = new Function(
                FUNC_REGISTERPARALLELFUNCTION, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(functionName), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(criticalSize)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void registerParallelFunction(String functionName, BigInteger criticalSize, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_REGISTERPARALLELFUNCTION, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(functionName), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(criticalSize)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String registerParallelFunctionSeq(String functionName, BigInteger criticalSize) {
        final Function function = new Function(
                FUNC_REGISTERPARALLELFUNCTION, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(functionName), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(criticalSize)), 
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

    public RemoteCall<TransactionReceipt> sellPet(BigInteger _petId, BigInteger _price, String _time, String _remark) {
        final Function function = new Function(
                FUNC_SELLPET, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_petId), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint32(_price), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_time), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_remark)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void sellPet(BigInteger _petId, BigInteger _price, String _time, String _remark, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SELLPET, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_petId), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint32(_price), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_time), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_remark)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String sellPetSeq(BigInteger _petId, BigInteger _price, String _time, String _remark) {
        final Function function = new Function(
                FUNC_SELLPET, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_petId), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint32(_price), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_time), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_remark)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<String> petOwner(String _sender, BigInteger _petId) {
        final Function function = new Function(FUNC_PETOWNER, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_sender), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_petId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> unregisterParallelFunction(String functionName) {
        final Function function = new Function(
                FUNC_UNREGISTERPARALLELFUNCTION, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(functionName)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void unregisterParallelFunction(String functionName, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_UNREGISTERPARALLELFUNCTION, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(functionName)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String unregisterParallelFunctionSeq(String functionName) {
        final Function function = new Function(
                FUNC_UNREGISTERPARALLELFUNCTION, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(functionName)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<Tuple4<String, String, String, String>> getPetById2(BigInteger _petId) {
        final Function function = new Function(FUNC_GETPETBYID2, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_petId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteCall<Tuple4<String, String, String, String>>(
                new Callable<Tuple4<String, String, String, String>>() {
                    @Override
                    public Tuple4<String, String, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<String, String, String, String>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue());
                    }
                });
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

    public RemoteCall<TransactionReceipt> changeOwnership(BigInteger _petId, String _sender, String _newOwner) {
        final Function function = new Function(
                FUNC_CHANGEOWNERSHIP, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_petId), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(_sender), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(_newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void changeOwnership(BigInteger _petId, String _sender, String _newOwner, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_CHANGEOWNERSHIP, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_petId), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(_sender), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(_newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String changeOwnershipSeq(BigInteger _petId, String _sender, String _newOwner) {
        final Function function = new Function(
                FUNC_CHANGEOWNERSHIP, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_petId), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(_sender), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(_newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
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

    public RemoteCall<BigInteger> ownerPetCount(String _owner) {
        final Function function = new Function(FUNC_OWNERPETCOUNT, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_owner)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> sellingPetCount() {
        final Function function = new Function(FUNC_SELLINGPETCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> petCount() {
        final Function function = new Function(FUNC_PETCOUNT, 
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
