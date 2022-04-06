#!/bin/bash
# chkconfig: 2345 10 90
#服务必须在运行级2，3，4，5下被启动或关闭，启动的优先级是90，关闭的优先级是10。
# description: Start and Stop xxx
#在linux center6版本中，server.sh文件必须添加“source /etc/profile”配置
source /etc/profile
#在注册linux中注册自启动服务后，在服务文件中添加下列配置，解决运行日志无法生成的问题,更具具体位置配置路径
#cd /usr/local/ML-1.0/bin
#这里可替换为你自己的执行程序，其他代码无需更改
APP_NAME=/home/tomcat/java_project/data_quality/dqre-core
JAR_NAME=boot/spring-boot-demo.jar
#使用说明，用来提示输入参数
usage() {
    echo "Usage: sh 脚本名.sh [start|stop|restart|status]"
    exit 1
}

#检查程序是否在运行
is_exist(){
  pid=`ps -ef|grep $APP_NAME/$JAR_NAME|grep -v grep|awk '{print $2}' `
  #如果不存在返回1，存在返回0
  if [ -z "${pid}" ]; then
   return 1
  else
    return 0
  fi
}

#启动方法
start(){
  is_exist
  if [ $? -eq "0" ]; then
    echo "${APP_NAME}/${JAR_NAME} is already running. pid=${pid} ."
    echo "$APP_NAME/config/"
    echo "$APP_NAME/logs/log.file"
  else
    nohup java -jar -Dspring.config.location=$APP_NAME/config/ $APP_NAME/$JAR_NAME > $APP_NAME/bin/startLog.file 2>&1 &
    echo "${APP_NAME}/${JAR_NAME} start success"
  fi
}

#停止方法
stop(){
  is_exist
  if [ $? -eq "0" ]; then
    kill -9 $pid
  else
    echo "${APP_NAME}/${JAR_NAME} is not running"
  fi
}

#输出运行状态
status(){
  is_exist
  if [ $? -eq "0" ]; then
    echo "${APP_NAME}/${JAR_NAME} is running. Pid is ${pid}"
  else
    echo "${APP_NAME}/${JAR_NAME} is NOT running."
  fi
}

#重启
restart(){
  stop
  start
}

#根据输入参数，选择执行对应方法，不输入则执行使用说明
case "$1" in
  "start")
    start
    ;;
  "stop")
    stop
    ;;
  "status")
    status
    ;;
  "restart")
    restart
    ;;
  *)
    usage
    ;;
esac