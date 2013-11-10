# paoding-rose #

因为项目需要，添加了几处修改。


## 附加功能 ##

* 模板配置路径。通过web.xml文件中filter元素的子元素
	<init-param>
		<param-name>viewPath</param-name>
		<param-value>/WEB-INF/template/</param-value>
	</init-param>
  实现。
* 支持Servlet 3.0。
* 正式环境删除/rose-info的地址发布。通过web.xml文件中filter元素的子元素
	<init-param>
		<param-name>moduleResourceProviderClass</param-name>
		<param-value>com.binzhi.controllers.scanner.SimpleModuleResourceProviderImpl</param-value>
	</init-param>
  实现。
* 支持org.springframework.web.context.ContextLoaderListener监听器与RoseFilter配合使用。因为可能在Listener中需要获取Spring定义的Bean。

