package com.smart.service;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 服务支撑基础类
 * 
 * @author Sunxin
 *
 */
public class ServiceSupport {
	@Autowired
	protected UserService userService;
	
	@Autowired
	protected SelectTypeService selectTypeService;
	
	@Autowired
	protected SelectItemService selectItemService;
	
	@Autowired
	protected CaptchaService captchaService;
	
	@Autowired
	protected DocService docService;
	
	@Autowired 
	protected DictService dictService;
	
	@Autowired
	protected GalleryService galleryService;
	
	@Autowired
	protected GalleryItemService galleryItemService;
	
	@Autowired
	protected VerifyCodeService verifyCodeService;
	
	@Autowired
	protected FileService fileService;
	
	@Autowired
	protected InfoService infoService;
	
	@Autowired
	protected ImageService imageService;
	
	@Autowired
	protected SuggestionService suggestionService;

	@Autowired
	protected MenuService menuService;

	@Autowired
	protected InfoRecommendService infoRecommendService;

	@Autowired
	protected UserInfoService userInfoService;

	@Autowired
	protected ProductService productService;

	@Autowired
	protected HonorService honorService;

	@Autowired
	protected CompanyHistoryService companyHistoryService;

	@Autowired
	protected TagService tagService;

	@Autowired
	protected InfoTagService infoTagService;

	@Autowired
	protected SoftwareService softwareService;

	@Autowired
	protected InjectInfoService injectInfoService;

	@Autowired
	protected SeoPriceService seoPriceService;

	//== 这行注释不要删除, 代码生成器要用的 ==//
}
