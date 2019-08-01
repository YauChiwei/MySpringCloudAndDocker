#基于那个镜像
FROM java:8

#将本地文件挂载到当前容器
VOLUME /tmp

#复制文件到容器
ADD microservice-discovery-eureka-1.0.0-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'

#生命需要暴露的端口
EXPOSE 8761

#配置容器启动后执行的命令
ENTRYPOINT ["java", "-jar", "/app.jar"]

#格式：docker build -t 仓库名称/镜像名称(:标签) Dockerfile的相对位置
#docker build -t teecon/microservice-discovery-eureka:1.0.0 .