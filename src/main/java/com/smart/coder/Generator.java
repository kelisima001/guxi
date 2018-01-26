

package com.smart.coder;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.smart.util.IOUtil;

import jodd.util.StringUtil;

public class Generator {
	public static String PROJ_ROOT = "D:/eclipse_mars/workspace/liangzi/";//D:/eclipse_mars/workspace/liangzi/
	public static String MODEL_DIR = PROJ_ROOT + "src/main/java/com/smart/model/";
	public static String DAO_DIR = PROJ_ROOT + "src/main/java/com/smart/dao/";
	public static String SERVICE_DIR = PROJ_ROOT + "src/main/java/com/smart/service/";
	public static String CONTROLLER_DIR = PROJ_ROOT + "src/main/java/com/smart/web/controller/";
	public static String ADMIN_VIEW_DIR = PROJ_ROOT + "WebContent/WEB-INF/views/admin/";
	public static String BASE_SERVICE = PROJ_ROOT + "src/main/java/com/smart/service/ServiceSupport.java";
	public static String NEW_SERVICE_PLACEHOLDER = "//== 这行注释不要删除, 代码生成器要用的 ==//";
	public static String NEW_SERVICE_PACKAGE_PLACEHOLDER = "//== 这行注释不要删除, 代码生成器要用的1 ==//";
	private static boolean override = false;
	
	public static void main(String[] args) throws IOException{
		
		
		String name = "SeoPrice";
		String varName = StringUtil.uncapitalize(name);
		InputStream in = null;
		String modelContent = null;
		ByteArrayInputStream in1 = null;
		OutputStream out1 = null;
		File dir = null;
		
		 
		in = Generator.class.getResourceAsStream("model.tpl");
		modelContent = IOUtil.toString(in);
		modelContent = modelContent.replaceAll("\\{name\\}", name);
		System.out.println(modelContent);;
		in1 = new ByteArrayInputStream(modelContent.getBytes());
		File f = new File(MODEL_DIR + name + ".java");
		if(f.exists() && !override){
			System.err.println(f.getAbsolutePath());
			System.err.println("================ The target files seems exist, please double check ===================");
			return;
		}
		
		out1 = new FileOutputStream(MODEL_DIR + name + ".java");
		IOUtil.copy(in1,  out1);
		
		in = Generator.class.getResourceAsStream("model.cond.tpl");
		modelContent = IOUtil.toString(in);
		modelContent = modelContent.replaceAll("\\{name\\}", name);
		System.out.println(modelContent);;
		in1 = new ByteArrayInputStream(modelContent.getBytes());
		out1 = new FileOutputStream(MODEL_DIR + name + "Cond.java");
		IOUtil.copy(in1,  out1);
		
		in = Generator.class.getResourceAsStream("dao.interface.tpl");
		modelContent = IOUtil.toString(in);
		modelContent = modelContent.replaceAll("\\{name\\}", name);
		System.out.println(modelContent);;
		in1 = new ByteArrayInputStream(modelContent.getBytes());
		out1 = new FileOutputStream(DAO_DIR + name + "Dao.java");
		IOUtil.copy(in1,  out1);
		
		in = Generator.class.getResourceAsStream("dao.impl.tpl");
		modelContent = IOUtil.toString(in);
		modelContent = modelContent.replaceAll("\\{name\\}", name);
		System.out.println(modelContent);;
		in1 = new ByteArrayInputStream(modelContent.getBytes());
		out1 = new FileOutputStream(DAO_DIR + name + "DaoImpl.java");
		IOUtil.copy(in1,  out1);
		
		in = Generator.class.getResourceAsStream("service.interface.tpl");
		modelContent = IOUtil.toString(in);
		modelContent = modelContent.replaceAll("\\{name\\}", name);
		System.out.println(modelContent);;
		in1 = new ByteArrayInputStream(modelContent.getBytes());
		out1 = new FileOutputStream(SERVICE_DIR + name + "Service.java");
		IOUtil.copy(in1,  out1);
		
		in = Generator.class.getResourceAsStream("service.impl.tpl");
		modelContent = IOUtil.toString(in);
		modelContent = modelContent.replaceAll("\\{name\\}", name);
		System.out.println(modelContent);;
		in1 = new ByteArrayInputStream(modelContent.getBytes());
		out1 = new FileOutputStream(SERVICE_DIR + name + "ServiceImpl.java");
		IOUtil.copy(in1,  out1);
		
		
		in = Generator.class.getResourceAsStream("controller.tpl");
		modelContent = IOUtil.toString(in);
		modelContent = modelContent.replaceAll("\\{name\\}", name);
		modelContent = modelContent.replaceAll("\\{varName\\}", varName);
		System.out.println(modelContent);;
		in1 = new ByteArrayInputStream(modelContent.getBytes());
		out1 = new FileOutputStream(CONTROLLER_DIR + name + "Controller.java");
		IOUtil.copy(in1,  out1);
		
		
		in = Generator.class.getResourceAsStream("list.jsp");
		modelContent = IOUtil.toString(in);
		modelContent = modelContent.replaceAll("\\{name\\}", name);
		modelContent = modelContent.replaceAll("\\{varName\\}", varName);
		System.out.println(modelContent);;
		in1 = new ByteArrayInputStream(modelContent.getBytes());
		dir = new File(ADMIN_VIEW_DIR + varName + "/");
		if(!dir.exists()){
			dir.mkdirs();
		}
		out1 = new FileOutputStream(ADMIN_VIEW_DIR + varName + "/" + "list.jsp");
		IOUtil.copy(in1,  out1);
		
		
		in = Generator.class.getResourceAsStream("edit.jsp");
		modelContent = IOUtil.toString(in);
		modelContent = modelContent.replaceAll("\\{name\\}", name);
		modelContent = modelContent.replaceAll("\\{varName\\}", varName);
		System.out.println(modelContent);;
		in1 = new ByteArrayInputStream(modelContent.getBytes());
		dir = new File(ADMIN_VIEW_DIR + varName + "/");
		if(!dir.exists()){
			dir.mkdirs();
		}
		out1 = new FileOutputStream(ADMIN_VIEW_DIR + varName + "/" + "edit.jsp");
		IOUtil.copy(in1,  out1);
		
		in = new FileInputStream(BASE_SERVICE);
		modelContent = IOUtil.toString(in);
		//modelContent = modelContent.replaceAll(NEW_SERVICE_PACKAGE_PLACEHOLDER, "import com.smart.service."+ name +"Service;\n" + NEW_SERVICE_PACKAGE_PLACEHOLDER);
		modelContent = modelContent.replaceAll(NEW_SERVICE_PLACEHOLDER, "@Autowired\n\tprotected "+ name +"Service "+varName+"Service;\n\n\t" + NEW_SERVICE_PLACEHOLDER);
		in1 = new ByteArrayInputStream(modelContent.getBytes());
		out1 = new FileOutputStream(BASE_SERVICE);
		IOUtil.copy(in1,  out1);
	}
}
