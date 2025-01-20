# 实现 `InstantiationStrategy`

依据类图，抽取出 `instantiate` 实例化方法。此后，分别运用无参构造的方式生成Bean（`simpleInstantiationStrategy`），以及通过Cglib动态代理来生成Bean（`Cglib`）。

## 修改 `AbstractAutowireCapableBeanFactory` 实例化方法

将实例化需求融入到 `Factory` 中，如此一来，用户便能够自主选择所使用的实例化策略。

## 补充测试程序

对原作者的Cglib测试程序予以补充，操作过程较为简便。

## Cglib在JDK17环境下的兼容性问题

鉴于安全控制方面的因素，Cglib需要借助反射来访问受保护的类，然而在JDK17中，这一行为是被明令禁止的。对此，我们可采取临时添加 `addopen` 的方式予以解决，或者选用其他字节码增强插件（如 `Byte Buddy`）。 