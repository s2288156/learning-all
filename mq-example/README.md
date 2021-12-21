# Rocket MQ

### 安装

```shell
cd rocketmq-all-4.9.2/
mvn -Prelease-all -DskipTests clean install -U
cd distribution/target/rocketmq-4.9.2/rocketmq-4.9.2
# 启动namesrv
nohup sh bin/mqnamesrv &
tail -f ~/logs/rocketmqlogs/namesrv.log
# 启动broker
nohup sh bin/mqbroker -n localhost:9876 &
tail -f ~/logs/rocketmqlogs/broker.log 
```
