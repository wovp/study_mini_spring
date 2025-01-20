## 实现InstantiationStrategy
根据类图，提取出instantiate实例化方法，然后分别用无参构造bean（simpleInstantiationStrategy）和Cglib动态代理生成bean（Cglib）

### 修改AbstractAutowireCapableBeanFactory实例化方法
把实例化需求嵌入Factory中，让用户可以选择使用的实例化策略

### 补充测试程序
补充一下原作者的Cglib的测试程序，很简单。

### Cglib在jdk17环境下不兼容
因为安全控制原因，cglib需要通过反射访问受保护的类，这在jdk17中是被禁止的。我们可以临时添加addopen，或者使用其他的字节码增强插件(byte buddy)