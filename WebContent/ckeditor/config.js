/**
 * @license Copyright (c) 2003-2017, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function(config) {
	
	   // 界面语言，默认为 'en'  
	   //config.language = 'zh-cn';  
	   // 设置宽高  
	   //config.width = 400;  
	   //config.height = 400;  
	   // 编辑器样式，有三种：'kama'（默认）、'office2003'、'v2'  
	   // 背景颜色  
	   //config.uiColor = '#FFF';  
	   // 工具栏（基础'Basic'、全能'Full'、自定义）ckeditor/ckeditor.js  
	   //config.toolbar = 'Basic';  
	   config.toolbar = 'Full';
	   // 这将配合：  
	   config.toolbar_Full = [  
	   ['Source','-','Save','NewPage','Preview','-','Templates'],  
	   ['Cut','Copy','Paste','PasteText','PasteFromWord','-','Print', 'SpellChecker', 'Scayt'],  
	   ['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat'],  
	   ['Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button', 'ImageButton', 'HiddenField'],  
	   '/',  
	   ['Bold','Italic','Underline','Strike','-','Subscript','Superscript'],  
	   ['NumberedList','BulletedList','-','Outdent','Indent','Blockquote'],  
	   ['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],  
	   ['Link','Unlink','Anchor'],  
	   ['Image','Table','HorizontalRule','Smiley','SpecialChar','PageBreak'],  
	   '/',  
	   ['Styles','Format','Font','FontSize'],  
	   ['TextColor','BGColor']  
	   ];  
	   // 工具栏是否可以被收缩  
	   config.toolbarCanCollapse = true;  
	   
	
	//CKFinder
	config.filebrowserBrowseUrl = 'ckfinder/ckfinder.html';
	config.filebrowserImageBrowseUrl = 'ckfinder/ckfinder.html?type=Images';
	//config.filebrowserFlashBrowseUrl = 'resources/ckfinder/ckfinder.html?type=Flash';
	config.filebrowserUploadUrl = 'ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files';
	config.filebrowserImageUploadUrl = 'ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images';
	//config.filebrowserFlashUploadUrl = '../ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Flash';
};
