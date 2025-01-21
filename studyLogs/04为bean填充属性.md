## 为 Bean 填充属性

### 实现思路
- 首先，需要创建一个 `PropertyValues` 类，该类的成员中应包含一个 `PropertyValue` 用于存储字段名和属性。
- 接着，在 `BeanDefinition` 中，需要遍历 `PropertyValues` 的字段名和属性。
- 然后，利用反射机制将这些属性注入到 `bean` 对象中。
- 最后，由于填充属性的操作应该在实例化之后进行，所以此操作需要放置在 `AbstractAutowireFactory` 内。


### 详细说明

#### PropertyValues 类
- 此 `PropertyValues` 类是专门为存储 `bean` 的属性信息而设计的。
- 它的成员 `PropertyValue` 会以某种形式存储字段名称及其对应的属性值，为后续将这些属性注入到 `bean` 对象中提供必要的数据基础。


#### BeanDefinition 类的修改
- 在 `BeanDefinition` 中，需要实现对 `PropertyValues` 的遍历功能。
- 对于存储在 `PropertyValues` 中的每个 `PropertyValue`，即字段名称和属性值的组合，将使用反射来访问和修改 `bean` 对象的相应字段。
- 反射操作将根据存储的字段名称找到 `bean` 对象中的相应字段，然后将对应的属性值设置进去。


#### AbstractAutowireFactory 中的实现
- 因为 `bean` 的填充属性操作应该在实例化之后执行，所以将该操作放在 `AbstractAutowireFactory` 中是合理的。
- 在 `AbstractAutowireFactory` 中，会调用 `BeanDefinition` 中修改后的功能，对已实例化的 `bean` 对象进行属性填充。
- 这将确保 `bean` 对象在创建完成后，能正确地被赋予相应的属性，使其达到完整的可用状态。


通过上述步骤，可以实现对 `bean` 的属性填充操作，保证 `bean` 不仅能够被正确实例化，还能拥有完整的属性信息，提高 `bean` 的可配置性和功能性。这样的实现结构使得代码更加清晰，模块间的功能划分更加明确，有助于开发人员更好地理解和维护代码。同时，将属性填充操作放在 `AbstractAutowireFactory` 中，可以保证 `bean` 的实例化和属性填充流程的有序性和连贯性，遵循了 `bean` 生命周期的逻辑顺序。

这种设计方式不仅增强了 `bean` 的可定制性，还可以更好地适应不同的应用场景和配置需求，为整个系统的开发和扩展提供了便利。在后续的开发过程中，还可以根据具体的需求对 `PropertyValues` 的存储结构和 `BeanDefinition` 的处理逻辑进行进一步的细化和优化，以实现更加复杂和灵活的属性注入功能。