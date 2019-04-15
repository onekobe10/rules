package com.gankki.demo.portal.rules.controller;

import com.gankki.demo.portal.rules.model.User;
import com.gankki.demo.portal.rules.service.impl.RulesService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;*/

@Controller
public class Test {
	
	//private final static Logger logger = LoggerFactory.getLogger(Test.class);
	
	@Value("${ORDER_BASE_URL}")
	private String CREATE_ORDER;
	
	@Autowired
	private RulesService rulesService;
	
	
	public void testFile (MultipartFile file, String username, String password){
		
	}
	@RequestMapping("test")
	public String test(HttpServletResponse res,Model model) throws Exception{
		/*model.addAttribute("sss", "dfsd");
		model.addAttribute("test", "");
		model.addAttribute("test1", "{\"name\":\"liuhao\",\"name\":\"123456\"}");
		model.addAttribute("test2", "");*/
		/*List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		List<PortalRules> testList = this.rulesService.selectRulesByList(list);*/
		/*
		List<PortalRules> testList = this.rulesService.selectRulesByArray(arrs);*/
		/*String[] arrs = {"1","2","3"};
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("testMap", arrs);
		map.put("testMap1", "d");
		List<PortalRules> testList = this.rulesService.selectRulesByMap(map);*/
		//List<PortalRules> testList = this.rulesService.selectAllRules();
		/*PortalRules rules = new PortalRules();
		rules.setTheme("sssssss");;
		rules.setProductType("voice");
		rules.setIntroduce("ddd");
		List<PortalRules> testList = this.rulesService.selectRulesByObject(rules);*/
		
/*		List<PortalRules> testList = this.rulesService.selectRulesByCreateDate(date);
		List<String> testList = this.rulesService.selectRulesByGroup(date);
*/		//String date = "rules";
		/*int testInt = (Integer) null;
		String integer = this.rulesService.selectTestUser(testInt);
		System.out.println(integer+"...........");*/
		//String update = null;
		
		//this.rulesService.updateRulesByTest(update);
		
		//int i = (Integer) null;
		//this.rulesService.updateRuesByAge(i);
		
		User user = new User();
		user.setId("12313");
		user.setUsername("liuhao");
		
		//this.rulesService.insertUserByTest(user);
		
		/*List<User> testList = this.rulesService.selectUserByTest(user);
		System.out.println(testList.size());
		
		model.addAttribute("test", "test");
		model.addAttribute("test1", null);*/
		return "test";
	}
	
	@RequestMapping("test3")
	public String test3(HttpServletResponse res,Model model) throws Exception{
		this.rulesService.updateRulesByTest("liuhao2");
		return "test";
	}
	@RequestMapping("test2")
	public void test2(HttpServletResponse req,HttpServletResponse res,String mobiles,String messageContent) throws Exception{
//		model.addAttribute("test", "haha;\r\nsfsdf");
//		System.out.println(this.CREATE_ORDER);
		req.setCharacterEncoding("UTF-8");  
		System.out.println(mobiles+"ssss...............");
		System.out.println("\n");
		System.out.println(new String(messageContent));
		JSONObject jo = new JSONObject();
		jo.element("flag", "success");//success,fail
		res.setContentType("application/json;chatset=utf-8");
		res.getWriter().print(jo.toString());
	}
	
	/*public static void main(String[] args) {
		
		System.out.println(test());
		AtomicInteger ai = new AtomicInteger();
	}*/
	
	@SuppressWarnings("finally")
	public static String test() {
		
		try {
			String ss = "123";
			System.out.println(1);
			throw new IOException();
		} catch (Exception e) {
			e.printStackTrace();
			return "456";
		} finally {
			return "789";
		}
		
		
		
	}
	
	/*@RequestMapping("logger")
	public String testLoger(String[] args) {
		从高到地低 OFF 、 FATAL 、 ERROR 、 WARN 、 INFO 、 DEBUG 、 TRACE 、 ALL
		logger.trace("logerback TRACE 成功了");
		logger.debug("logerback debug 成功了");
		logger.info("logback info 成功了");
		logger.warn("logback warn 成功了");
		logger.error("logback error 成功了");
		
		return "test";
	}*/
	
	/*public static void main(String[] args) throws Exception {
		int a = -1;
		assert(a > 1);
		System.out.println(a);
		LinkedList<String> linkedList = new LinkedList<>();
		linkedList.add(5, "123");
		linkedList.get(1);
		ArrayList<String> array = new ArrayList<>();
		array.get(1);
		HashMap<String, String> map = new HashMap<>();
		map.get("123");
		
		HashSet<String> set = new HashSet<>();
		set.contains("1235");
		
		TreeSet<String> treeSet = new TreeSet<>();
		treeSet.contains("123");
		
		ThreadLocal<String> tl = new ThreadLocal<>();
		tl.get();
		Thread thread = new Thread();
		
		Hashtable<String, String> table;
		BitSet bitSet;
		Stack<String> stack;
		Properties properties;
		Vector<String> vector;
		LinkedList<String> list = new LinkedList<>();
		list.add("123");
		java.util.Collections.synchronizedList(list);
		Class.forName("dd");
		
		AtomicInteger ai = new AtomicInteger();
		
		ConcurrentHashMap<String, String> ch = new ConcurrentHashMap<>();
		Map<String, String> linkMap = new LinkedMap();
		linkMap.put("123", "123");
		LinkedMap linkedMap = new LinkedMap();
		//linkedMap.put(key, value)
	}*/
	
