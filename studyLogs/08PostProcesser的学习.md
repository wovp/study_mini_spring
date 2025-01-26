# BeanPostProcessor 和 BeanFactoryPostProcessor 学习

## BeanFactoryPostProcessor
### 功能概述
`BeanFactoryPostProcessor` 用于在 Bean 被初始化之前，对 `BeanDefinition` 进行修改。通过编写测试用例，能够实现一个简单的 `CustomBeanFactoryProcessor`。

### 继承与方法调用问题
在使用 `BeanFactoryPostProcessor` 时，需要传入 `ConfigurableListableBeanFactory` 接口。不过该接口未直接提供某些所需方法，比如 `getBeanDefinition` 方法。为了解决这个问题，需要将此方法向上迁移。

在 `AbstractBeanFactory` 抽象类中，存在一个 `protected` 修饰的 `getBeanDefinition` 方法。在 `DefaultListableBeanFactory` 中，可以直接对该方法进行重载。需要注意的是，子类方法的访问限制要比父类方法更宽松。

## BeanPostProcessor
### 功能概述
`BeanPostProcessor` 用于在 Bean 初始化前后执行一些额外操作。因此，需要将 Bean 初始化的过程进行隔离处理。

### 实现步骤
1. **修改 `createBean` 方法**：在 `AbstractAutowireCapableBeanFactory` 类中，对 `createBean` 方法进行修改，将初始化流程添加进去。
2. **遍历处理器**：遍历所有的 `BeanPostProcessor`，并调用相应方法。需要将这些处理器存储在一个 `List` 中，可选择在 `AbstractBeanFactory` 类里完成存储操作。
3. **简化处理逻辑**：原作者在循环遍历 `BeanPostProcessor` 时，一旦某个处理器将 Bean 处理为 `null`，就会终止处理器处理过程，并返回原来的 Bean。这里对该过程进行了简化，不再采用交替赋值的方式。
4. **新增接口方法**：原作者新增了一些接口方法，具体如下：
    - `factory.ConfigurableBeanFactory.addBeanPostProcessor`
    - `factory.AutowireCapableBeanFactory#applyBeanPostProcessorsBeforeInitialization`
    - `factory.AutowireCapableBeanFactory#applyBeanPostProcessorsAfterInitialization`
    - `factory.AbstractAutowireCapableBeanFactory.invokeInitMethods`
      这些接口方法的目的是统一类型，将不同的方法进行归类管理。
5. **新增初始化方法**：原作者还新增了 `factory.AbstractAutowireCapableBeanFactory.initializeBean` 方法，其作用是方便完成 Bean 的初始化过程。 