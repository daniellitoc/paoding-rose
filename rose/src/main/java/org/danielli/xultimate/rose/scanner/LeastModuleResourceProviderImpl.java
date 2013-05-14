package org.danielli.xultimate.rose.scanner;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import net.paoding.rose.scanner.ModuleResource;
import net.paoding.rose.scanner.ModuleResourceProviderImpl;
import net.paoding.rose.scanning.LoadScope;

/**
 * {@code ModuleResourceProviderImpl}发布/rose-info地址，该资源提供器将删除此URL。
 * 
 * @author Daniel Li
 * @since 13 Jun 2013
 * @see net.paoding.rose.scanner.ModuleResourceProviderImpl
 */
public class LeastModuleResourceProviderImpl extends ModuleResourceProviderImpl {

	/**
	 * "/rose-info"为paoding-rose自动发布地址，在生产环境中，需要删除此地址。
	 */
	private final String ROSE_INFO_URL = "/rose-info";
	
	
	@Override
	public List<ModuleResource> findModuleResources(LoadScope arg0) throws IOException {
		List<ModuleResource> moduleResourceList = super.findModuleResources(arg0);
		synchronized (moduleResourceList) {
			Iterator<ModuleResource> iterator = moduleResourceList.iterator();
			while (iterator.hasNext()) {
				ModuleResource moduleResource = iterator.next();
				// 删除"/rose-info"发布地址。
				if (StringUtils.equals(ROSE_INFO_URL, moduleResource.getMappingPath())) {
					iterator.remove();
				}
			}
		}
		return moduleResourceList;
	}
}