	/*public static void main(String[] args) {
		char c = '我';
		System.out.println(c);
		String test = "abcde";
		System.out.println(Test.reverse(test));
	}*/
	
	/*public static String reverse(String str) {
		if (str == null || str.length() < 1) {
			return str;
		} else {
			return reverse(str.substring(1)) + str.charAt(0);
		}
	}*/
	
	/*public static void main(String[] args) {
		String s1 = new StringBuilder("go").append("od").toString();
		System.out.println(s1.intern() == s1);
		String s2 = new StringBuilder("ja").append("va").toString();
		System.out.println(s2.intern() == s2);
		String s3 = new StringBuilder("ja1").append("va1").toString();
		System.out.println(s3.intern() == s3);
		String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);//false
        System.out.println(s1 == s5);//true
        System.out.println(s1 == s6);//false*
        System.out.println(s1 == s6.intern());//true
        System.out.println(s2 == s2.intern());//false
        System.out.println(s5 == s6.intern());//true
        
	}
	*/
	/*public static void main(String[] args) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(df.format(new Date()));
		System.out.println(df1.format(new Date()));
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str1 = "2018-12-12 13:11:00";
		String str2 = "2018-12-12 13:12:00";
		System.out.println(df.parse(str2).getTime() - df.parse(str1).getTime());
		
	}*/
	
	/*public static void main(String[] args) {
		List<String> strings = new ArrayList<String>();
		strings.add("123");
		strings.add("456");
		strings.add("789");
		strings.add("000");
		for (String string : strings) {
			string = "123456";
		}
		for (String string : strings) {
			System.out.println(string);
		}
	}*/
	
/*	public static void main(String[] args) {
		String str = "3";
		String regExp = "[0-9]{1,}";  
		
		Pattern p = Pattern.compile(regExp);  
		
		Matcher m = p.matcher(str);
		System.out.println(m.matches());
	}
*/	
	/*public static void main(String[] args) {
		String string = "abcdefg";
		System.out.println(string.indexOf("c"));
		System.out.println(string.substring(0, 2));
		String mobiles = "1,2,3,4,5,6";
		StringBuilder sb = new StringBuilder();
		if (mobiles != null)
		{
			String[] strMoiblesArray = mobiles.split(",");
			for (int i = 0; i < strMoiblesArray.length; i++)
			{
				if (i == 0)
				{
					sb = sb.append(strMoiblesArray[i] + ",");
				}
				else if (-1 == sb.indexOf(strMoiblesArray[i] + ","))
				{
					 sb.append(strMoiblesArray[i] + ",");
				}
			}
			sb.deleteCharAt(sb.length()-1);
		}
		System.out.println(sb.toString());
		JSONArray outJa = new JSONArray();
		JSONArray innJa = new JSONArray();
		List<Map<String, String>> maps = new ArrayList<Map<String,String>>();
		Map<String, String> map = new HashMap<String, String>();
		map.put("USERNAME", "AAA");
		map.put("USERPHONE", "123456");
		JSONArray innJa1 = new JSONArray();
		List<Map<String, String>> maps1 = new ArrayList<Map<String,String>>();
		Map<String, String> map1 = new HashMap<String, String>();
		Map<String, String> map2 = new HashMap<String, String>();
		Map<String, String> map3 = new HashMap<String, String>();
		
		map1.put("USERNAME", "AAA");
		map1.put("USERPHONE", "123456");
		map3.put("DEPTtName", "haha");
		map2.put("USERNAME", "AAA");
		map2.put("USERPHONE", "123456");
		maps.add(map);
		innJa.add(maps);
		maps1.add(map3);
		maps1.add(map1);
		maps1.add(map2);
		innJa1.add(maps1);
		outJa.add(maps);
		outJa.add(maps1);
		System.out.println(outJa.toString());
	}*/
	
	
	public static void main(String[] args){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE, 16);
		Calendar calendar1 = Calendar.getInstance();
		calendar1.set(Calendar.DATE, calendar1.getActualMaximum(Calendar.DATE));
		Date date = calendar.getTime();
		Date date1 = calendar1.getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar nextMonthFirstDate = Calendar.getInstance();
		nextMonthFirstDate.add(Calendar.MONTH, 1);
		nextMonthFirstDate.set(Calendar.DATE, 1);
		Date date2 = nextMonthFirstDate.getTime();
		System.out.println(dateFormat.format(date));
		System.out.println(dateFormat.format(date1));
		System.out.println(dateFormat.format(date2));
		String str = "varchar(255) COMMENT '集资方式'";
		System.out.println(str.indexOf("'"));
		System.out.println(str.lastIndexOf("'"));
		System.out.println(str.substring(str.indexOf("'") + 1, str.lastIndexOf("'")));
	}


}
