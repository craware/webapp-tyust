# webapp-tyust 分布式系统 
## 主要用于将自己所学汇总 ##
### 已整合技术点:
   * 1.dubbox+zookeeper实现分布式服务协调治理,将服务单独部署,可结合nginx+keeplived实现负载均衡;
   * 2.结合SpringMvc,spring容器,自定义定时任务,redis缓存控制;
   * 3.jdbc+oracle数据存储,使用jdbc主要是为了自己写sql好控制;
   * 4.fastdfs:实现文件的存储;
   * 5.netty + kyro 实现消息的序列化传输;
   * 6.shell编写启动脚本;

### 待实现的技术点:
   * 1.准备使用netty+Protostuff/kyro自定义rpc框架;
   * 2.整合RocketMq消息传输;
   * 3.多数据源的使用;
   * 4....