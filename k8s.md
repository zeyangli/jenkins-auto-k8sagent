
[TODO]  kubernetes API


## agent 启动逻辑
1. 部署一个deployment， 自动缩容；
2. 动态创建Slave节点；


1. 调用接口创建一个POD;
2. 将Jenkins作业调度到该POD；
3. 运行CI/CD

属性：
podMaxCount=5
podWaitTime=50m [next]



```
curl -X GET https://192.168.1.200:6443/api --header "Authorization: Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IllPWEE5NGw4eEszcnNkbzFOS2JaSG5vb0Z4V0EtZ1dGSWxBcGRzZkRJb1EifQ.eyJpc3MiOiJrdWJlcm5ldGVzL3NlcnZpY2VhY2NvdW50Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9uYW1lc3BhY2UiOiJkZWZhdWx0Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9zZWNyZXQubmFtZSI6InpleWFuZy10b2tlbiIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VydmljZS1hY2NvdW50Lm5hbWUiOiJ6ZXlhbmdzYSIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VydmljZS1hY2NvdW50LnVpZCI6IjNmYzdkNDVmLTk5ZjYtNDBhYS05ZjJhLTgyNzc4Yzc1ZjYzYyIsInN1YiI6InN5c3RlbTpzZXJ2aWNlYWNjb3VudDpkZWZhdWx0OnpleWFuZ3NhIn0.njoY6v4J2SCiSMRbSW0BwaMLS5SJsdyXMaVE03uFs9rBP1E0Zc1XaPZ6fB37_QC78j8ic7DGqysLYgpe3BIp8SK89hnaEJkLJFuGwwwJ6QrjN2czbWTK4dy_dmylybREL7DvXpa8YIGNg8sCNmmTJZiCVoqVWBUtHmVQGWjS-CufLfBR44awvJxkuTiA5ggZ3CYZc9ger3XHgtIN9T-YJ2KQuWqiQBNnPhoExa7mHjcJhqtbu3wO-1EKqlzMPpG_cAJgY78XRJOC4N0IjNdkjgi2sbduVrKswlDoOVe1cywQGHF5N6D8HbDtmU_KOudMOFjyDHqb8L1ED6D8XMxuUg" --insecure
```


端口转发：
firewall-cmd --zone=public --add-port=6443/tcp --permanent 
firewall-cmd --zone=public --add-forward-port=port=6666:proto=tcp:toport=35921:toaddr=127.0.0.1  --permanent

firewall-cmd --reload
firewall-cmd --zone=public --list-ports

firewall-cmd --zone= public --remove-port=6666/tcp --permanent




## postman 关闭SSL验证（右上角settings）
