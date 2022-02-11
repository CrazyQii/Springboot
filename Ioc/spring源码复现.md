## Ioc

### 一、创建容器

1. 前置： Spring Bean 容器是什么

Spring 包含并管理应用对象的配置和生命周期，是一种用于承载对象的容器，我们能够配置每个 bean 对象是如何创建的

如果一个 bean 交给 Spring 容器管理，那么这个 bean 就需要被拆解存放到 Bean 的定义中，相当于是对象解耦的方式

当一个 Bean 对象被定义存放后，再由 Spring 统一进行装配

**定义一个简单的Bean容器，用于定义、存放和获取bean对象**

2. 设计

一个简单的 Spring Bean 容器实现，还需 Bean 的定义、注册、获取三个基本步骤

- 定义：BeanDefinition，可能这是你在查阅 Spring 源码时经常看到的一个类，例如它会包括 singleton、prototype、BeanClassName 等。但目前我们初步实现会更加简单的处理，只定义一个 Object 类型用于存放对象。
- 注册：这个过程就相当于我们把数据存放到 HashMap 中，只不过现在 HashMap 存放的是定义了的 Bean 的对象信息。
- 获取：最后就是获取对象，Bean 的名字就是key，Spring 容器初始化好 Bean 以后，就可以直接获取了。





## 其他

HashMap线程不安全，在并发的场景下不能使用Hashmap

HashTabe线程安全，但是竞争激烈的场景下，效率低下，原因是所有访问HashTable的线程都必须竞争同一把锁

ConcurrentHashMap使用锁分段技术，能够有效解决上面的缺点



2. idea查看类依赖关系

   - ctrl + H （结构）
   - ctrl + alt+ U （图）

3. 单例模式

   - 单例模式（Singleton Pattern）是 Java 中最简单的设计模式之一。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。

     这种模式涉及到一个单一的类，该类负责创建自己的对象，同时确保只有单个对象被创建。这个类提供了一种访问其唯一的对象的方式，可以直接访问，不需要实例化该类的对象。

4. 