# orderingsystem
分布式的外卖订餐系统（未完成）
工程部署：
1.idea打开airspringclouddemo文件夹

2.idea会自动导入包等，手动选择1.8版本jdk

3.在navicat for mysql中创建数据库，到idea中的configsever里的menu-dev.yml中修改数据库名，用户名，密码

4.在MySQL Command Line Client界面登录数据库，然后输入set global time_zone='+8:00';修改时区以保证数据库连接成功

5.没有lombok的话需要安装，settings->plugins->搜索lombok->安装，annotation processors里的enable annotation processors勾上

6.按顺序启动 
configseverapplication，erukaseverapplication，menuapplication，userapplication，clientapplication

7.浏览器打开 http://localhost:8030/menu/redirect/index

主要接口：
增加菜品  http://localhost:8030/menu/findTypes

修改菜品  http://localhost:8030/menu/findById/5

菜谱主页面      http://localhost:8030/menu/redirect/index

显示菜谱  http://localhost:8020/menu/findAll/0/10

添加用户	http://localhost:8030/user/redirect/user_add

用户主页面	http://localhost:8030/user/redirect/user_manage

显示用户	http://localhost:8040/user/findAll/0/10

注册中心  http://localhost:8761/
