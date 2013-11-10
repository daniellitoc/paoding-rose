# paoding-rose #

因为项目需要，添加了几处修改。


## 附加功能 ##

1.模板配置路径。通过web.xml文件中filter元素的子元素。如下：

	<init-param>
		<param-name>viewPath</param-name>
		<param-value>/WEB-INF/template/</param-value>
	</init-param>

2.正式环境删除/rose-info的地址发布。通过web.xml文件中filter元素的子元素。如下：

	<init-param>
		<param-name>moduleResourceProviderClass</param-name>
		<param-value>org.danielli.xultimate.rose.scanner.LeastModuleResourceProviderImpl</param-value>
	</init-param>

3.支持Servlet 3.0。

4.支持ContextLoaderListener监听器与RoseFilter配合使用。因为需要在Listener中获取Spring定义的Bean。

