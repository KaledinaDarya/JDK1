package by.http.web.pattern;

import by.http.web.service.CatalogService;
import by.http.web.service.impl.CatalogServiceImpl;

public class SingletonCatalog {
	
	private static SingletonCatalog _singletonCatalog = null;
	
	private static CatalogService catalogService;
	
	private SingletonCatalog() {
		catalogService = new CatalogServiceImpl();
	}
	
	public static SingletonCatalog getSingletonCatalog() {
		if (_singletonCatalog == null) {
			_singletonCatalog = new SingletonCatalog();
		}
		return _singletonCatalog;
	}

	public CatalogService getCatalogService() {
		return catalogService;
	}
}
