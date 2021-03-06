# PetStore-Server

> 区块链实训大作业后台系统

## 设计内容

设计一个宠物售卖和转卖分布式市场

分布式市场可包含以下角色和功能：

- 出售人：将宠物上架、制定价格、售卖成功则收款。
- 购买人：选择宠物、进行购买。
- 宠物：ID、名称、品类（猫、狗、兔、恐龙等）、出生日期、价格、描述（一段文字供展示）等、有效状态、图片所在url等扩展信息
- 管理员：帐户开户、初始化、监测市场里的宠物价格分布、售卖次数、处理纠纷。
- 市场： 展示在售宠物列表

参考实现：

- 首先管理员在 ***链上*** 为一个人开户，出售人和购买人本质上都是自然人，其基本属性是名字和帐户余额，以及名下的宠物列表。
- 人可以创建一个宠物，一个宠物被创建后，挂接到一个人的名下，在被失效之前，就一直有效，宠物被创建时并没有价格
- 宠物上架时可以制定一个价格，被置为上架状态
- 宠物上架后可写入一个 ***市场合约***，所有人都可以看到
- 购买人选择市场里的宠物，发起购买，进入 ***交易合约***，交易合约判断有效状态，如果是在售的，就允许交易，否则拒绝，如果允许交易的，则判断购买人余额是否足够，进行扣款，并将款项写入出售人帐户，将宠物转给购买人。生成一个购买订单记录。
- 如果购买人觉得货不对板或售卖人反悔，可以发起仲裁，将相关信息全部发给监督员，审计人根据订单情况，进行仲裁（模拟），如果仲裁为交易无效，则冲正上述款项和宠物归属。可通过权限体系，使得只有监督员可以操作冲正接口。

参考基本合约列表

- 帐户管理合约
- 市场合约
- 交易合约
- 冲正管理合约

## 隐性需求

- 初始市场流动总金额：比如管理员拥有一百万，可一点一点发给用户
- 宠物拥有权转移后在买家列表显示为下架状态
- pet状态只有两个：上架和下架，删除或卖出后看不到pet
- 价格为整数
- 宠物总类：0其他 1狗 2猫 3仓鼠 4兔 5恐龙

## 前端页面

- 登录页面：选择普通用户或者管理员用户，输入账号密码
- 普通用户页面：显示名字，账户余额，自己的pet列表（pet状态可改）
- 管理员用户：显示名字，账户余额，用户列表（支持增改操作），仲裁列表（支持审判操作）
- 市场页面：显示已上架pet的图片名字种类价格（交易按钮）
- 创建宠物页面（宠物图片、宠物名称、宠物种类）
- 订单列表页面（提出审判）

## Work Flow

- 创建用户：管理员选择管理员身份登入系统，点击创建新用户，填写新用户的账号密码和初始货币
- 创建宠物：普通用户选择普通用户身份登入系统，点击创建宠物，上传宠物图片、宠物名称、宠物种类
- 购买宠物：普通用户选择普通用户身份登入系统，点击进入商城浏览宠物信息，点击发起交易，若积分足够则交易成功
- 上架宠物：点击上架，填入价格，宠物状态更改
- 发起仲裁：（普通）用户在订单页面点击发起仲裁，填写原因然后等待审判结果
- 审判：（管理员）点击通过或者驳回

## !important

- 用户session保存
- 用户权限
- imgUrl接口？或者本地？
- 时间格式
- 添加数据库储存用户名密码和picUrl

## 登录需求分析

- 用户使用用户名密码登录
- 后台数据库查询对应私钥登录区块链
- 登录成功保存session
- 数据库应只保存用户名和密码，不应保存credit

## 未完成

- pet竖向切割(Done: 改为合约操作)
- 研究拦截器进行权限匹配
- 是否去除复数实体(Done)
- 提取重复petlistjson为函数(Done)
- petlist分页(Done)
- 买卖家信息提取(Done)
- user模块中的seller(Done)
- pet全部加上owner(Done)
- 文件上传映射 (Done)
- 重新编写sql将user表中credit字段删除(Done)

## 问题

1. 宠物上架没有价格(Solve)
2. 宠物种类使用int吗(Solve)
3. 交易时间和上架时间(Solve)
4. UserController 登录不返回宠物信息

## 合约需求

1. 需要根据用户名查找用户id或者petlist
2. 管理员添加用户(Achieve)

## 0704 TODO

1. 登录拦截
2. 权限控制
3. 数据库环境
4. pet 模块请求更新
5. 服务器数据库库表的设置
6. 数据库加密保存
