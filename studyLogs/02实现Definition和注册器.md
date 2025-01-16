## 实现BeanDefinition和BeanDefinitionRegistry

### 实现BeanDefinition
通过观察 `changelog` 可知，其主要用于存储 `bean` 的类信息，为实现此功能，可采用 `Class` 进行存储，这种方式较为简单直观。

### 实现其他
依据 `changelog` 的内容，逐步完成继承关系的构建：

- **SingletonBeanRegistry**：作为最底层的单例注册器接口，它定义了单例注册器最基础的功能。原作者仅提供了获取单例对象的方法，然而，从完整性角度考虑，我认为有必要添加一个**新增单例对象**的方法，以便更全面地支持单例对象的管理。
- **DefaultSingletonBeanRegistry**：该类是单例注册器的默认实现，为存储 `BeanName` 和 `BeanObject` 的对应关系，使用 `HashMap` 作为存储结构，这是实际存储 `bean` 对象的位置。同时，它会实现上述接口中定义的方法。
- **BeanFactory**：此接口规定了 `bean` 工厂的标准方法，其中包含 `getBean`。根据我的理解，工厂的核心职责在于依据 `beanDefinition` 来生产 `bean`，用户无需直接干预工厂的运行流程。不过，我认为 `getBeanDefinition` 也应作为 `BeanFactory` 的成员函数，因为这是工厂应具备的一项重要功能，此部分暂未做改动。
- **AbstractBeanFactory**：这是 `BeanFactory` 的抽象实现，它实现了 `getBean` 方法，但将 `createBean` 方法设置为抽象方法，为子类提供扩展空间，允许子类根据自身需求进行具体实现。
- **AbstractAutowireCapableBeanRegistry**：该类进一步完善了 `AbstractBeanFactory` 的 `createBean` 方法。至此，仅 `BeanDefinition` 尚未完全实现，因此需要扩展一个 `BeanDefinitionRegistry` 来完善整个体系。
- **DefaultListableBeanFactory**：最终将在该类中实现全部功能。


### Tips
- 在 `AbstractAutowireCapableBeanFactory` 的 `doCreate` 方法中需要进行调整，由于使用的是 `jdk17`，所以要先获取无参构造，然后使用 `setAccess` 来规避安全检查。
- 顺便改了一下`test`，使它更能体现单例模式

这样的结构可以使代码的组织更加清晰，不同部分的功能和关系更加明确，便于开发人员理解和维护。同时，对于 `BeanDefinition` 和 `BeanDefinitionRegistry` 的实现，将根据上述的逻辑和设计思路逐步推进，确保代码的扩展性和可维护性。每个类在整个框架中都扮演着不同的角色，通过继承和接口实现的方式，既保证了功能的分层实现，又体现了设计模式的运用，为后续开发提供了良好的基础。