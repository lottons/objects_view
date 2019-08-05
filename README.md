# objects_view
## 目标：
一种响应式交互服务的资源访问框架。

## 背景：
在基于服务架构体系中，无论是客户端、服务端交互，SOA架构，微服务架构。服务端提供的接口，由客户端基于服务端的接口定义进行访问。在我从事的所有项目中，无论是SOA架构还是微服务架构，几乎都是这种模式。这会导致客户端强依赖于服务端的定义，服务端提供的能力无法根据客户端的需要做出响应式的处理和返回。

典型的场景，例如在CRM系统中，客户的360视图界面。一种交互场景是，先提供一个客户订购的商品的列表信息，在具体的记录，可以查看该商品的详细定义信息。在这种场景下的一种可行的设计：后端提供一个根据客户id查询订购实例列表信息。同时，另一个服务是根据商品的信息查询商品的详情。页面在交互时，分别调用这两个服务获取相应的数据。

当然，另外一种设计是只提供一个服务，该服务根据客户id查询订购商品实例列表信息。返回的结果中会带有关联的商品的详细信息。这种设计，只需要一次交互就可以获取到所有的数据。当前端的交互发生变化，例如页面设计为卡片式，提供一个卡片列表，并在一个卡片中展示客户订购的商品基本信息，那么第二种可以更好的支持这种交互场景。但是，在这种情况下，会带来实际服务端返回的数据远远大于客户端需要的数据。因为卡片里面需要的仅仅是商品的基本信息，并不是全部。（之所以返回全部，是因为在其他交互场景中是需要返回全部信息。例如，在业务过程中需要根据客户订购的商品信息来做相关的校验等）。

响应式的资源服务访问的目的，就是可以由客户端来指定访问资源时，该如何返回资源，返回资源的哪些信息，以及该资源关联资源的信息。从原则上来说，是一种依赖倒置的设计原则。

在上面列举的场景例子中，无论哪种交互场景，都可以由客户端告知服务端需要资源的哪些数据。倒置，客户端不再依赖服务端，而是服务端依赖客户端。例如，第一种交互下。客户端告知服务端，只需要客户订购实例的id、offerid的列表。再通过另一个服务，告知服务端根据offerid获取offer的基本信息，如name、分类等。在第二种交互下，客户端可以告知服务端，需要客户订购实例的id、根据offerid关联的offer的基本信息，如name、分类等。


## 整体功能介绍：
1、接入层，服务接入

2、资源控制层，提供资源注册包括关联关系，资源访问提供对资源的访问，提供single模式、all模式、指定模式（指定树形嵌套层级）。控制层，是客户端和服务端响应式交互的基础。控制层提供响应式交互的模型，由客户端进行设置。在客户端没有进行响应式模型设置时，服务端具有默认的资源交互控制的设置能力，配置分为默认级、通用级配置、资源级配置、客户端级配置。其作用域为客户端级>资源级>通用级>默认级。默认级无需做出配置，由控制层内部控制。提供最小范围的访问控制策略。

3、资源访问层，控制资源的访问，根据控制层的控制策略，提供资源的访问。同时，构造客户端响应式的访问策略。负责将访问策略映射为具体底层资源操作的处理。例如，关系型数据库的SQL语句，OOM框架（Hibernater）的HQL语句等。同时，负责对资源访问策略的验证和鉴权。基于客户端访问信息的鉴权处理。
