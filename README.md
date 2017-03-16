# account
校园记账 APP 的 后台
#怎么样跑这个项目
1.直接在tomcat下跑
2.在 maven 中 用 jetty 跑 9999端口
#已经整合的功能
ssm 框架整合、
日志功能 logback、
生成图片验证码、
邮件发送功能、
增加token (防止表单重复提交、验证用户身份等)、
#推荐用jetty跑
#未实现功能(＠￣ー￣＠)
缓存功能(redis)
整合freemaker (web html的渲染)、
sitemesh 页面装饰的引用！(web html页面的装饰)、
自封装文件上传的功能(建议用七牛云)
权限管理 shiro
全文检索 solr 、 luncene
用户密码 Md5 加盐操作